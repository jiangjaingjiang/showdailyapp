package com.example.dailyeconomicflow.dao;

import com.example.dailyeconomicflow.pojo.TallyMain;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description 记账主表
 * @author zhengkai.blog.csdn.net
 * @date 2021-12-07
 */
@Mapper
@Repository
public interface TallyMainMapper {

    /**
     * 新增
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/07
     **/
    int insert(TallyMain tallyMain);

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
    int update(TallyMain tallyMain);

    /**
     * 查询 根据主键 id 查询
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/07
     **/
    TallyMain load(int id);

    /**
     * 查询 分页查询
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/07
     **/
    List<TallyMain> pageList(int offset, int pagesize);

    /**
     * 查询 分页查询 count
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/07
     **/
    int pageListCount(int offset,int pagesize);
    /**
     * 循环新增多个
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/07
     **/
    int addTallyMain (List<TallyMain> list);
    /**
     * 查询 月份总数
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/07
     **/
    List<TallyMain> getAmountList(int porm,String selectDate);
    /**
     * 存在就更新不存在就新增
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/07
     **/
    int insertOrUpdateBatch(List<TallyMain> list);

}
