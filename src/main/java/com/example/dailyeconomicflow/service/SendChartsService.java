package com.example.dailyeconomicflow.service;

import com.example.dailyeconomicflow.pojo.AcceptData;
import com.example.dailyeconomicflow.pojo.CrossDomainInfo;
import org.springframework.stereotype.Service;

/**
 * @Title:
 * @Description:
 * @Param:
 * @Return:
 * @Author: ZengJT
 * @Updatedate: 2022/1/13 14:18
 */
@Service
public interface SendChartsService {
    /*
     * @Title: getChartDataByYearAndMonth
     * @Description:用年份和月份获取当前图表需要的x轴和y轴的数据
     * @Param acceptData:
     * @Return: com.example.dailyeconomicflow.pojo.CrossDomainInfo
     * @Author: Zengjt
     * @Date: 2022/1/13 14:25
     */
    public CrossDomainInfo getChartDataByYearAndMonth (AcceptData acceptData);
}
