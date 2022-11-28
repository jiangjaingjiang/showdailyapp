package com.example.dailyeconomicflow.service.impl;

import com.example.dailyeconomicflow.dao.TallyMainMapper;
import com.example.dailyeconomicflow.pojo.ReturnInfo;
import com.example.dailyeconomicflow.pojo.TallyMain;
import com.example.dailyeconomicflow.service.ExcelDaliyService;
import com.example.dailyeconomicflow.util.ExcelUtil;
import com.example.dailyeconomicflow.util.ReturnUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
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

    /*
     * @Title:纯纯新增
     * @Description:
     * @Param null:
     * @Return: null
     * @Author: Zengjt
     * @Date: 2022/11/25 17:30
     */
    @Override
    public ReturnInfo getExcelInfos(String fileName, MultipartFile file) throws IOException, ParseException {
        ReturnInfo ReturnInfo = new ReturnInfo();
        //遍历时候一共要拿几列的去遍历,15到英文0列
        int needExcelData = 15 ;
        //要将表中的哪几列传入数据库中，从0开始计数
        int[] resultCell = new int[]{0,2,3,4,5,6,7,8,9,10,11,12,14};

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
        //确定要拿哪一个sheet页
        Sheet sheet = wb.getSheetAt(2);
        //获取需要插入数据库的数据
        resultList = getSheetValAndId(sheet,needExcelData, resultCell );
        System.out.println("结果集---"+resultList);
        try{
            tallyMainMapper.insertOrUpdateBatch(resultList);
            ReturnInfo = ReturnUtil.success("");
        }catch (Exception e){
            e.printStackTrace();
            ReturnInfo = ReturnUtil.error("数据导入失败");
        }
        return ReturnInfo;
    }
    /*
     * @Title: 有就更新没有就新增
     * @Description:
     * @Param null:
     * @Return: null
     * @Author: Zengjt
     * @Date: 2022/11/25 17:32
     */
    @Override
    public ReturnInfo getExcelInfosUORA(String fileName, MultipartFile file) throws IOException, ParseException {
        return null;
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
                                //账单发生时间
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
                                //如果是负数转换成正数再进去(方便做图表统计)
                                amountAfterMoney = ExcelUtil.negative(amountAfterMoney);
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

    /*
     * @Title:带id的插入
     * @Description:
     * @Param null:
     * @Return: null
     * @Author: Zengjt
     * @Date: 2022/11/25 17:50
     */
    public List getSheetValAndId(Sheet sheet,int needExcelData, int[] resultCell) throws ParseException {
        //返回的结果集
        List<TallyMain> tallyMainsList = new ArrayList<>();
        //返回的实体
        TallyMain tallyMain;
        //循环遍历
        //r代表目前在获取第几行
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            tallyMain = new TallyMain();
            //之前用这个获取但是有点问题,中间有空后面就不取了
            //System.out.println("这个行有几个元素"+row.getPhysicalNumberOfCells());
            //needExcelData 是前面设定的这行有几个元素
            for (int i = 0;i<needExcelData;i++){
                //j代表了前面设定了第几列是需要取值的,如果不是就跳过
                for (int j=0;j<resultCell.length;j++){
                    if (i==resultCell[j]){
                        //System.out.println("当前处理的数据"+row.getCell(i));
                        switch (i){
                            case 0:
                                //账单发生时间
                                Cell cell = row.getCell(i);
                                System.out.println("正在执行 :"+cell);
                                Date tradingTime = ExcelUtil.getDate(cell);
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
                                //如果是负数转换成正数再进去(方便做图表统计)
                                amountAfterMoney = ExcelUtil.negative(amountAfterMoney);
                                tallyMain.setAmountAfterMoney(amountAfterMoney);
                                break;
                            case 12:
                                tallyMain.setTradingDetailType(ExcelUtil.getCellNoNull(row.getCell(i)));
                                break;
                            case 14:
                                //获取String 的 id 转成 int
                                Long ssssid = ExcelUtil.getCellStringToInt(row.getCell(i));
                                tallyMain.setId(ssssid);
                                System.out.println(tallyMain.toString());
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
