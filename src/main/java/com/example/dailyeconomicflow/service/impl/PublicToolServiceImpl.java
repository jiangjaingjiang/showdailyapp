package com.example.dailyeconomicflow.service.impl;

import com.example.dailyeconomicflow.dao.PublicToolMapper;
import com.example.dailyeconomicflow.pojo.ReturnInfo;
import com.example.dailyeconomicflow.service.PublicToolService;
import com.example.dailyeconomicflow.util.DateUtil;
import jdk.nashorn.internal.ir.IdentNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Map;

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
    public ReturnInfo backupsToolService(String tableName) {
        ReturnInfo returnInfo = new ReturnInfo();
        //获取当前时间
       String nowDate = DateUtil.getNowDateForStringyMdHms();
        //拼接表名
        String newtableName = "tally_main_bak_"+nowDate;
        System.out.println(newtableName);
        //调用创建备份表
        int intFlag = publicToolMapper.backupsTool(newtableName);
        //调用导入备份数据
        int intFlag2 = publicToolMapper.backupsInsertTool(newtableName);
        //返回语句
        String returnMsg = "建表成功返回值-"+String.valueOf(intFlag)+"- ,成功备份数据总数为-"+String.valueOf(intFlag2)+" - 。";

        returnInfo.setRetMsg(returnMsg);
        returnInfo.setRetFlag(0);
        return returnInfo;
    }

    @Override
    public ReturnInfo clearTableByYearToolService(String passString) {
        ReturnInfo returnInfo = new ReturnInfo();
        //把传入的年份转化成数字
        Integer yearInt = Integer.parseInt(passString);
        //执行清空这个年份的数据
        int flagInt = publicToolMapper.clearTableByYearTool(yearInt);
        //返回语句
        String retrunMsg = "成功清理掉了关于-"+passString+"-年份的数据,清理的总数量为-"+String.valueOf(flagInt)+"-。";
        returnInfo.setRetMsg(retrunMsg);
        returnInfo.setRetVal(0);
        return returnInfo;
    }
}
