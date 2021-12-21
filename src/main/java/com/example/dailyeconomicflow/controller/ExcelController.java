package com.example.dailyeconomicflow.controller;

import com.example.dailyeconomicflow.pojo.ReturnInfo;
import com.example.dailyeconomicflow.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ExcelController {
    @Autowired
    private ExcelService excelService;

    @RequestMapping("/import")
    public String fileImport(@RequestParam("file") MultipartFile file, Model model) throws Exception {

        String fileName = file.getOriginalFilename();
        ReturnInfo ReturnInfo = excelService.getExcelInfo(fileName, file);
        model.addAttribute("retInfo",ReturnInfo);
        return "info";
    }

    @RequestMapping("/loadPage")
    public String loadPage() {
        return "index";
    }


}
