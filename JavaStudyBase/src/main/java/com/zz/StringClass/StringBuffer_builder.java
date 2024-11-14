package com.zz.StringClass;

import org.junit.Test;

import java.util.Date;

/**
 * @author zz
 * @create 2024-11-05   下午2:21
 */
public class StringBuffer_builder {

    @Test
    public void test() {

        StringBuffer sb = new StringBuffer();
        sb.append("hello");
        sb.append("world");
        sb.append("!");
        sb.append("java");
        sb.append("!");

        System.out.println(sb);
        sb.delete(1,2);
        System.out.println(sb);
        sb.deleteCharAt(6);
        System.out.println(sb);
        sb.insert(1,"a");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        String substring = sb.substring(1, 4);
        System.out.println(substring);
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        System.out.println(sqlDate);
        System.out.println(date);


    }







    public static void main(String[] args) {

    }
}

