package com.example.dailyeconomicflow.service.impl;

import com.example.dailyeconomicflow.dao.UserMapper;
import com.example.dailyeconomicflow.pojo.ReturnInfo;
import com.example.dailyeconomicflow.pojo.User;
import com.example.dailyeconomicflow.service.ExcelService;
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
public class ExcelServiceImpl implements ExcelService {
    @Autowired
    UserMapper userMapper;
    private Object Date;

    /**
     *
     * @param fileName
     * @param file
     * @return
     * @throws Exception
     */
    @Override
    public ReturnInfo getExcelInfo(String fileName, MultipartFile file) throws IOException, ParseException {
        ReturnInfo returnInfo = new ReturnInfo();
        //要将表中的哪几列传入数据库中，从0开始计数
        int[] resultCell = new int[]{0,1,2,3,4};
        List<User> resultList = new ArrayList<>();
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
            userMapper.addUser(resultList);
            returnInfo = ReturnUtil.success("");
        }catch (Exception e){
            e.printStackTrace();
            returnInfo = ReturnUtil.error("数据导入失败");
        }
        return returnInfo;
    }

    /**
     *
     * @param sheet
     * @param resultCell 需要将哪些列插入至数据库
     * @return
     */
    public List getSheetVal(Sheet sheet, int[] resultCell) throws ParseException {
        List<User> userList = new ArrayList<>();//返回的结果集
        int[] resultIndex = new int[resultCell.length];//存储需要上传字段的下标
        User user;
        for (int r = 0; r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
//            System.out.println(row);
            if (row == null) {
                continue;
            }
            user = new User();
            for (int i = 0;i<row.getPhysicalNumberOfCells();i++){
//                String temp = getCellVal(row.getCell(i)).toString().trim();
                String temp = (ExcelUtil.getCellVal(row.getCell(i))).toString().trim();
                for (int j=0;j<resultCell.length;j++){
                    if (i==resultCell[j]){
                        switch (i){
                            case 0:
                                user.setUsername((ExcelUtil.getCellVal(row.getCell(i))).toString().trim());
                                break;
                            case 1:
                                user.setPassword((ExcelUtil.getCellVal(row.getCell(i))).toString().trim());
                                break;
                            case 2:
                                user.setName((ExcelUtil.getCellVal(row.getCell(i))).toString().trim());
                                break;
                            case 3:
                                BigDecimal bigDecimal = ExcelUtil.getBigDecimalCell(row.getCell(i));
                                System.out.println(bigDecimal);
                                user.setMoney(bigDecimal);
                                break;
                            case 4:
                                Date s = ExcelUtil.getDate(row.getCell(i));
                                System.out.println(s);
                                user.setTime(s);
                                break;
                            default:
                                break;
                        }
                    }else{
                        continue;
                    }
                }
            }
            userList.add(user);
        }
        return userList;
    }

//    /**
//     *
//     * @param cell
//     * @return
//     */
//    public Object getCellVal(Cell cell){
//        Object obj = null;
//        switch (cell.getCellTypeEnum()) {
//            case BOOLEAN:
//                obj = cell.getBooleanCellValue();
//                break;
//            case ERROR:
//                obj = cell.getErrorCellValue();
//                break;
//            case NUMERIC:
//                obj = cell.getNumericCellValue();
//                break;
//            case STRING:
//                obj = cell.getStringCellValue();
//                break;
//            default:
//                break;
//        }
//        return obj;
//    }
}
