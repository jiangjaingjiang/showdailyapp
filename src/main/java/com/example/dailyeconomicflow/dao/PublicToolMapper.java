package com.example.dailyeconomicflow.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PublicToolMapper {

    /*
     * @Title:
     * @Description:
     * @Param null:
     * @Return: null
     * @Author: Zengjt
     * @Date: 2022/11/10 16:15
     */

    int backupsTool(@Param(value = "tableName") String tableName);

    int backupsInsertTool(@Param(value = "tableName") String tableName);

    int clearTableByYearTool(@Param(value = "yearInt") Integer yearInt);



}
