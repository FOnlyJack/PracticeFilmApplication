package com.example.changemax.sqhappy.utils;

/**
 * Created by C on 2016/7/6.    计算两个时间的毫秒值的差值
 * 判断创建提醒的时间和设置多久提醒之间的差值   如果 差值在[0,7天]显示天，(7天,1个月]显示几周后，超过1个月显示几月后
 * 判断如果差值大于0小于604800000   就显示天    如果差值大于604800000 小于2678400000 显示几周    如果差值大于2678400000  显示几月后
 */
public class TimeUtils {
    public static String getDistanceTime(long diff) {
        long averageday = 86400000L;//平均每天一天的的毫秒值
        long averagehour = 3600000L;//平均每小时的毫秒值
        long averageminute = 60000L;//平局每分钟的毫秒值
        long minute = 0;
        long year = 0;
        long hour = 0;
        long day = 0;
        long week = 0;
        long month = 0;
        long max_c = 32140800000L;
        long max_b = 2678400000L;
        long max_a = 604800000L;//七天
        String flag;
        flag = "前";
        if (diff > 0 && diff <= averagehour) {
            minute = (diff % averagehour) / averageminute;//分钟
        } else if (diff > averagehour && diff <= averageday) {
            hour = (diff % averageday) / averagehour;//小时
        } else if (diff > averageday && diff <= max_a) {
            day = diff / averageday;//多少天
        } else if (diff > max_a && diff <= max_b) {
            week = diff / averageday / 7;//多少周
        } else if (diff > max_b && diff <= max_c) {
            month = diff / averageday / 30;//多少月
        } else if (diff > max_c && diff <= Long.MAX_VALUE) {
            year = diff / averageday / 360;
        }
        if (minute != 0) {
            return minute + "分钟" + flag;
        }
        if (hour != 0) {
            return hour + "小时" + flag;
        }
        if (day != 0) {
            return day + "天" + flag;
        }
        if (week != 0) {
            return week + "周" + flag;
        }
        if (month != 0) {
            return month + "月" + flag;
        }
        if (year != 0) {
            return year + "年" + flag;
        }
        return "刚刚";
    }
}
