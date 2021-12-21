package com.example.dailyeconomicflow.controller;

import com.example.dailyeconomicflow.pojo.User;
import com.example.dailyeconomicflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 新增
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/07
     **/
    @RequestMapping("/insert")
    public Object insert(User user){
        return userService.insert(user);
    }

    /**
     * 刪除
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/07
     **/
    @RequestMapping("/delete")
    public String delete(int id){
        return userService.delete(id);
    }

    /**
     * 更新
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/07
     **/
    @RequestMapping("/update")
    public String update(User user){
        return userService.update(user);
    }

    /**
     * 查询 根据主键 id 查询
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/07
     **/
    @RequestMapping("/load")
    public Object load(int id){
        return userService.load(id);
    }

    /**
     * 查询 分页查询
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/07
     **/
    @RequestMapping("/pageList")
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return userService.pageList(offset, pagesize);
    }
    /**
     * 查询 分页查询
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/07
     **/
    @RequestMapping("/testuser")
    public Object testuser(@RequestParam(required = false) int id){
        return userService.load(id);
    }
}
