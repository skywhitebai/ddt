package com.sky.ddt.util;

import org.springframework.util.StringUtils;

import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static String getFormatSSS(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        String formatStr = formatter.format(date);
        return formatStr;
    }

    /**
     * @param date
     * @return
     */
    public static String getFormatStryyyyMMddHHmmss(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String formatStr = formatter.format(date);
        return formatStr;
    }

    public static String getFormatStryyyyMMdd(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String formatStr = formatter.format(date);
        return formatStr;
    }

    /**
     * @param date
     * @return
     */
    public static String getFormatDateStr(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatStr = formatter.format(date);
        return formatStr;
    }

    /**
     * @param date
     * @return
     */
    public static String getFormatDateStr(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String formatStr = formatter.format(date);
        return formatStr;
    }

    /**
     * @param date
     * @return
     */
    public static String getFormatDateStrYMD(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formatStr = formatter.format(date);
        return formatStr;
    }
    /**
     * @param date
     * @return
     */
    public static String getFormatDateStrBySlash(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String formatStr = formatter.format(date);
        return formatStr;
    }
    /**
     * 指定日期加上小时后的日期
     *
     * @param num  为增加的天数
     * @param date 时间
     * @return
     */
    public static Date plusHour(int num, Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.HOUR, num);// num为增加的小时，可以改变的
        return ca.getTime();
    }

    /**
     * 指定日期加上天数后的日期
     *
     * @param num  为增加的天数
     * @param date 时间
     * @return
     */
    public static Date plusDay(int num, Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.DATE, num);// num为增加的天数，可以改变的
        return ca.getTime();
    }

    /**
     * 指定日期加上多少分钟后的日期
     *
     * @param num  为增加的分钟
     * @param date 时间
     * @return
     */
    public static Date plusMinute(int num, Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.MINUTE, num);
        return ca.getTime();
    }

    public static Date plusMonth(int num, Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.MONTH, num);
        return ca.getTime();
    }

    /**
     * 字符串转时间
     *
     * @param str
     * @return
     */
    public static Date strToDate(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 字符串转时间
     *
     * @param month
     * @return
     */
    public static Date strMonthToDate(String month) {
        if (StringUtils.isEmpty(month)) {
            return null;
        }
        String monthStr = month + "-01";
        return DateUtil.strToDate(monthStr);
    }

    /**
     * 字符串转时间
     *
     * @param str
     * @return
     */
    public static Date strToDateTime(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 字符串转时间 yyyy-MM-ddTHH:mm:ss+00:00
     *
     * @param str
     * @return
     */
    public static Date UtcStrToDateTime(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        if(str.length()>19){
            str=str.substring(0,19);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将XMLGregorianCalendar转换为Date
     *
     * @param cal
     * @return
     */
    public static Date xmlDate2Date(XMLGregorianCalendar cal) {
        if (cal == null) {
            return null;
        }
        return cal.toGregorianCalendar().getTime();
    }

    public static void main(String[] args) {
        //String dateTime="Oct 1, 2019 12:11:01 AM PDT";
        System.out.println(UtcStrToDateTime("2020-08-15T01:00:00-07:00"));
    }

    public static String getFormatStrMonthDayTime(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd HHmmss");
        String formatStr = formatter.format(date);
        return formatStr;
    }

    public static String getFormatYearMonth(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM");
        String formatStr = formatter.format(date);
        return formatStr;
    }

    /**
     * @param
     * @return
     * @description 将Oct 1, 2019 12:11:01 AM PDT转换为时间
     * @author baixueping
     * @date 2019/11/27 16:27
     */
    public static Date EnglishStrToDateTime(String englishStr) {
        try {
            Date date = new Date(englishStr);
            return date;
        } catch (Exception ex) {
            return null;
        }
    }

    public static String getMonthChinese(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("M月");
        String formatStr = formatter.format(date);
        return formatStr;
    }

    public static Date getToday() {
        Date date = new Date();
        String dateStr = getFormatDateStrYMD(date);
        Date dateRes = strToDate(dateStr);
        return dateRes;
    }

    public static Date getMonthFirstDay(Date date) {
        if (date == null) {
            return date;
        }
        String monthStr = getFormatYearMonth(date);
        return strMonthToDate(monthStr);
    }


}
