package com.example.dailyeconomicflow.service.impl;

import com.example.dailyeconomicflow.dao.PublicToolMapper;
import com.example.dailyeconomicflow.pojo.ReturnInfo;
import com.example.dailyeconomicflow.service.PublicToolService;
import com.example.dailyeconomicflow.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

/**
 * @Title:
 * @Description:
 * @Param:
 * @Return:
 * @Author: ZengJT
 * @Updatedate: 2022/11/10 15:08
 */
@Service
public class PublicToolServiceImpl implements PublicToolService {
    @Autowired
    PublicToolMapper publicToolMapper;

    @Override
    public String backupsToolService(String tableName) {
        ReturnInfo returnInfo = new ReturnInfo();
        //获取当前时间
       String nowDate = DateUtil.getNowDateForStringyMdHms();
        //拼接表名
        String newtableName = "tally_main_"+nowDate;
        System.out.println(newtableName);
        //调用创建备份表
        int intFlag = publicToolMapper.backupsTool(newtableName);
        //调用导入备份数据
        int intFlag2 = publicToolMapper.backupsInsertTool(newtableName);
        //返回语句
        String returnMsg = "建表成功返回值-"+String.valueOf(intFlag)+"- ,成功备份数据总数为-"+String.valueOf(intFlag2)+" - 。";
        return returnMsg;
    }
}
