package com.example.dailyeconomicflow.service.impl;

import com.example.dailyeconomicflow.dao.TallyMainMapper;
import com.example.dailyeconomicflow.pojo.TallyMain;
import com.example.dailyeconomicflow.service.TallyMainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TallyMainServiceImpl implements TallyMainService {

    @Resource
    private TallyMainMapper tallyMainMapper;


    @Override
    public Object insert(TallyMain tallyMain) {

        // valid
        if (tallyMain == null) {
            return "error(必要参数缺失)";
        }
        tallyMainMapper.insert(tallyMain);
        return "success";
    }


    @Override
    public String delete(int id) {
        int ret = tallyMainMapper.delete(id);
        return ret>0?"success":"error";
    }


    @Override
    public String update(TallyMain tallyMain) {
        int ret = tallyMainMapper.update(tallyMain);
        return ret>0?"success":"error";
    }


    @Override
    public TallyMain load(int id) {
        return tallyMainMapper.load(id);
    }


    @Override
    public Map<String,Object> pageList(int offset, int pagesize) {

        List<TallyMain> pageList = tallyMainMapper.pageList(offset, pagesize);
        int totalCount = tallyMainMapper.pageListCount(offset, pagesize);

        // result
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);

        return result;
    }

    /*
     * @Title:getAmountList
     * @Description: 查询该月份的所有数据 porm = 0 就是查收入和支出一起
     * @Param porm:
     * @Param recordYear:
     * @Param recordMonth:
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Zengjt
     * @Date: 2021/12/22 14:52
     */
    @Override
    public Map<String,Object> getAmountList(int porm, int recordYear, int recordMonth) {
        List<TallyMain> getAmountList = this.getTallyMaintList(porm, recordYear, recordMonth);
        //统计总金额
        BigDecimal Amount = BigDecimal.ZERO;
        for (TallyMain tallyMain : getAmountList) {
            Amount = Amount.add(tallyMain.getTradingMoney());
        }
        Map<String,Object> result = new HashMap<>();
        result.put("Amount",Amount);
        return result;
    }
    /*
     * @Title:getTallyMaintList
     * @Description:查询这个年份月份下的数据用
     * @Param porm:
     * @Param recordYear:
     * @Param recordMonth:
     * @Return: java.util.List<com.example.dailyeconomicflow.pojo.TallyMain>
     * @Author: Zengjt
     * @Date: 2022/1/13 14:43
     */
    @Override
    public List<TallyMain> getTallyMaintList(int porm, int recordYear, int recordMonth) {
        String selectDate = recordYear+"-"+recordMonth+"-01";
        List<TallyMain> getTallyMaintList = tallyMainMapper.getAmountList(porm,selectDate);
        return getTallyMaintList;
    }
}
