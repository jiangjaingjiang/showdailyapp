package com.example.dailyeconomicflow.util;

import org.apache.ibatis.javassist.tools.reflect.ClassMetaobject;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelUtil {
    /*
     * @Title:获取Excel值之后自动判断类型并返回相应的类型1
     * @Description:
     * @Param null:
     * @Return: null
     * @Author: Zengjt
     * @Date: 2022/11/28 9:34
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
    /*
     * @Title:获取金额
     * @Description:
     * @Param null:
     * @Return: null
     * @Author: Zengjt
     * @Date: 2022/11/28 9:33
     */
    public static BigDecimal getBigDecimalCell(Cell cell){
        BigDecimal bigDecimal = BigDecimal.ZERO;
         bigDecimal = new BigDecimal(cell.getNumericCellValue()).setScale(2, BigDecimal.ROUND_HALF_UP);
        return bigDecimal ;
    }
    /*
     * @Title:获取日期
     * @Description:
     * @Param null:
     * @Return: null
     * @Author: Zengjt
     * @Date: 2022/11/28 9:33
     */
    public static Date getDate(Cell cell) throws ParseException {
//        System.out.println(cell);
        Date date = new Date();
        date = cell.getDateCellValue();
        return date;
    }
    /*
     * @Title:获取字符串+判空
     * @Description:
     * @Param null:
     * @Return: null
     * @Author: Zengjt
     * @Date: 2022/11/28 9:33
     */
    public static String getCellNoNull(Cell cell){
        String string = null;
        if (cell == null){
            return "";
        }else{
            switch (cell.getCellTypeEnum()) {
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        string = formater.format(date);
                    } else if (String.valueOf(cell.getNumericCellValue()).contains(".")) {
                       double doubleValue= new BigDecimal(cell.getNumericCellValue()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        string = String.valueOf(doubleValue);
                    }else {
                        string = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                case STRING:
                    string = cell.getStringCellValue().trim();
                    break;
                default:
                    break;
            }
            return string;
        }
    }
    /*
     * @Title:获取ID 把 String 转成 INT
     * @Description:
     * @Param cell:
     * @Return: java.lang.Integer
     * @Author: Zengjt
     * @Date: 2022/11/28 9:33
     */
    public  static Long getCellStringToInt(Cell cell){
        String stringCellValue = cell.getStringCellValue();
        //去掉除了数字的部分
        stringCellValue = stringCellValue.replaceAll("[^\\d]","");
        System.out.println("处理完的String字符串:"+stringCellValue);
        Long integerCellValue = Long.valueOf(stringCellValue);
        return integerCellValue;
    }
    /*
     * @Title: 正负极转换工具
     * @Description:
     * @Param null:
     * @Return: null
     * @Author: Zengjt
     * @Date: 2022/11/28 9:35
     */
    public static BigDecimal negative(BigDecimal amountAfterMoney){
        int i = amountAfterMoney.compareTo(BigDecimal.ZERO);
        //如果比零小的话就是-1
        if (i == -1) {
            amountAfterMoney = amountAfterMoney.negate();
        }
        return amountAfterMoney;
    }
}
