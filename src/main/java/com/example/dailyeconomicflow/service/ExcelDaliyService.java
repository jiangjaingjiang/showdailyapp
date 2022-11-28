package com.example.dailyeconomicflow.service;

import com.example.dailyeconomicflow.pojo.ReturnInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;

@Service
public interface ExcelDaliyService {

    /*
     * @Title: 纯纯新增
     * @Description:
     * @Param null:
     * @Return: null
     * @Author: Zengjt
     * @Date: 2022/11/25 17:21
     */
    public ReturnInfo getExcelInfos(String fileName, MultipartFile file) throws IOException, ParseException;

    /*
     * @Title: 有就更新没有就新增
     * @Description:
     * @Param null:
     * @Return: null
     * @Author: Zengjt
     * @Date: 2022/11/25 17:21
     */
    public ReturnInfo getExcelInfosUORA(String fileName, MultipartFile file) throws IOException, ParseException;

}
