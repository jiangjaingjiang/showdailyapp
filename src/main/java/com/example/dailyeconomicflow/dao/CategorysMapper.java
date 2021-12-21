package com.example.dailyeconomicflow.dao;

import com.example.dailyeconomicflow.pojo.Categorys;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @description 图标类型
 * @author zhengkai.blog.csdn.net
 * @date 2021-12-18
 */
@Mapper
@Repository
public interface CategorysMapper {

    /**
     * 新增
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/18
     **/
    int insert(Categorys categoryTable);

    /**
     * 刪除
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/18
     **/
    int delete(int id);

    /**
     * 更新
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/18
     **/
    int update(Categorys categoryTable);

    /**
     * 查询 根据主键 id 查询
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/18
     **/
    Categorys load(int id);

    /**
     * 查询 分页查询
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/18
     **/
    List<Categorys> pageList(int offset, int pagesize);

    /**
     * 查询 分页查询 count
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/18
     **/
    int pageListCount(int offset,int pagesize);

    /**
     * 查询 带参数分页查询
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/18
     **/
    List<Categorys> pageListWithParamList(int recordType);


}
