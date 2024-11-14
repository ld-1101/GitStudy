package com.zz.StringClass;

import org.junit.Test;

/**
 * @author zz
 * @create 2024-11-01   下午12:47
 */
public class StringDemo1 {
    public static void main(String[] args) {
        String str1 = "hello world";
        String str2 = "hello world";
        System.out.println(str1 == str2);
    }

    //测试方法
    @Test
    public void test(){
        String str1 = "hello world";
        String str2 = "hello world";
        str1 = str1 + str2;
        System.out.println(str1 == str2);
    }
    @Test
    public void test2(){
        String str1 = "hello world";
        System.out.println(str1.hashCode());
        str1="sacas";
        System.out.println(str1.hashCode());
        String str2 = "hello world";
        System.out.println(str2.hashCode());
    }
    @Test
    public void test3() {
        String str1 = "hello world";
        String str2 = "hello world";
        String str3 = new String("hello world");
        String str4 = new String("hello world");
        System.out.println("str1的hashCode为："+str1.hashCode());
        System.out.println("str2的hashCode为："+str2.hashCode());
        System.out.println("str3的hashCode为："+str3.hashCode());
        System.out.println("str4的hashCode为："+str4.hashCode());
        System.out.println("str1与str2是否相等："+(str1==str2));
        System.out.println("str3与str4是否相等："+(str3==str4));
        System.out.println("str1与str3是否相等："+(str1==str3));
        System.out.println("str2与str4是否相等："+(str2==str4));
    }




}

//@Test
