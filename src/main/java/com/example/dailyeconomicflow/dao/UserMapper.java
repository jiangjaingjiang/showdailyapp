package com.example.dailyeconomicflow.dao;

import com.example.dailyeconomicflow.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    /**
     * 新增
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/07
     **/
    int insert(User user);

    /**
     * 刪除
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/07
     **/
    int delete(int id);

    /**
     * 更新
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/07
     **/
    int update(User user);

    /**
     * 查询 根据主键 id 查询
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/07
     **/
    User load(int id);

    /**
     * 查询 分页查询
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/07
     **/
    List<User> pageList(int offset,int pagesize);

    /**
     * 查询 分页查询 count
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/07
     **/
    int pageListCount(int offset,int pagesize);

    /**
     * 新增
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/07
     **/
    int addUser(List<User> list);

}
