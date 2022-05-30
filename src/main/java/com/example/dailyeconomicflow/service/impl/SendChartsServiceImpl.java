package com.example.dailyeconomicflow.service.impl;

import com.example.dailyeconomicflow.pojo.*;
import com.example.dailyeconomicflow.service.SendChartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Title:
 * @Description:
 * @Param:
 * @Return:
 * @Author: ZengJT
 * @Updatedate: 2022/1/13 14:23
 */
@Service
public class SendChartsServiceImpl implements SendChartsService {
    @Autowired
    TallyMainServiceImpl tallyMainService;
    @Override
    public CrossDomainInfo getChartDataByYearAndMonth(AcceptData acceptData) {
        //创建返回的实体
        CrossDomainInfo crossDomainInfo = new CrossDomainInfo();
        Data data = new Data();
        List<Acc> accList = new ArrayList<>();
        Acc acc = new Acc();
        Content content = new Content();
        //掏出前端给的数据
        Integer recordYear = acceptData.getRecordYear();
        Integer recordMonth = acceptData.getRecordMonth();
        //获取后台数据
        List<TallyMain> tallyMaintList = tallyMainService.getTallyMaintList(0,recordYear,recordMonth);
        //对数据进行处理
        for (TallyMain tallyMain: tallyMaintList) {
            List<Content> contentList = new ArrayList<>();
            //取出这个月的最后一天
            //设置循环判断到哪一天
            //把日期等于这一天的支出金额相加
            //处理时间
            Date tradingTimeDate = tallyMain.getTradingTime();
            SimpleDateFormat sdf =new SimpleDateFormat("dd" );
            String tradingTimeString = sdf.format(tradingTimeDate);
            acc.set_id(tradingTimeString);
            content.set_id(tradingTimeString);
            //处理金额
            Integer plusOrMinusInteger = tallyMain.getPlusOrMinus();
            BigDecimal tradingMoneyBigDecimal = new BigDecimal(tallyMain.getTradingMoney().toString());
            content.setPrice(tradingMoneyBigDecimal);
            if (0<plusOrMinusInteger){
                acc.setIncomeAmount(tradingMoneyBigDecimal);
                acc.setPayAmount(BigDecimal.ZERO);
                content.setRecordType(1);
            }else {
                acc.setPayAmount(tradingMoneyBigDecimal);
                acc.setIncomeAmount(BigDecimal.ZERO);
                content.setRecordType(0);
            }
            content.setTitle("饮食");
            content.setIcon("icon-yundong");
            contentList.add(content);
            acc.setContent(contentList);
            accList.add(acc);
            //清空实体
            acc = new Acc();
            content = new Content();
            
        }
        //加入总数
        data.setCount(accList.size());
        data.setAccList(accList);
        //打包放入实体
        crossDomainInfo.setData(data);
        crossDomainInfo.setStatus(200);
        crossDomainInfo.setErrMsg("获取成功");
        return crossDomainInfo;
    }
}
