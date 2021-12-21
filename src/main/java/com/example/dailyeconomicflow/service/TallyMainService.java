package com.example.dailyeconomicflow.service;

import com.example.dailyeconomicflow.pojo.TallyMain;

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

}
