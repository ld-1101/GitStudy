package com.zz.StringClass;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @author zz
 * @create 2024-11-08   上午11:14
 */
//public  class DateClasss {
//    //simpledateformat
//    //日期-》字符串
//}
public class DateClasss {
    @Test
    public void test1() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new java.util.Date());
        System.out.println(format);
    }

    //string-》日期
    @Test
    public void test2() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date parse = simpleDateFormat.parse("2024-11-08 11:14:00");
        System.out.println(parse);
    }

    @Test
    public void test3() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(4654654654654L);
        System.out.println(format);
        Date date = simpleDateFormat.parse(format);
        System.out.println(date);
    }
    @Test
    public void test4(){
        int time = LocalTime.now().toSecondOfDay();
        long time1 = System.currentTimeMillis();
        int a = 0;
        for (int i = 0; i < 1000000; i++) {
            a++;
        }
        System.out.println(a);
        System.out.println(LocalTime.now().toSecondOfDay() - time);
        System.out.println(System.currentTimeMillis() - time1);


    }
    @Test
    public void test5() {
        LocalDate now = LocalDate.now();
        System.out.println(now.getDayOfMonth());
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        zonedDateTime.withMonth(5);
        System.out.println(zonedDateTime.toString());
        long nanoOfDay = LocalTime.now().toNanoOfDay();
        int a = 0;
        for (int i = 0; i < 10000000; i++) {
            a++;
        }
        long nanoOfDay1 = LocalTime.now().toNanoOfDay();
        Duration duration = Duration.ofNanos(nanoOfDay1 - nanoOfDay);
        Duration duration1 = duration.withNanos(123456);
        System.out.println(duration1.toNanosPart());
        System.out.println(duration.toNanosPart());
        System.out.println(nanoOfDay1 - nanoOfDay);
    }
    @Test
    public void test6() {
        Instant instant = Instant.now();
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(instant.toString());
        long epochSecond = instant.getEpochSecond();
        System.out.println(epochSecond);
        System.out.println(offsetDateTime.toOffsetTime().toString());
        long nano = instant.getNano();
        System.out.println(nano);
    }
    @Test
    public void test7() {
        TemporalAccessor parse = DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse("2024-11-08T11:14:00+08:00");
//        System.out.println(parse.);

    }
    @Test
    public void test8() {

    }





    //main方法
    public void main() {
//    test3();
    }
}
