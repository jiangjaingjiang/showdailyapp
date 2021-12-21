package com.example.dailyeconomicflow.service;

import com.example.dailyeconomicflow.pojo.Categorys;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @description 图标类型
 * @author zhengkai.blog.csdn.net
 * @date 2021-12-18
 */

@Service
public interface CategorysService {

    /**
     * 新增
     */
    public Object insert(Categorys categoryTable);

    /**
     * 删除
     */
    public Object delete(int id);

    /**
     * 更新
     */
    public Object update(Categorys categoryTable);

    /**
     * 根据主键 id 查询
     */
    public Categorys load(int id);

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize);
    /**
     * 带数据查询
     */
    public List<Categorys> pageListWithParam(int recordType);

}
