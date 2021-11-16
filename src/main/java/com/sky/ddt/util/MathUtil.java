package com.sky.ddt.util;

import java.math.BigDecimal;

import org.springframework.util.StringUtils;

public class MathUtil {
    /**
     * 加法
     *
     * @param a
     * @param b
     * @return
     */
    public static int add(Integer a, Integer b) {
        int result = 0;
        if (a != null) {
            result = result + a;
        }
        if (b != null) {
            result = result + b;
        }
        return result;
    }

    public static Boolean compareBig(Integer a, Integer b) {
        if (a == null || b == null) {
            return false;
        }
        return a > b;
    }

    public static Boolean compareSmall(Integer a, Integer b) {
        if (a == null || b == null) {
            return false;
        }
        return a < b;
    }

    public static Long strToLong(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        try {
            long num = Long.parseLong(str);
            return num;
        } catch (Exception e) {
            return null;
        }
    }

    public static String longTostr(Long num) {
        if (num == null) {
            return null;
        }
        return num.toString();
    }

    public static Double strToDouble(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        try {
            double num = Double.parseDouble(str);
            return num;
        } catch (Exception e) {
            return null;
        }
    }

    public static BigDecimal strToBigDecimal(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        try {
            BigDecimal num = new BigDecimal(str);
            return num;
        } catch (Exception e) {
            return null;
        }
    }

    public static BigDecimal addBigDecimal(BigDecimal preferentialAmount, BigDecimal couponPreferentialAmount) {
        if (preferentialAmount == null) {
            preferentialAmount = BigDecimal.ZERO;
        }
        if (couponPreferentialAmount == null) {
            couponPreferentialAmount = BigDecimal.ZERO;
        }
        return preferentialAmount.add(couponPreferentialAmount);
    }
    public static BigDecimal subtractBigDecimal(BigDecimal b1, BigDecimal b2) {
        if (b1 == null) {
            b1 = BigDecimal.ZERO;
        }
        if (b2 == null) {
            b2 = BigDecimal.ZERO;
        }
        return b1.subtract(b2);
    }

    public static Integer strToInteger(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        try {
            Double num = Double.parseDouble(str);
            return num.intValue();
        } catch (Exception e) {
            return null;
        }
    }

    public static Integer addInteger(Integer num1, Integer num2) {
        if (num1 == null) {
            num1 = 0;
        }
        if (num2 == null) {
            num2 = 0;
        }
        return num1 + num2;
    }

    public static Double divide(Integer a, Double b, Integer digits) {
        if (a == null || b == null) {
            return null;
        }
        if (digits == null || digits < 0) {
            return new Double(a / b);
        }
        return new BigDecimal((float) a / b).setScale(digits, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static Double divide(Double a, Integer b, Integer digits) {
        if (a == null || b == null) {
            return null;
        }
        if (digits == null || digits < 0) {
            return new Double(a / b);
        }
        return new BigDecimal(a / b).setScale(digits, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static BigDecimal divide(BigDecimal a, BigDecimal b, Integer digits) {
        if (a == null || b == null) {
            return null;
        }
        if(BigDecimal.ZERO.compareTo(b)==0){
            return null;
        }
        if (digits == null || digits < 0) {
            return a.divide(b);
        }
        return a.divide(b,digits, BigDecimal.ROUND_HALF_UP);
    }
    public static BigDecimal divide(BigDecimal a, Integer b, Integer digits) {
        if (a == null || b == null) {
            return null;
        }
        if(b==0){
            return null;
        }
        BigDecimal bb=new BigDecimal(b);
        if (digits == null || digits < 0) {
            return a.divide(bb);
        }
        return a.divide(bb,digits, BigDecimal.ROUND_HALF_UP);
    }
    public static BigDecimal divideBigDecimalInteger(BigDecimal a, Integer b, Integer digits) {
        if (a == null || b == null) {
            return null;
        }
        if (b == 0) {
            return null;
        }
        if (digits == null || digits < 0) {
            return a.divide(new BigDecimal(b));
        }
        return a.divide(new BigDecimal(b), digits, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * @param
     * @return
     * @description 四舍五入取整数
     * @author baixueping
     * @date 2019/4/24 10:25
     */
    public static Integer multiply(Double a, Double b) {
        if (a == null || b == null) {
            return null;
        }
        return new Double(Math.round(a * b)).intValue();
    }

    /**
     * @param
     * @return
     * @description double保留两位小数
     * @author baixueping
     * @date 2019/8/21 18:16
     */
    public static Double setScale(double v, int digits) {
        return new BigDecimal(v).setScale(digits, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * @param
     * @return
     * @description 设置最小值
     * @author baixueping
     * @date 2019/8/22 9:06
     */
    public static Integer integerMin(int num, int min) {
        if (num >= min) {
            return num;
        }
        return min;
    }

    public static String integerToStr(Integer num) {
        if (num == null) {
            return null;
        }
        return num.toString();
    }

    public static boolean equalBigDecimal(BigDecimal num1, BigDecimal num2) {
        if (num1 == null) {
            if (num2 == null) {
                return true;
            } else {
                return false;
            }
        }
        return num1.equals(num2);
    }

    public static Integer subtractInteger(Integer a, Integer b) {

        int result = 0;
        if (a != null) {
            result = a - result;
        }
        if (b != null) {
            result = result - b;
        }
        return result;
    }
    /**
     * description 校验数值范围
     *
     * @param num
     * @param min
     * @param max
     * @param digits
     * @return
     * @author baixueping
     * @date 2019/4/19 10:25
     */
    public static boolean checkMinMaxDigits(BigDecimal num, double min, double max, int digits) {
        if (num == null) {
            return false;
        }
        Double value = num.doubleValue();
        return checkMinMaxDigits(value, min, max, digits);
    }

    /**
     * 校验参数，允许空
     *
     * @param num
     * @param min
     * @param max
     * @param digits
     * @return
     */
    public static boolean checkMinMaxDigitsAllowNull(BigDecimal num, double min, double max, int digits) {
        if (num == null) {
            return true;
        }
        Double value = num.doubleValue();
        return checkMinMaxDigits(value, min, max, digits);
    }

    /**
     * description 校验数值范围
     *
     * @param num
     * @param min
     * @param max
     * @param digits
     * @return
     * @author baixueping
     * @date 2019/4/19 10:25
     */
    public static boolean checkMinMaxDigits(Double num, double min, double max, int digits) {
        if (num == null) {
            return false;
        }
        if (num < min) {
            return false;
        }
        if (num > max) {
            return false;
        }
        int digitsNum = getNumberDecimalDigits(num);
        if (digitsNum > digits) {
            return false;
        }
        return true;
    }

    public static int getNumberDecimalDigits(double number) {
        String moneyStr = String.valueOf(number);
        String[] num = moneyStr.split("\\.");
        if (num.length == 2) {
            for (; ; ) {
                if (num[1].endsWith("0")) {
                    num[1] = num[1].substring(0, num[1].length() - 1);
                } else {
                    break;
                }
            }
            return num[1].length();
        } else {
            return 0;
        }
    }

    public static BigDecimal multiply(BigDecimal cost, Integer quantity,int digits) {
        if(cost==null||quantity==null){
            return null;
        }
        return cost.multiply(new BigDecimal(quantity)).setScale(digits,BigDecimal.ROUND_HALF_UP);

    }
}
