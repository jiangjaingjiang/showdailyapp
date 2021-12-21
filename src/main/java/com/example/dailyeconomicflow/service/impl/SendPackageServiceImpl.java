package com.example.dailyeconomicflow.service.impl;

import com.example.dailyeconomicflow.pojo.Category;
import com.example.dailyeconomicflow.pojo.Categorys;
import com.example.dailyeconomicflow.pojo.CrossDomainInfo;
import com.example.dailyeconomicflow.pojo.Data;
import com.example.dailyeconomicflow.service.CategorysService;
import com.example.dailyeconomicflow.service.SendPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class SendPackageServiceImpl implements SendPackageService {
    @Autowired
    CategorysService categorysService;

    @Override
    public CrossDomainInfo sendtest(Categorys categorys) {
        //测试数据
        CrossDomainInfo crossDomainInfo = new CrossDomainInfo();
        Data data = new Data();
        List<Categorys> categoryList = new ArrayList<>();
        //--------------------
        Category category = new Category();
        category.setId(1);
        category.setIcon("1");
        category.setPrice(BigDecimal.TEN);
        category.setBookId(1);
        category.setRemark("11");
        category.setRecordType("1");
        //---------------------
        Category category2 = new Category();
        category2.setId(2);
        category2.setIcon("2");
        category2.setPrice(BigDecimal.TEN);
        category2.setBookId(1);
        category2.setRemark("11");
        category2.setRecordType("0");

//        categoryList.add(category);
//        categoryList.add(category2);
        data.setCount(2);
        Integer i = 0;
        if(categorys.getRecordType()!=null){
            i = categorys.getRecordType();
        }
        categoryList = categorysService.pageListWithParam(i);
        data.setCategorys(categoryList);
        data.setIncomeAmount(BigDecimal.valueOf(11));
        data.setPayAmount(BigDecimal.valueOf(10));
        //获取后台数据

        //对数据进行处理

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
        data.setCategorys(categorysList);
        crossDomainInfo.setData(data);

        //放入传输的实体内
        return crossDomainInfo;
    }
}
