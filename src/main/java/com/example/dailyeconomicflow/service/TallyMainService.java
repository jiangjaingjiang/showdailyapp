package com.example.dailyeconomicflow.service;

import com.example.dailyeconomicflow.pojo.TallyMain;

import java.util.List;
import java.util.Map;

/**
 * @description 记账主表
 * @author zhengkai.blog.csdn.net
 * @date 2021-12-07
 */
public interface TallyMainService {

    /**
     * 新增
     */
    public Object insert(TallyMain tallyMain);

    /**
     * 删除
     */
    public String delete(int id);

    /**
     * 更新
     */
    public String update(TallyMain tallyMain);

    /**
     * 根据主键 id 查询
     */
    public TallyMain load(int id);

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize);

    /**
     * 查询月份总数
     */
    public Map<String,Object> getAmountList (int porm,int recordYear,int recordMonth);
    /*
     * @Title:getTallyMaintList
     * @Description: 查询该月份的所有数据 porm = 0 就是查收入和支出一起
     * @Param porm:
     * @Param recordYear:
     * @Param recordMonth:
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Zengjt
     * @Date: 2021/12/22 14:52
     */
    public List<TallyMain> getTallyMaintList (int porm,int recordYear,int recordMonth);

}
