package com.example.dailyeconomicflow.service;

import com.example.dailyeconomicflow.pojo.User;

import java.util.Map;

public interface UserService {
    /**
     * 新增
     */
    public Object insert(User user);

    /**
     * 删除
     */
    public String delete(int id);

    /**
     * 更新
     */
    public String update(User user);

    /**
     * 根据主键 id 查询
     */
    public User load(int id);

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize);
}
