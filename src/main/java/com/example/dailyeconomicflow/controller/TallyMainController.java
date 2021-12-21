package com.example.dailyeconomicflow.controller;

import com.example.dailyeconomicflow.pojo.TallyMain;
import com.example.dailyeconomicflow.service.TallyMainService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping(value = "/tallyMain")
public class TallyMainController {

    @Resource
    private TallyMainService tallyMainService;

    /**
     * 新增
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/07
     **/
    @RequestMapping("/insert")
    public Object insert(TallyMain tallyMain){
        return tallyMainService.insert(tallyMain);
    }

    /**
     * 刪除
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/07
     **/
    @RequestMapping("/delete")
    public String delete(int id){
        return tallyMainService.delete(id);
    }

    /**
     * 更新
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/07
     **/
    @RequestMapping("/update")
    public String update(TallyMain tallyMain){
        return tallyMainService.update(tallyMain);
    }

    /**
     * 查询 根据主键 id 查询
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/07
     **/
    @RequestMapping("/load")
    public Object load(int id){
        return tallyMainService.load(id);
    }

    /**
     * 查询 分页查询
     * @author zhengkai.blog.csdn.net
     * @date 2021/12/07
     **/
    @RequestMapping("/pageList")
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return tallyMainService.pageList(offset, pagesize);
    }

}