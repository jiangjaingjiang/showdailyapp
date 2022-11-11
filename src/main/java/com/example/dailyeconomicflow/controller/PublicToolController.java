package com.example.dailyeconomicflow.controller;

import com.example.dailyeconomicflow.pojo.AcceptData;
import com.example.dailyeconomicflow.pojo.ReturnInfo;
import com.example.dailyeconomicflow.service.PublicToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Title:
 * @Description:
 * @Param:
 * @Return:
 * @Author: ZengJT
 * @Updatedate: 2022/11/10 14:25
 */
@RestController
@RequestMapping("/PublicTool")
public class PublicToolController {
    @Autowired
    PublicToolService publicToolService;
    /*
     * @Title:手动备份的按钮
     * @Description:
     * @Param acceptData:
     * @Return: com.example.dailyeconomicflow.pojo.CrossDomainInfo
     * @Author: Zengjt
     * @Date: 2022/11/10 14:51
     */
    @RequestMapping("/backupsTool")
    public ReturnInfo backupsTool (@RequestBody Map<String, String> map){
        ReturnInfo returnInfo = new ReturnInfo();
        String flag = publicToolService.backupsToolService("1");
        returnInfo.setRetMsg(flag);
        return returnInfo;
    }
}
