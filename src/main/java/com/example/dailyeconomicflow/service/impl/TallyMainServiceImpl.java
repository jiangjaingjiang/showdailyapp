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


    @Override
    public Map<String,Object> getAmountList(int porm, int recordYear, int recordMonth) {
        String selectDate = recordYear+"-"+recordMonth+"-01";
        List<TallyMain> getAmountList = tallyMainMapper.getAmountList(porm,selectDate);
        //统计总金额
        BigDecimal Amount = BigDecimal.ZERO;
        for (TallyMain tallyMain : getAmountList) {
            Amount = Amount.add(tallyMain.getTradingMoney());
        }
        Map<String,Object> result = new HashMap<>();
        result.put("Amount",Amount);
        return result;
    }
}
