package com.example.dailyeconomicflow.service;

import com.example.dailyeconomicflow.pojo.AcceptData;
import com.example.dailyeconomicflow.pojo.Categorys;
import com.example.dailyeconomicflow.pojo.CrossDomainInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public interface SendPackageService {

    public CrossDomainInfo getAccountingList(AcceptData acceptData);

    public CrossDomainInfo addCategory(Categorys categorys);

    public CrossDomainInfo getCategoryList(Integer recordType);

    /*
     * @Title: getAmount
     * @Description: 获取该年份月份总的支出和收入
     * @Param acceptData:
     * @Return: com.example.dailyeconomicflow.pojo.CrossDomainInfo
     * @Author: Zengjt
     * @Date: 2021/12/22 11:04
     */
    public CrossDomainInfo getAmount(AcceptData acceptData);
}
