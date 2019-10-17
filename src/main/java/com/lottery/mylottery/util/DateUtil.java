package com.lottery.mylottery.util;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description: 时间工具类
 * @Date: 11:04 2018-06-19
 * @Author: YuanPeng
 * @Modifier:
 */
public class DateUtil {

    /**
     * 日期显示格式:年-月-日
     */
    public static final String SHOW_FORMAT_DATE = "yyyy-MM-dd";
    public static final String SHOW_FORMAT_DATE2 = "yyyyMMdd";
    /**
     * 日期显示格式:年-月
     */
    public static final String SHOW_FORMAT_DATE3 = "yyyy-MM";
    public static final String SHOW_FORMAT_DATE33 = "yyyyMM";
    /**
     * 日期显示格式:月-日
     */
    public static final String SHOW_FORMAT_DATE4 = "MM-dd";
    public static final String SHOW_FORMAT_DATE5 = "yyyy/MM/dd";
    public static final String SHOW_FORMAT_DATE6 = "yyyy.MM.dd";
    public static final String SHOW_FORMAT_DATE7 = "yyMMddHHmmss";
    public static final String SHOW_FORMAT_DATE8 = "HHmm";
    public static final String SHOW_FORMAT_DATE9 = "HH";
    public static final String SHOW_FORMAT_DATE10 = "yyyyMMddHHmmssSSS";
    public static final String SHOW_FORMAT_DATE11 = "HH:mm:ss";
    public static final String SHOW_FORMAT_DATE12 = "HH:mm";
    public static final String SHOW_FORMAT_DATE13 = "yyyyMMddHHmmss";
    /**
     * 日期显示格式:年-月-日 时:分:秒
     */
    public static final String SHOW_FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";
    public static final String SHOW_FORMAT_DATETIME2 = "yyyy-MM-dd HH:mm";
    public static final String SHOW_FORMAT_DATETIME3 = "yyyy/MM/dd HH:mm";
    /**
     * 计算相隔模式数的日期 模式0:年
     */
    public static final int POINTER_YEAR = 0;
    /**
     * 计算相隔模式数的日期 模式1:月
     */
    public static final int POINTER_MONTH = 1;
    /**
     * 计算相隔模式数的日期 模式2:天
     */
    public static final int POINTER_DATE = 2;
    /**
     * 一天开始时间
     */
    public static final String DAYOFSTART = " 00:00:00";
    /**
     * 一天结束时间
     */
    public static final String DAYOFEND = " 23:59:59";

    private static final SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 计算两个日期的间隔天数(字符型)
     *
     * @param start 开始时间，如：2008-12-03 11:00:00
     * @param end   结束时间，如：2009-12-31 11:00:00
     * @return long 间隔天数
     */
    public static final long getBetweenDays(String start, String end) {
        long days = -1;
        if (StringUtils.isNoneBlank(start, end)) {
            Date dateStart = isDate(start);
            Date dateEnd = isDate(end);
            if (null != dateStart && null != dateEnd) {
                days = getBetweenDays(dateStart, dateEnd);
            }
        }
        return days;
    }

    /**
     * 计算两个日期的间隔天数
     *
     * @param start 开始时间，如：2008-12-03 11:00:00
     * @param end   结束时间，如：2009-12-31 11:00:00
     * @return long 间隔天数
     */
    public static final long getBetweenDays(Date start, Date end) {
        long days = -1;
        if (null != start && null != end) {
            days = end.getTime() - start.getTime();
            if (days < 0) {
                days = days / (1000 * 60 * 60 * 24);
                if (days == 0) {
                    days = days - 1;
                }
            } else {
                days = days / (1000 * 60 * 60 * 24);
            }
        }
        return days;
    }

