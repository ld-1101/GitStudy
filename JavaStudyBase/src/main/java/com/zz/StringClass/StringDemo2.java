package com.zz.StringClass;

import org.junit.Test; /**
 * @author zz
 * @create 2024-11-04   上午8:38
 */
public class StringDemo2 {


    @Test
    public void test() {

        //100字符的字符串
        String str1 = "  hello word hello world hello world hello world  ";
        String str2 = "hello word hello world hello world hello world";
//        System.out.println(str1.length());
//        System.out.println(str1.charAt(11));
//        System.out.println(str1.isEmpty());
//        System.out.println(str1.toLowerCase());
//        System.out.println(str1.toUpperCase());
//        System.out.println(str1.trim());
//        System.out.println(str1.concat("hello"));
//        System.out.println(str1.compareTo(str2));
//        System.out.println("aaaAAAAAAAAAA".compareTo("aaaaazaz"));
//        System.out.println(str1.substring(11, 20));
    }


    @Test
    public void test2() {
        String str1 = "hello world";
        String str2 = "hello world";
        String str3 = "hello world";
        System.out.println(str1.endsWith("world"));
        System.out.println(str1.startsWith("hello"));
        System.out.println(str1.startsWith("world", 6));
        System.out.println(str1.contains("world"));
        System.out.println(str1.indexOf("xx", 6));
        System.out.println(str1.lastIndexOf("l", 6));
    }

    @Test
    public void test3() {
        String str1 = "hello world";
//        System.out.println(str1.replace("l", "L"));
//        System.out.println(str1.replace("ll", "LL"));
        String str2 = "aaa,dasdasd,fdsfdsf,wqeqweqw,dfsdfs";
        String[] strArr = str2.split(",");
        for (String str : strArr) {
            System.out.println(str);
        }
        
    }

    @Test
    public void test4() {


    }

    @Test
    public void test5() {
    }

    @Test
    public void test6() {
    }

    @Test
    public void test7() {
    }

    @Test
    public void test8() {
    }

    @Test
    public void test9() {
    }

    @Test
    public void test10() {
    }

    @Test
    public void test11() {
    }

    @Test
    public void test12() {
    }

    @Test
    public void test13() {
    }

    @Test
    public void test14() {
    }

    @Test
    public void test15() {
    }

    @Test
    public void test16() {
    }

    @Test
    public void test17() {
    }

    @Test
    public void test18() {
    }

    @Test
    public void test19() {
    }

    @Test
    public void test20() {
    }

    @Test
    public void test21() {
    }
}


