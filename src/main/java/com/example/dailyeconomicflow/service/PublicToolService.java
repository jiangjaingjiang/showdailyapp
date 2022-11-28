package com.example.dailyeconomicflow.service;

import com.example.dailyeconomicflow.pojo.ReturnInfo;

import java.util.Map;

/**
 * @Title:
 * @Description:
 * @Param:
 * @Return:
 * @Author: ZengJT
 * @Updatedate: 2022/11/10 15:05
 */
public interface PublicToolService {
    /*
     * @Title:根据当前日期备份一份表
     * @Description:
     * @Param null:
     * @Return: null
     * @Author: Zengjt
     * @Date: 2022/11/11 14:48
     */
    public ReturnInfo backupsToolService (String tableName);
    /*
     * @Title:把表格根据年份清空
     * @Description:
     * @Param null:
     * @Return: null
     * @Author: Zengjt
     * @Date: 2022/11/11 14:48
     */
    public ReturnInfo clearTableByYearToolService(String passString);
}
