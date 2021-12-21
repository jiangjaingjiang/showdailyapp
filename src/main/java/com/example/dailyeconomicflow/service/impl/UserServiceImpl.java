package com.example.dailyeconomicflow.service.impl;

import com.example.dailyeconomicflow.dao.UserMapper;
import com.example.dailyeconomicflow.pojo.User;
import com.example.dailyeconomicflow.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;


    @Override
    public Object insert(User user) {

        // valid
        if (user == null) {
            return "error(必要参数缺失)";
        }

        userMapper.insert(user);
        return "success";
    }


    @Override
    public String delete(int id) {
        int ret = userMapper.delete(id);
        return ret>0?"success":"error";
    }


    @Override
    public String update(User user) {
        int ret = userMapper.update(user);
        return ret>0?"success":"error";
    }


    @Override
    public User load(int id) {return userMapper.load(id);}


    @Override
    public Map<String,Object> pageList(int offset, int pagesize) {
        List<User> pageList = userMapper.pageList(offset, pagesize);
        int totalCount = userMapper.pageListCount(offset, pagesize);

        // resultx
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);

        return result;
    }
}
