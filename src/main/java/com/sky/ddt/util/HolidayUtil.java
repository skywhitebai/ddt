package com.sky.ddt.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sky
 * @Description 判断是否是节假期
 * @date 2022/9/11 13:57
 */
public class HolidayUtil {
    /**
     * 判断当前是否为节假日： 0 上班 1周末 2节假日
     *
     * @param httpArg :参数
     * @return 返回结果
     */

    public static String request(String httpArg) {
        String httpUrl = "http://tool.bitefu.net/jiari/";
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?d=" + httpArg;
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);

            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();

        }

        return result;

    }

    public static void main(String[] args) {
        // 处理节假日
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");

        String httpArg = f.format(new Date());

        String jsonResult = HolidayUtil.request(httpArg);
        //String jsonResult = HolidayUtil.request("20220715");
        // 0 上班 1周末 2节假日

        if ("0".equals(jsonResult)) {
            System.out.println("0上班日");
        }

        if ("1".equals(jsonResult)) {
            System.out.println("1周末");
        }

        if ("2".equals(jsonResult)) {
            System.out.println("2节假日");
        }
    }

    public static Boolean isWorKDay(Date dayNow) {
        String dayStr=DateUtil.getFormatStryyyyMMdd(dayNow);
        String jsonResult =request(dayStr);
        if ("0".equals(jsonResult)) {
            return true;
        }else{
            return false;
        }
    }
}