    /**
     * 验证输入的文本信息日期是否合
     *
     * @param date 输入的日期字符串
     * @return 返回的日期
     */
    public static final Date isDate(String date) {
        String[] date_format = {SHOW_FORMAT_DATE5, SHOW_FORMAT_DATE, SHOW_FORMAT_DATE2, SHOW_FORMAT_DATE6};
        for (int i = 0; i < date_format.length; i++) {
            if (StringUtils.isNotBlank(date)) {
                Date tempDate = isDate(date, date_format[i]);
                if (null != tempDate) {
                    return tempDate;
                }
            } else {
                return null;
            }
        }
        return null;
    }

    /**
     * 验证输入的文本信息日期是否合法
     *
     * @param date    输入的日期
     * @param pattern 日期格式，如：yyyy-MM-dd
     * @return 返回的日期
     */
    public static final Date isDate(String date, String pattern) {
        if (StringUtils.isBlank(pattern)) {
            pattern = SHOW_FORMAT_DATE;
        }
        Date tempDate = null;
        if (StringUtils.isNotBlank(date)) {
            SimpleDateFormat formatDate = new SimpleDateFormat(pattern);
            formatDate.setLenient(false);
            ParsePosition pos = new ParsePosition(0);
            tempDate = formatDate.parse(date, pos);
        }
        return tempDate;
    }

    /**
     * 日期格式化(String转换为Date)
     *
     * @param date    日期字符串
     * @param pattern 处理结果日期的显示格式，如："yyyy-MM-dd"
     * @return 转换后的日期
     */
    public static final Date getDateToString(String date, String pattern) {
        Date d = null;
        if (StringUtils.isNotBlank(date)) {
            if (StringUtils.isBlank(pattern)) {
                pattern = SHOW_FORMAT_DATE;
            }
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            try {
                d = formatter.parse(date);
            } catch (ParseException e) {
            }
        }
        return d;
    }

    /**
     * 日期格式化(Date转换为String)
     *
     * @param date    日期
     * @param pattern 处理结果日期的显示格式，如："yyyy-MM-dd"
     * @return 处理后的日期字符串
     */
    public static final String getDateToString(Date date, String pattern) {
        String s = "";
        if (null != date) {
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            s = formatter.format(date);
        }
        return s;
    }

    /**
     * 日期格式转换(DATE转换为DATE)
     *
     * @param date    日期
     * @param pattern 处理结果日期的显示格式，如："yyyy-MM-dd"
     * @return 处理后的日期
     */
    public static final Date getDateToDate(Date date, String pattern) {
        Date s = null;
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        try {
            if (null != date) {
                s = formatter.parse(formatter.format(date));
            }
        } catch (ParseException e) {
        }
        return s;
    }

