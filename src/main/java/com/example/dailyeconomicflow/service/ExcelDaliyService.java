package com.example.dailyeconomicflow.service;

import com.example.dailyeconomicflow.pojo.ReturnInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;

@Service
public interface ExcelDaliyService {

    public ReturnInfo getExcelInfos(String fileName, MultipartFile file) throws IOException, ParseException;

}
