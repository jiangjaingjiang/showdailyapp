package com.example.dailyeconomicflow.controller;

import com.example.dailyeconomicflow.pojo.AcceptData;
import com.example.dailyeconomicflow.pojo.Categorys;
import com.example.dailyeconomicflow.pojo.CrossDomainInfo;
import com.example.dailyeconomicflow.service.SendPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/needData")
public class SendPackageController {
    @Autowired
    SendPackageService sendPackageService;

    @RequestMapping("/shendteset")
    public CrossDomainInfo sendTest(@RequestBody AcceptData acceptData){
        CrossDomainInfo crossDomainInfo = new CrossDomainInfo();

        crossDomainInfo = sendPackageService.sendtest(acceptData);
        return crossDomainInfo;
    }
    //新增记账类别
    @PostMapping(value="/addCategory",produces = "application/json;charset=UTF-8")
    public CrossDomainInfo addCategory(@RequestBody Categorys categorys){

        CrossDomainInfo crossDomainInfo = new CrossDomainInfo();
        crossDomainInfo = sendPackageService.addCategory(categorys);

        return crossDomainInfo;
    }
    //获取类别列表
    @RequestMapping("/getCategoryList")
    public CrossDomainInfo getCategoryList (@RequestBody AcceptData acceptData){
        CrossDomainInfo crossDomainInfo = new CrossDomainInfo();
//        Integer integer = Integer.valueOf(recordType);
        crossDomainInfo = sendPackageService.getCategoryList(acceptData.getRecordType());
        return crossDomainInfo;
    }

    @RequestMapping("/getAmount")
    public CrossDomainInfo getAmount (@RequestBody AcceptData acceptData){
        CrossDomainInfo crossDomainInfo = new CrossDomainInfo();

        crossDomainInfo = sendPackageService.getAmount(acceptData);

        return crossDomainInfo;
    }
}
