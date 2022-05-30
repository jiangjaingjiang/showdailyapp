package com.example.dailyeconomicflow.controller;

import com.example.dailyeconomicflow.pojo.ReturnInfo;
import com.example.dailyeconomicflow.service.ExcelDaliyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ExcelDaliyController {
    @Autowired
    private ExcelDaliyService excelDaliyService;
    @RequestMapping("/importDaliy")
    public String fileImportDaliy(@RequestParam("file") MultipartFile file, Model model) throws Exception {

        String fileName = file.getOriginalFilename();
        ReturnInfo ReturnInfo = excelDaliyService.getExcelInfos(fileName,file);
        model.addAttribute("retInfo",ReturnInfo);
        return "infoz";

    }
}