    /**
     * 获取到指定样式的年月日(年月日参数为int型)
     *
     * @param year    年
     * @param month   月
     * @param date    日
     * @param pattern 日期格式，如：yyyy-MM-dd HH:mm:ss EEE
     * @return 格式化后的字符串
     */
    public static final String getDateStringByPatten(int year, int month, int date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, date);
        return formatter.format(calendar.getTime());
    }

    /**
     * 获取到指定样式的年月日(年月日参数为String型)
     *
     * @param year    年
     * @param month   月
     * @param date    日
     * @param pattern 日期格式，如：yyyy-MM-dd HH:mm:ss EEE
     * @return 格式化后的字符串
     */
    public static final String getDateStringByPatten(String year, String month, String date, String pattern) {
        int y = Integer.parseInt(year);
        int m = Integer.parseInt(month);
        int d = Integer.parseInt(date);
        return getDateStringByPatten(y, m, d, pattern);
    }

    /**
     * 获取与指定日期相差指定分钟的日期
     *
     * @param base  时间，如：2008-12-03 11:00:00
     * @param count 向前或向后的天数，向后为正数，向前为负数
     * @return 处理后的日期
     */
    public static final Date getDatePointerByMinutes(Date base, int count) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(base);
        calendar.add(Calendar.MINUTE, count);
        return calendar.getTime();
    }

    public static final String getDatePointerByMinutesStr(Date base, int count) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(base);
        calendar.add(Calendar.MINUTE, count);
        SimpleDateFormat formatter = new SimpleDateFormat(SHOW_FORMAT_DATETIME);
        return formatter.format(calendar.getTime());
    }

    /**
     * 获取当前日期(字符型)
     *
     * @param pattern 日期格式，如：yyyy-MM-dd HH:mm:ss
     * @return 当前日期字符串
     */
    public static final String getNowDateStr(String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String date = formatter.format(new Date(System.currentTimeMillis()));
        return date;
    }

    /**
     * 获取当前日期
     *
     * @param pattern 日期格式，如：yyyy-MM-dd HH:mm:ss
     * @return 当前日期字符串
     */
    public static Date getNowDate(String pattern) {
        Date now = new Date();
        // 可以方便地修改日期格式
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        String time = dateFormat.format(now);
        try {
            return dateFormat.parse(time);
        } catch (ParseException e) {

        }
        return null;
    }

    /**
     * 获取昨天日期(字符型)
     *
     * @param pattern 日期格式，如：yyyy-MM-dd HH:mm:ss
     * @return 当前日期字符串
     */
    public static Date getYesterday(String pattern) {
        Calendar c = Calendar.getInstance();
        //设置当前日期
        c.setTime(new Date(System.currentTimeMillis()));
        // 获取昨天日期
        c.add(Calendar.DATE, -1);
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String date = formatter.format(c.getTime());
        try {
            return formatter.parse(date);
        } catch (ParseException e) {

        }
        return null;
    }

    /**
     * 获取昨天日期(字符型)
     *
     * @param pattern 日期格式，如：yyyy-MM-dd HH:mm:ss
     * @return 当前日期字符串
     */
    public static String getYesterdayStr(String pattern) {
        Calendar c = Calendar.getInstance();
        //设置当前日期
        c.setTime(new Date(System.currentTimeMillis()));
        // 获取昨天日期
        c.add(Calendar.DATE, -1);
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String date = formatter.format(c.getTime());
        return date;
    }

    /**
     * 获取昨天日期(字符型)
     *
     * @param pattern 日期格式，如：yyyy-MM-dd HH:mm:ss
     * @return 当前日期字符串
     */
    public static String getTomorrowStr(String pattern) {
        Calendar c = Calendar.getInstance();
        //设置当前日期
        c.setTime(new Date(System.currentTimeMillis()));
        // 获取昨天日期
        c.add(Calendar.DATE, 1);
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String date = formatter.format(c.getTime());
        return date;
    }

    /**
     * 日期加N天(天数可为负数)
     *
     * @param date    日期
     * @param dayNums 要加的天数
     * @return
     */
    public static Date addDay(Date date, Integer dayNums) {
        if (null == date) {
            return date;
        }
        Calendar c = Calendar.getInstance();
        //设置当前日期
        c.setTime(date);
        //日期加n天
        c.add(Calendar.DATE, dayNums);
        date = c.getTime();
        return date;
    }

    /**
     * 日期加N天(日期为字符型，天数可为负数)
     *
     * @param str     日期
     * @param dayNums 要加的天数
     * @return
     */
    public static Date addDay(String str, Integer dayNums) {
        Date date = getDateToString(str, SHOW_FORMAT_DATE);
        if (null == date) {
            return date;
        }
        Calendar c = Calendar.getInstance();
        //设置当前日期
        c.setTime(date);
        //日期加1天
        c.add(Calendar.DATE, dayNums);
        date = c.getTime();
        return date;
    }

    /**
     * 日期加N月（日期为字符型）
     *
     * @param str       日期
     * @param monthNums 要加的月数
     * @return
     */
    public static Date addMonth(String str, Integer monthNums) {
        Date date = getDateToString(str, SHOW_FORMAT_DATE);
        if (null == date) {
            return date;
        }
        Calendar c = Calendar.getInstance();
        //设置当前日期
        c.setTime(date);
        //日期加1天
        c.add(Calendar.MONTH, monthNums);
        date = c.getTime();
        return date;
    }

    /**
     * 日期加N年（日期为字符型）
     *
     * @param str      日期
     * @param yearNums 要加的年数
     * @return
     */
    public static Date addYear(String str, Integer yearNums) {
        Date date = getDateToString(str, SHOW_FORMAT_DATE);
        if (null == date) {
            return date;
        }
        Calendar c = Calendar.getInstance();
        //设置当前日期
        c.setTime(date);
        //日期加1天
        c.add(Calendar.YEAR, yearNums);
        date = c.getTime();
        return date;
    }

    /**
     * 获得当年的天数
     *
     * @param str 日期
     * @return
     */
    public static int getDaysOfYear(String str) {
        Date date = getDateToString(str, SHOW_FORMAT_DATE);
        Calendar c = Calendar.getInstance();
        //设置当前日期
        c.setTime(date);
        return c.getActualMaximum(Calendar.DAY_OF_YEAR);
    }

    /**
     * 获得当月的天数
     *
     * @param str 日期
     * @return
     */
    public static int getDaysOfMonth(String str) {
        Date date = getDateToString(str, SHOW_FORMAT_DATE);
        Calendar c = Calendar.getInstance();
        //设置当前日期
        c.setTime(date);
        return c.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获得当月的天数
     *
     * @param date 日期
     * @return
     */
    public static int getDaysOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        //设置当前日期
        c.setTime(date);
        return c.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取当前日期是星期几
     *
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekDays[w];
    }

    /**
     * @Description: 获取某月第一天
     * @Date: 16:08 2018-07-26
     * @Author: YuanPeng
     */
    public static String getFirstDay(int year, int month) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return df.format(calendar.getTime());
    }

    /**
     * @Description: 获取上月第一天
     * @Date: 14:50 2018-08-09
     * @Author: YuanPeng
     */
    public static String getLastMonthFirstDay() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return df.format(calendar.getTime());
    }

    /**
     * @Description: 获取本月第一天
     * @Date: 14:50 2018-08-09
     * @Author: YuanPeng
     */
    public static String getMonthFirstDay() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return df.format(calendar.getTime());
    }

    /**
     * @Description: 获取某月最后一天
     * @Date: 16:10 2018-07-26
     * @Author: YuanPeng
     */
    public static String getLastDay(int year, int month) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        //设置为该月第一天
        calendar.set(Calendar.DATE, 1);
        calendar.add(Calendar.DATE, -1);
        return df.format(calendar.getTime());
    }

    /**
     * @Description: 获取上月最后一天
     * @Date: 14:51 2018-08-09
     * @Author: YuanPeng
     */
    public static String getLastMonthLastDay() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        return df.format(calendar.getTime());
    }

    /**
     * @Description: 获取本月最后一天
     * @Date: 14:51 2018-08-09
     * @Author: YuanPeng
     */
    public static String getMonthLastDay() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        return df.format(calendar.getTime());
    }

    /**
     * @Description: 计算两个时间相差多少分钟
     * @Date: 9:44 2018-08-09
     * @Author: YuanPeng
     */
    public static Long getTwoDateOfMinute(Date begin, Date end) {
        //除以1000是为了转换成秒
        long between = (end.getTime() - begin.getTime()) / 1000;
        long min = between / 60;
        return min;
    }

    /**
     * @Description: 计算两个时间相差多少秒
     * @Date: 9:44 2018-08-09
     * @Author: YuanPeng
     */
    public static Long getTwoDateOfSecond(Date begin, Date end) {
        //除以1000是为了转换成秒
        long between = (end.getTime() - begin.getTime()) / 1000;
        return between;
    }

    /**
     * @Description 判断2个时间日期的大小
     * @Author guosh
     * @Date 2018/10/29 0029 上午 11:55
     */
    public static boolean getDateCompareDate(Date begin, Date end) {
        boolean status = false;
        Date be = getDateToDate(begin, DateUtil.SHOW_FORMAT_DATETIME);
        Date en = getDateToDate(end, DateUtil.SHOW_FORMAT_DATETIME);
        if (be.getTime() > en.getTime()) {
            status = true;
        } else if (be.getTime() <= en.getTime()) {
            status = false;
        }
        return status;
    }

    /**
     * 得到本周周一
     *
     * @return String
     */
    public static String getMondayOfThisWeek(String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        Calendar c = Calendar.getInstance();
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        c.add(Calendar.DATE, -day_of_week + 1);
        return df.format(c.getTime());
    }

    /**
     * 得到本周周日
     *
     * @return String
     */
    public static String getSundayOfThisWeek(String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        Calendar c = Calendar.getInstance();
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        c.add(Calendar.DATE, -day_of_week + 7);
        return df.format(c.getTime());
    }

    /**
     * 当前季度的开始时间，即2012-01-1 00:00:00
     *
     * @return
     */
    public static Date getCurrentQuarterStartTime() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3)
                c.set(Calendar.MONTH, 0);
            else if (currentMonth >= 4 && currentMonth <= 6)
                c.set(Calendar.MONTH, 3);
            else if (currentMonth >= 7 && currentMonth <= 9)
                c.set(Calendar.MONTH, 7);
            else if (currentMonth >= 10 && currentMonth <= 12)
                c.set(Calendar.MONTH, 9);
            c.set(Calendar.DATE, 1);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 当前季度的开始时间，即2012-01-1 00:00:00
     *
     * @return str
     */
    public static String getCurrentQuarterStartTimeStr() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        String now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3)
                c.set(Calendar.MONTH, 0);
            else if (currentMonth >= 4 && currentMonth <= 6)
                c.set(Calendar.MONTH, 3);
            else if (currentMonth >= 7 && currentMonth <= 9)
                c.set(Calendar.MONTH, 7);
            else if (currentMonth >= 10 && currentMonth <= 12)
                c.set(Calendar.MONTH, 9);
            c.set(Calendar.DATE, 1);
            now = shortSdf.format(c.getTime()) + " 00:00:00";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 当前季度的结束时间，即2012-03-31 23:59:59
     *
     * @return
     */
    public static Date getCurrentQuarterEndTime() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3) {
                c.set(Calendar.MONTH, 2);
                c.set(Calendar.DATE, 31);
            } else if (currentMonth >= 4 && currentMonth <= 6) {
                c.set(Calendar.MONTH, 5);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 7 && currentMonth <= 9) {
                c.set(Calendar.MONTH, 8);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 10 && currentMonth <= 12) {
                c.set(Calendar.MONTH, 11);
                c.set(Calendar.DATE, 31);
            }
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 当前季度的结束时间，即2012-03-31 23:59:59
     *
     * @return
     */
    public static String getCurrentQuarterEndTimeStr() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        String now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3) {
                c.set(Calendar.MONTH, 2);
                c.set(Calendar.DATE, 31);
            } else if (currentMonth >= 4 && currentMonth <= 6) {
                c.set(Calendar.MONTH, 5);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 7 && currentMonth <= 9) {
                c.set(Calendar.MONTH, 8);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 10 && currentMonth <= 12) {
                c.set(Calendar.MONTH, 11);
                c.set(Calendar.DATE, 31);
            }
            now = shortSdf.format(c.getTime()) + " 23:59:59";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 获取前/后半年的开始时间
     *
     * @return
     */
    public static Date getHalfYearStartTime() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 6) {
                c.set(Calendar.MONTH, 0);
            } else if (currentMonth >= 7 && currentMonth <= 12) {
                c.set(Calendar.MONTH, 6);
            }
            c.set(Calendar.DATE, 1);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;

    }

    /**
     * 获取前/后半年的开始时间
     *
     * @return
     */
    public static String getHalfYearStartTimeStr() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        String now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 6) {
                c.set(Calendar.MONTH, 0);
            } else if (currentMonth >= 7 && currentMonth <= 12) {
                c.set(Calendar.MONTH, 6);
            }
            c.set(Calendar.DATE, 1);
            now = shortSdf.format(c.getTime()) + " 00:00:00";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;

    }

    /**
     * 获取前/后半年的结束时间
     *
     * @return
     */
    public static Date getHalfYearEndTime() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 6) {
                c.set(Calendar.MONTH, 5);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 7 && currentMonth <= 12) {
                c.set(Calendar.MONTH, 11);
                c.set(Calendar.DATE, 31);
            }
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 获取前/后半年的结束时间
     *
     * @return
     */
    public static String getHalfYearEndTimeStr() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        String now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 6) {
                c.set(Calendar.MONTH, 5);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 7 && currentMonth <= 12) {
                c.set(Calendar.MONTH, 11);
                c.set(Calendar.DATE, 31);
            }
            now = shortSdf.format(c.getTime()) + " 23:59:59";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 当前年的开始时间，即2012-01-01 00:00:00
     *
     * @return
     */
    public static Date getCurrentYearStartTime() {
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            c.set(Calendar.MONTH, 0);
            c.set(Calendar.DATE, 1);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 当前年的开始时间，即2012-01-01 00:00:00
     *
     * @return
     */
    public static String getCurrentYearStartTimeStr() {
        Calendar c = Calendar.getInstance();
        String now = null;
        try {
            c.set(Calendar.MONTH, 0);
            c.set(Calendar.DATE, 1);
            now = shortSdf.format(c.getTime()) + " 00:00:00";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 当前年的结束时间，即2012-12-31 23:59:59
     *
     * @return
     */
    public static Date getCurrentYearEndTime() {
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            c.set(Calendar.MONTH, 11);
            c.set(Calendar.DATE, 31);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 当前年的结束时间，即2012-12-31 23:59:59
     *
     * @return
     */
    public static String getCurrentYearEndTimeStr() {
        Calendar c = Calendar.getInstance();
        String now = null;
        try {
            c.set(Calendar.MONTH, 11);
            c.set(Calendar.DATE, 31);
            now = shortSdf.format(c.getTime()) + " 23:59:59";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 获得入参日期下周一的日期
     *
     * @return 入参日期的下周一
     */
    public static String getNextMonday() {
        //获得入参的日期
        Calendar cd = Calendar.getInstance();
        cd.setTime(new Date());

        // 获得入参日期是一周的第几天
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
        // 获得入参日期相对于下周一的偏移量（在国外，星期一是一周的第二天，所以下周一是这周的第九天）
        // 若入参日期是周日，它的下周一偏移量是1
        int nextMondayOffset = dayOfWeek == 1 ? 1 : 9 - dayOfWeek;

        // 增加到入参日期的下周一
        cd.add(Calendar.DAY_OF_MONTH, nextMondayOffset);
        return shortSdf.format(cd.getTime()) + " 00:00:00";
    }

    /**
     * 获得入参日期下周日的日期
     *
     * @return 入参日期的下周日
     */
    public static String getNextSunday() {
        //获得入参的日期
        Calendar cd = Calendar.getInstance();
        cd.setTime(new Date());

        // 获得入参日期是一周的第几天
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
        // 获得入参日期相对于下周日的偏移量（在国外，星期一是一周的第二天，所以下周日相对于本周来说，是第15天）
        // 若入参日期是周日，它的下周日偏移量是7
        int nextMondayOffset = dayOfWeek == 1 ? 7 : 15 - dayOfWeek;

        // 增加到入参日期的下周日
        cd.add(Calendar.DAY_OF_MONTH, nextMondayOffset);
        return shortSdf.format(cd.getTime()) + " 23:59:59";
    }

    /**
     * 获得入参日期下个月的第一天
     *
     * @return 入参日期下个月的第一天
     */
    public static String firstDayOfNextMonth() {
        //获得入参的日期
        Calendar cd = Calendar.getInstance();
        cd.setTime(new Date());

        //获取下个月第一天：
        cd.add(Calendar.MONTH, 1);
        //设置为1号,当前日期既为次月第一天
        cd.set(Calendar.DAY_OF_MONTH, 1);

        return shortSdf.format(cd.getTime()) + " 00:00:00";
    }

    /**
     * 获得入参日期下个月的最后一天
     *
     * @return 入参日期下个月的第一天
     */
    public static String lastDayOfNextMonth() {
        //获得入参的日期
        Calendar cd = Calendar.getInstance();
        cd.setTime(new Date());

        //获取下下个月第一天：
        cd.add(Calendar.MONTH, 2);
        //设置为0号,当前日期既为次月最后一天
        cd.set(Calendar.DAY_OF_MONTH, 0);

        return shortSdf.format(cd.getTime()) + " 00:00:00";
    }

    /**
     * 获得入参日期次年的第一天
     *
     * @return 入参日期次年的第一天
     */
    public static String firstDayOfNextYear() {
        //获得入参的日期
        Calendar cd = Calendar.getInstance();
        cd.setTime(new Date());

        //获取次年第一天：
        cd.add(Calendar.YEAR, 1);
        //设置为1月1号,当前日期既为次年第一天
        cd.set(Calendar.MONTH, 0);
        cd.set(Calendar.DAY_OF_MONTH, 1);

        return shortSdf.format(cd.getTime()) + " 00:00:00";
    }

    /**
     * 获得入参日期次年的最后一天
     *
     * @return 入参日期次年的第一天
     */
    public static String lastDayOfNextYear() {
        //获得入参的日期
        Calendar cd = Calendar.getInstance();
        cd.setTime(new Date());

        //获取次年第一天：
        cd.add(Calendar.YEAR, 1);
        //设置为1月1号,当前日期既为次年第一天
        cd.set(Calendar.MONTH, 11);
        cd.set(Calendar.DATE, 31);

        return shortSdf.format(cd.getTime()) + " 00:00:00";
    }

    /**
     * 下季度的开始时间，即2012-01-1 00:00:00
     *
     * @return str
     */
    public static String getNextCurrentQuarterStartTimeStr() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        String now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3)
                c.set(Calendar.MONTH, 3);
            else if (currentMonth >= 4 && currentMonth <= 6)
                c.set(Calendar.MONTH, 6);
            else if (currentMonth >= 7 && currentMonth <= 9)
                c.set(Calendar.MONTH, 9);
            else if (currentMonth >= 10 && currentMonth <= 12) {
                c.add(Calendar.YEAR, 1);
                c.set(Calendar.MONTH, 0);
            }
            c.set(Calendar.DATE, 1);
            now = shortSdf.format(c.getTime()) + " 00:00:00";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 下季度的结束时间，即2012-03-31 23:59:59
     *
     * @return
     */
    public static String getNextCurrentQuarterEndTimeStr() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        String now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3) {
                c.set(Calendar.MONTH, 5);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 4 && currentMonth <= 6) {
                c.set(Calendar.MONTH, 8);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 7 && currentMonth <= 9) {
                c.set(Calendar.MONTH, 11);
                c.set(Calendar.DATE, 31);
            } else if (currentMonth >= 10 && currentMonth <= 12) {
                c.add(Calendar.YEAR, 1);
                c.set(Calendar.MONTH, 2);
                c.set(Calendar.DATE, 31);
            }
            now = shortSdf.format(c.getTime()) + " 23:59:59";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    public static String date2Str(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

}
