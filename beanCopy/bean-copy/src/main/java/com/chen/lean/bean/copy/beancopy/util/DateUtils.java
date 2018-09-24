package com.chen.lean.bean.copy.beancopy.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by huangshaokang on 17/2/9.
 */
public class DateUtils {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    private static SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final String DATAFORMAT_STR = "yyyy-MM-dd";
    public static final String YYYYMMDD_DATAFORMAT_STR = "yyyyMMdd";
    public static final String YYYY_MMSTR = "yyyyMM";
    public static final String YYYY_MM_DATAFORMAT_STR = "yyyy-MM";
    public static final String DATATIMEF_STR = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYYMMDD_HHMMSS = "yyyyMMdd HHmmss";
    public static final String ZHCN_DATAFORMAT_STR = "yyyy年MM月dd日";
    public static final String ZHCN_DATATIMEF_STR = "yyyy年MM月dd日HH时mm分ss秒";
    public static final String ZHCN_DATATIMEF_STR_4yMMddHHmm = "yyyy年MM月dd日HH时mm分";
    public static final String MM_DD = "MM.dd";
    public static final String MMDD = "MMdd";

    public static String getDate(int len) {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, len);
        date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        return dateString;
    }

    public static Date getDate(int days, Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        date = calendar.getTime();
        return date;
    }

    /**
     * 根据起始日期获取月份
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static List<String> getMonth(String startDate, String endDate) {
        List<String> dats = new ArrayList<String>();
        try {
            SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = dfs.parse(startDate); // 开始日期
            Date date2 = dfs.parse(endDate); //结束日期
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            dats.add(startDate.subSequence(0, 7) + "");
            c1.setTime(date1);
            c2.setTime(date2);
            while (c1.compareTo(c2) < 0) {
                c1.add(Calendar.MONTH, 1);// 开始日期加一个月直到等于结束日期为止
                Date ss = c1.getTime();
                String str = dfs.format(ss);
                str = str.substring(0, str.lastIndexOf("-"));
                dats.add(str);
            }
            if (Integer.parseInt(startDate.split("-")[2]) - Integer.parseInt(endDate.split("-")[2]) < 0) {
                dats.remove(dats.size() - 1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dats;
    }

    public static Date getDate2(int days) {
        Date date = new Date();
        return getDate(days, date);
    }

    public static String getDate() {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateString = formatter.format(date);
        return dateString;
    }

    public static String getDateTime() {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        date = calendar.getTime();
        return new SimpleDateFormat("yyyyMMdd-HHmmss").format(date);
    }


    public static String getDate(String day, Integer len) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateString = "";
        try {
            Date date = new Date();
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(formatter.parse(day));
            calendar.add(Calendar.DATE, len);
            date = calendar.getTime();
            dateString = formatter.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateString;
    }

    public static List<String> getDateLength(String start, String end) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String s = start;
        String e = end;
        long quot = 0;
        List list = new ArrayList();
        try {
            Date date1 = sdf.parse(s);
            Date date2 = sdf.parse(e);
            quot = date2.getTime() - date1.getTime();
            quot = quot / 1000 / 60 / 60 / 24;
            Calendar cal = Calendar.getInstance();
            for (int i = 0; i <= (int) quot; i++) {
                cal.setTime(date1);
                cal.add(Calendar.DATE, i);
                list.add(new SimpleDateFormat("yyyyMMdd").format(cal.getTime()));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return list;
    }

    /**
     * 日期转换为字符串
     *
     * @param date
     * @param formate
     * @return
     */
    public static String dateToString(Date date, String formate) {
        DateFormat df = new SimpleDateFormat(formate);
        return df.format(date);
    }

    /**
     * 字符串转换为日期
     *
     * @param str
     * @param formate
     * @return
     */
    public static Date stringToDate(String str, String formate) {
        if (null == str || ("").equals(str.trim()))
            return null;
        DateFormat df = new SimpleDateFormat(formate);
        try {
            return df.parse(str.trim());
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获得两日期之间的日期
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static List<String> getDate(String startDate, String endDate) {
        Calendar startCalendar = Calendar.getInstance();
        Calendar endCalendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date stDate = null;
        Date eDate = null;
        List<String> rlist = new ArrayList<String>();
        try {
            stDate = df.parse(startDate);
            eDate = df.parse(endDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        startCalendar.setTime(stDate);

        endCalendar.setTime(eDate);
        while (true) {
            if (startCalendar.getTimeInMillis() <= endCalendar.getTimeInMillis()) {
                rlist.add(DateUtils.getDateToString(df.format(startCalendar.getTime())));
            } else {
                break;
            }
            startCalendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        return rlist;
    }

    /**
     * 获取今天之前的N天的日期列表
     *
     * @param days    N天之内的天数
     * @param formate 格式
     * @return
     */
    public static List<String> getDayList(int days, String formate) {
        List<String> list = new ArrayList<String>();
        Calendar begin = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();
        begin.setTime(getDayAfterNum(days, new Date()));
        end.setTime(new Date());
        end.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE) + 1);
        end.add(Calendar.DAY_OF_YEAR, -1);
        while (begin.before(end)) {
            list.add(dateToString(begin.getTime(), formate));
            begin.add(Calendar.DAY_OF_YEAR, 1);
        }
        return list;
    }

    /**
     * 获取某周第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int min = calendar.getActualMinimum(Calendar.DAY_OF_WEEK); //获取周开始基准
        int current = calendar.get(Calendar.DAY_OF_WEEK); //获取当天周内天数
        calendar.add(Calendar.DAY_OF_WEEK, min - current); //当天-基准，获取周开始日期
        calendar.add(Calendar.DAY_OF_WEEK, 1);//按中国习惯加一天
        return calendar.getTime();
    }

    /**
     * 获取某周最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int min = calendar.getActualMinimum(Calendar.DAY_OF_WEEK); //获取周开始基准
        int current = calendar.get(Calendar.DAY_OF_WEEK); //获取当天周内天数
        calendar.add(Calendar.DAY_OF_WEEK, min - current); //当天-基准，获取周开始日期
        calendar.add(Calendar.DAY_OF_WEEK, 7);
        return calendar.getTime();
    }

    public static boolean isLast(Date a) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Calendar b = Calendar.getInstance();
        b.setTime(a);
        String last = format.format(getCurrYearLast(b.get(Calendar.YEAR)));
        boolean is = format.format(a).equals(last);
        System.out.println(is);
        return is;
    }

    public static Date getCurrYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();
        return currYearLast;
    }

    public static int getDifferDays(Date begin, Date end) {
        return (int) ((end.getTime() - begin.getTime()) / (24 * 60 * 60 * 1000));
    }

    public static int getDifferDays(String begin, String end) {
        return getDifferDays(stringToDate(begin, YYYYMMDD_DATAFORMAT_STR), stringToDate(end, YYYYMMDD_DATAFORMAT_STR));
    }

    public static int getDifferDays(String begin, String end, String fmt) {
        return getDifferDays(stringToDate(begin, fmt), stringToDate(end, fmt));
    }

    /**
     * 获取日期年份
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static int getYear(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateFormat.parse(date));
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取日期月份
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static int getMonth(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateFormat.parse(date));
        return (calendar.get(Calendar.MONTH) + 1);
    }

    /**
     * 获取日期号
     *
     * @param date
     * @return int
     * @throws ParseException
     */
    public static int getDay(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateFormat.parse(date));
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取日期号
     *
     * @param date
     * @return
     */
    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取月份起始日期
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String getMinMonthDate(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateFormat.parse(date));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return dateFormat.format(calendar.getTime());
    }

    /**
     * 获取月份最后日期
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String getMaxMonthDate(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateFormat.parse(date));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return dateFormat.format(calendar.getTime());
    }


    /**
     * 获取月份最后日期
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date getMaxMonthDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * 获得N天后的日期
     *
     * @param num
     * @param date
     * @return
     */
    public static Date getDayAfterNum(Integer num, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, null == num ? 0 : num);
        return calendar.getTime();
    }

    /**
     * 获得N天后的日期,根据格式返回
     *
     * @param num
     * @param date
     * @return
     */
    public static String getDayAfterNum(Integer num, Date date, String formate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, num);
        return dateToString(calendar.getTime(), formate);
    }

    /**
     * N天之前
     */
    public static String getDayBeforeNum(String day, int num) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        String d = "";
        try {
            Date today = sdf.parse(day);
            long t = today.getTime();
            date = new Date(t - (24 * num * 60 * 60 * 1000));
            d = sdf.format(date);
        } catch (ParseException e) {
        }
        return d;
    }

    /**
     * 获得N月后的日期
     *
     * @param num
     * @param date
     * @return
     */
    public static Date getMonthAfterNum(Integer num, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, num);
        return calendar.getTime();
    }

    public static String format(Date date, String fmt) {
        DateFormat formatter = new SimpleDateFormat(fmt);
        return formatter.format(date);
    }

    /**
     * date转换为crontab表达式
     *
     * @param date
     * @return
     */
    public static String formatCron(Date date) {
        String dateFormat = "ss mm HH dd MM ? yyyy";
        return format(date, dateFormat);
    }

    public static String format() {
        return format(new Date(System.currentTimeMillis()), "yyyy-MM-dd");
    }

    public static String format(Date date) {
        return format(date, "yyyy-MM-dd");
    }

    // 时间格式yyyy-mm-dd转成yyyymmdd
    public static String getDateToString(String d) {
        if (d.indexOf("-") == -1) {
            return d;
        }
        return d.substring(0, 4) + d.substring(5, 7) + d.substring(8, 10);
    }

    public static Date getNow() {
        return new Date(System.currentTimeMillis());
    }

    public static Date getYesterday() {
        Date today = DateUtils.getNow();
        long t = today.getTime();
        Date date = new Date(t - 24 * 60 * 60 * 1000l);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(sdf.format(date));
        } catch (ParseException e) {

        }
        return date;
    }

    /**
     * 方法描述：取得当前日期的上月或下月日期 ,amount=-1为上月日期，amount=1为下月日期
     */
    public static String getFrontBackStrDate(String strDate, String format, int amount) throws ParseException {
        if (null == strDate) {
            return null;
        }
        try {

            DateFormat fmt = new SimpleDateFormat(format);
            Calendar c = Calendar.getInstance();
            c.setTime(fmt.parse(strDate));
            c.add(Calendar.MONTH, amount);
            return fmt.format(c.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 比较两个日期相差的天数
     */
    public static int getMargin(String date1, String date2) {
        int margin;
        try {
            ParsePosition pos = new ParsePosition(0);
            ParsePosition pos1 = new ParsePosition(0);
            Date dt1 = dateFormat.parse(date1, pos);
            Date dt2 = dateFormat.parse(date2, pos1);
            long l = dt1.getTime() - dt2.getTime();
            margin = (int) (l / (24 * 60 * 60 * 1000));
            return margin;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 判断传入的字符串是否为周末,格式:yyyyMMdd/yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static boolean isWeekEnd(String date) {
        try {
            return isWeekEnd(dateFormat.parse(date.replaceAll("-", "")));
        } catch (ParseException e) {
            return false;
        }

    }

    /**
     * 判断传入的日期是否周末
     *
     * @param date
     * @return
     */
    public static boolean isWeekEnd(Date date) {
        return (date.getDay() == 0 || date.getDay() == 6);
    }

    /**
     * 判断当天是否为生日
     *
     * @param birthday
     * @return
     * @throws ParseException
     */
    public static boolean isBirthday(String birthday) {
        if (null == birthday) {
            return false;
        }
        try {
            return dateToString(stringToDate(birthday, YYYYMMDD_DATAFORMAT_STR), MMDD).equals(dateToString(new Date(), MMDD));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }




    /**
     * 获取时间差秒
     *
     * @param format
     * @return
     */
    public static long getDayLastTime(Date date, String format) {
        String endPre = DateUtils.dateToString(date, DateUtils.DATAFORMAT_STR);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date endDate = sdf.parse(endPre + " 23:59:59");
            return endDate.getTime();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取指定时间的开始时刻
     */
    public static Date getBeginTimeOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取日期周的开始时间,周日作为周的结束日期
     */
    public static Date getBeginTimeOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {
            calendar.add(Calendar.DAY_OF_YEAR, -6);
        } else {
            calendar.set(Calendar.DAY_OF_WEEK, 2);
        }
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取日期月度开始时间
     */
    public static Date getBeginTimeOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取天的结束时刻
     */
    public static Date getEndTimeOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 获取日期周的结束时间,周日作为周的结束日期
     */
    public static Date getEndTimeOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        if (c.get(Calendar.DAY_OF_WEEK) != 1) {
            c.set(Calendar.DAY_OF_WEEK, 1);
            c.add(Calendar.DAY_OF_YEAR, 7);
        }
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }

    /**
     * 获取日期月度结束时间
     */
    public static Date getEndTimeOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }

    public static Date getStartTimeInCurrentYear() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DAY_OF_YEAR, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    public static Date getEndTimeInCurrentYear() {
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(Calendar.YEAR, LocalDateTime.now().getYear());
        c.roll(Calendar.DAY_OF_YEAR, -1);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }

    /**
     * 判断两个时间段是否有交集
     * @param startdate1
     * @param enddate1
     * @param startdate2
     * @param enddate2
     * @return
     */
    public static boolean isOverlap(String startdate1, String enddate1,String startdate2, String enddate2) {
        Date leftStartDate = null;
        Date leftEndDate = null;
        Date rightStartDate = null;
        Date rightEndDate = null;
        try {
            leftStartDate = formate.parse(startdate1);
            leftEndDate = formate.parse(enddate1);
            rightStartDate = formate.parse(startdate2);
            rightEndDate = formate.parse(enddate2);
        } catch (Exception e) {
            return false;
        }
        return ((leftStartDate.getTime() >= rightStartDate.getTime())
                && leftStartDate.getTime() < rightEndDate.getTime())
                ||
                ((leftStartDate.getTime() > rightStartDate.getTime())
                        && leftStartDate.getTime() <= rightEndDate.getTime())
                ||
                ((rightStartDate.getTime() >= leftStartDate.getTime())
                        && rightStartDate.getTime() < leftEndDate.getTime())
                ||
                ((rightStartDate.getTime() > leftStartDate.getTime())
                        && rightStartDate.getTime() <= leftEndDate.getTime());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(DateUtils.getEndTimeInCurrentYear());
    }
}
