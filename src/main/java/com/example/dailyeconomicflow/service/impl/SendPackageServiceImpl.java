package com.example.dailyeconomicflow.service.impl;

import com.example.dailyeconomicflow.pojo.*;
import com.example.dailyeconomicflow.service.CategorysService;
import com.example.dailyeconomicflow.service.SendPackageService;
import com.example.dailyeconomicflow.service.TallyMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SendPackageServiceImpl implements SendPackageService {
    @Autowired
    CategorysService categorysService;
    @Autowired
    TallyMainService tallyMainService;

    @Override
    public CrossDomainInfo getAccountingList(AcceptData acceptData) {
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

    @Override
    public CrossDomainInfo addCategory(Categorys categorys) {
        //先建立返回值
        CrossDomainInfo crossDomainInfo = new CrossDomainInfo();
        //调用service
//        Categorys categorys = new Categorys();
//        categorys.setCategoryName(categoryName);
//        int i = categorys.getRecordType();
//        int is = Integer.valueOf(i);
//        categorys.setRecordType(is);
//        int is = 0 ;
//        categorys.setRecordType(is);
//        categorys.setIconClassName(iconClassName);
        categorysService.insert(categorys);

        return crossDomainInfo;
    }

    @Override
    public CrossDomainInfo getCategoryList(Integer recordType) {
        CrossDomainInfo crossDomainInfo = new CrossDomainInfo();
        //获取返回值
        List<Categorys> categorysList = categorysService.pageListWithParam(recordType);
        Data data = new Data();
        data.setCategoryList(categorysList);
        crossDomainInfo.setData(data);

        //放入传输的实体内
        return crossDomainInfo;
    }

    @Override
    public CrossDomainInfo getAmount(AcceptData acceptData) {
        CrossDomainInfo crossDomainInfo = new CrossDomainInfo();
        Data data = new Data();
        //掏出前端给的数据
        Integer recordYear = acceptData.getRecordYear();
        Integer recordMonth = acceptData.getRecordMonth();
        //拿入参月份和年份去数据库拿支出总数
        Map<String,Object> resultPay = tallyMainService.getAmountList(-1,recordYear,recordMonth);
        BigDecimal pay = new BigDecimal(resultPay.get("Amount").toString());
        //拿入参月份和年份去数据库拿支收入总数
        Map<String,Object> resultMinus = tallyMainService.getAmountList(1,recordYear,recordMonth);
        BigDecimal minus = new BigDecimal(resultMinus.get("Amount").toString());
        //封装传参
        data.setPayAmount(pay);
        data.setIncomeAmount(minus);
        crossDomainInfo.setData(data);
        return crossDomainInfo;
    }
}
