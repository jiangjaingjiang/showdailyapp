package com.example.dailyeconomicflow.service.impl;

import com.example.dailyeconomicflow.dao.CategorysMapper;
import com.example.dailyeconomicflow.pojo.Categorys;
import com.example.dailyeconomicflow.service.CategorysService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategorysServiceImpl implements CategorysService {

    @Resource
    private CategorysMapper categorysMapper;


    @Override
    public Object insert(Categorys categorys) {

        // valid
        if (categorys == null) {
             return "error(必要参数缺失)";
        }

        categorysMapper.insert(categorys);
        return "success";
    }


    @Override
    public Object delete(int id) {
        int ret = categorysMapper.delete(id);
        return ret>0?"success":"error";
    }


    @Override
    public Object update(Categorys categorys) {
        int ret = categorysMapper.update(categorys);
        return ret>0?"success":"error";
    }


    @Override
    public Categorys load(int id) {
        return categorysMapper.load(id);
    }


    @Override
    public Map<String,Object> pageList(int offset, int pagesize) {

        List<Categorys> pageList = categorysMapper.pageList(offset, pagesize);
        int totalCount = categorysMapper.pageListCount(offset, pagesize);

        // result
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);

        return result;
    }

    @Override
    public List<Categorys> pageListWithParam(int recordType) {

        List<Categorys> pageList = categorysMapper.pageListWithParamList(recordType);

        return pageList;
    }
}
