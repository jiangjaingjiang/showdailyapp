package com.example.dailyeconomicflow.service.impl;

import com.example.dailyeconomicflow.dao.TallyMainMapper;
import com.example.dailyeconomicflow.pojo.ReturnInfo;
import com.example.dailyeconomicflow.pojo.TallyMain;
import com.example.dailyeconomicflow.service.ExcelDaliyService;
import com.example.dailyeconomicflow.util.ExcelUtil;
import com.example.dailyeconomicflow.util.ReturnUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ExcelDaliyServiceImpl implements ExcelDaliyService {
    @Autowired
    TallyMainMapper tallyMainMapper;

    /**
     *
     * @param fileName
     * @param file
     * @return
     * @throws Exception
     */
    @Override
    public ReturnInfo getExcelInfos(String fileName, MultipartFile file) throws IOException, ParseException {
        ReturnInfo ReturnInfo = new ReturnInfo();
        //要将表中的哪几列传入数据库中，从0开始计数
        int[] resultCell = new int[]{0,2,3,4,5,6,7,8,9,10,11,12};
        List<TallyMain> resultList = new ArrayList<>();
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            return ReturnUtil.error("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        resultList = getSheetVal(sheet, resultCell);
        System.out.println("结果集---"+resultList);
        try{
            tallyMainMapper.addTallyMain(resultList);
            ReturnInfo = ReturnUtil.success("");
        }catch (Exception e){
            e.printStackTrace();
            ReturnInfo = ReturnUtil.error("数据导入失败");
        }
        return ReturnInfo;
    }

    /**
     *
     * @param sheet
     * @param resultCell 需要将哪些列插入至数据库
     * @return
     */
    public List getSheetVal(Sheet sheet, int[] resultCell) throws ParseException {
        //返回的结果集
        List<TallyMain> tallyMainsList = new ArrayList<>();
        //返回的实体
        TallyMain tallyMain;
        //循环遍历
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            tallyMain = new TallyMain();
            for (int i = 0;i<row.getPhysicalNumberOfCells();i++){
                for (int j=0;j<resultCell.length;j++){
                    if (i==resultCell[j]){
                        switch (i){
                            case 0:
                                Date tradingTime = ExcelUtil.getDate(row.getCell(i));
                                tallyMain.setTradingTime(tradingTime);
                                break;
                            case 2:
                                tallyMain.setTradingSource((ExcelUtil.getCellVal(row.getCell(i))).toString().trim());
                                break;
                            case 3:
                                tallyMain.setCollectOrBranch((ExcelUtil.getCellVal(row.getCell(i))).toString().trim());
                                break;
                            case 4:
                                tallyMain.setStatePayment((ExcelUtil.getCellVal(row.getCell(i))).toString().trim());
                                break;
                            case 5:
                                tallyMain.setTradingType((ExcelUtil.getCellVal(row.getCell(i))).toString().trim());
                                break;
                            case 6:
                                tallyMain.setTradingOther((ExcelUtil.getCellNoNull(row.getCell(i))));
                                break;
                            case 7:
                                tallyMain.setTradingCommodity((ExcelUtil.getCellVal(row.getCell(i))).toString().trim());
                                break;
                            case 8:
                                BigDecimal tradingMoney = ExcelUtil.getBigDecimalCell(row.getCell(i));
                                tallyMain.setTradingMoney(tradingMoney);
                                break;
                            case 9:
                                double dbl = Double.parseDouble((ExcelUtil.getCellVal(row.getCell(i))).toString());
                                int intgr = (int) dbl;
                                tallyMain.setPlusOrMinus(intgr);
                                break;
                            case 10:
                                double dbl1 = Double.parseDouble((ExcelUtil.getCellVal(row.getCell(i))).toString());
                                int intgr1 = (int) dbl1;
                                tallyMain.setIsNeed(intgr1);
                                break;
                            case 11:
                                BigDecimal amountAfterMoney = ExcelUtil.getBigDecimalCell(row.getCell(i));
                                tallyMain.setAmountAfterMoney(amountAfterMoney);
                                break;
                            case 12:
                                tallyMain.setTradingDetailType(ExcelUtil.getCellNoNull(row.getCell(i)));
                                break;
                            default:
                                break;
                        }
                    }else{
                        continue;
                    }
                }
            }
            tallyMainsList.add(tallyMain);
        }
        return tallyMainsList;
    }
}
