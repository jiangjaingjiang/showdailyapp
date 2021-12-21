package com.example.dailyeconomicflow.service;

import com.example.dailyeconomicflow.pojo.Categorys;
import com.example.dailyeconomicflow.pojo.CrossDomainInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public interface SendPackageService {

    public CrossDomainInfo sendtest(Categorys categorys);

    public CrossDomainInfo addCategory(Categorys categorys);

    public CrossDomainInfo getCategoryList(Integer recordType);
}
