package com.example.dailyeconomicflow.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelUtil {
    /**
     *
     * @param cell
     * @return
     */
    public static Object getCellVal(Cell cell){
        Object obj = null;

        switch (cell.getCellTypeEnum()) {
            case BOOLEAN:
                obj = cell.getBooleanCellValue();
                break;
            case ERROR:
                obj = cell.getErrorCellValue();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    Date date = cell.getDateCellValue();
                    DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    obj = formater.format(date);
                } else if (String.valueOf(cell.getNumericCellValue()).contains(".")) {
                    obj = new BigDecimal(cell.getNumericCellValue()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                }else {
                    obj = cell.getNumericCellValue();
                }
                break;
            case STRING:
                obj = cell.getStringCellValue();
                break;
            default:
                break;
        }
        return obj;
    }
    //获取金额
    public static BigDecimal getBigDecimalCell(Cell cell){
        BigDecimal bigDecimal = BigDecimal.ZERO;
         bigDecimal = new BigDecimal(cell.getNumericCellValue()).setScale(2, BigDecimal.ROUND_HALF_UP);
        return bigDecimal ;
    }
    //获取日期
    public static Date getDate(Cell cell) throws ParseException {
        System.out.println(cell);
        Date date = new Date();
        date = cell.getDateCellValue();
        return date;
    }
    //获取字符串+判空
    public static String getCellNoNull(Cell cell){
        Object obj = null;
        obj = cell.getStringCellValue();
        if (obj==null){
            return "";
        }else {
            return obj.toString().trim();

        }
    }
}
