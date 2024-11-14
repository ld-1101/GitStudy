package com.zz.StringClass;

import org.junit.Test;

import java.util.Scanner;


public class StringClass {


    //模拟trim()方法
    @Test
    public void test() {
        String str = " abc ";
        System.out.println("原字符串："+str);
        System.out.println("去除两端空格后："+myTrim(str));
    }
    
    public String myTrim(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end && str.charAt(start) == ' '  ){
            start++;
        }
        while (end >=start && str.charAt(end)==' '){
            end--;
        }
        
        return str.substring(start, end+1);
    }


    //反转指定字符串

    public void test2() {
        String str = "abcdefghijklmnopqrst";
        System.out.println("原字符串："+str);
        System.out.println("字符长度范围："+0+"---"+str.length());
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入起始位置：");
        int i = scanner.nextInt();
        System.out.print("请输入结束位置：");
        int j = scanner.nextInt();
        System.out.println("反转后："+reverse_string(str,i,j));
    }
    String reverse_string(String str,int start,int end) {
        String string1=str.substring(start,end);
        StringBuilder sb=new StringBuilder(string1);
        str=str.substring(0,start)+sb.reverse()+str.substring(end);
        return str;
    }

    //获取一个字符在字符串中出现的次数
    public void test3() {
        String str = "sasasasasasasasa";
        System.out.println("原字符串：" + str);
        System.out.print("请输入要查找的字符：");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println("字符" + string + "在字符串中出现的次数：" + count_string(str, string));
    }

    public int count_string(String str, String string) {
        int count = 0;
        int index = 0;
        while (true){
            if (index >= str.length()){
            break;}
            else
                if (str.indexOf(string, index) != -1){
                    count++;
                    index = str.indexOf(string, index) + 1;
                }
                else {
                    break;
                }

        }


        return count;
    }
    @Test
    public void test4() {
        String str = "cvjkadfvnsdjklsandjklfvndfkj;nva;sasasasamkljlkaskjlajhkahsajksahkjsahsakjahskjaskhakjsasahkshakjshajksasasasas";
        String string = "c";
        int index = 0;
        System.out.println(str.indexOf(string, index));
    }
    //获取两个子字符串的最长公共子串
    public void test5() {
        String str = "abdsjdshabcsajkabcdjaklabcjdsajdlkabcdjalsjlabc";
        String str1 = "abdsjdcsajkadsajdlsjlab";
        System.out.println("原字符串：" + str);
        System.out.println("原字符串：" + str1);
        System.out.println("最长公共子串：");
        String[] result = getMaxSameString3(str, str1);
        for (String s : result) {
            System.out.println(s);
//        }
//    }
//        for(String s : getMaxSameString2(str, str1)){
//            System.out.println(s);
//        }
        }
    }

    //获取两个字符串的最长公共子串,只有一个字符串
    String get_common_string(String str, String str1) {
        String longest = str.length() >= str1.length() ? str : str1;//最长字符串
        String shortest = str.length() < str1.length() ? str : str1;//最短字符串
        String public_string = "";//公共子串
        int max_length = 0;//最长公共子串长度
        for(int i = 0 ;i<shortest.length();i++){
            for(int j = i;j<shortest.length();j++){
                String sub_str = shortest.substring(i,j+1);
                if(longest.contains(sub_str)){
                    if(sub_str.length() > max_length){
                        max_length = sub_str.length();
                        public_string = sub_str;
                    }
            }
        }}
    return public_string;
    }
    //获取两个字符串的最长公共子串,两个字符串都有
    String[] getMaxSameString2(String str1, String str2) {
        if (str1 != null && str2 != null) {
            String maxString = (str1.length() > str2.length()) ? str1 : str2;
            String minString = (str1.length() > str2.length()) ? str2 : str1;
            int len = minString.length();// 最小字符串的长度
            int maxLen = 0;// 最大字符串的长度
            int MAX_LEN = 1;// 最大相同子串的长度
            String[] result = new String[10];// 存放结果
            for (int i = 0; i < len; i++) {
                for (int j = i; j < len; j++) {
                    String subString = minString.substring(i, j+1);
                    if (maxString.contains(subString)) {
                        if (subString.length() > maxLen) {
                            maxLen = subString.length();
                            result[0] = subString;
                        }
                    }
                }
            }
            for (int i = 0; i < len; i++) {
                for (int j = i; j < len; j++) {
                    String subString = minString.substring(i, j+1);
                    if (maxString.contains(subString)) {
                        if (subString.length() == maxLen && !result[MAX_LEN-1].equals(subString)) {
                            result[MAX_LEN++] = subString;
                        }

                    }
                }
            }
            return result;
        }
        return null;
    }

    String[] getMaxSameString3(String str1, String str2) {
        int count = 0;
        StringBuffer temp = null;
        if (str1 != null && str2 != null) {
            String maxString = (str1.length() > str2.length()) ? str1 : str2;
            String minString = (str1.length() > str2.length()) ? str2 : str1;
            int len = minString.length();// 最小字符串的长度
            int maxLen = 0;// 最大字符串的长度
            int MAX_LEN = 1;// 最大相同子串的长度
            temp = new StringBuffer();
            count = 1;
            for (int i = 0; i < len; i++) {
                for (int j = i; j < len; j++) {
                    String subString = minString.substring(i, j + 1);
                    if (maxString.contains(subString)) {
                        if (subString.length() > maxLen) {
                            maxLen = subString.length();
                        }
                    }
                }
            }
            for (int i = 0; i < len; i++) {
                for (int j = i; j < len; j++) {
                    String subString = minString.substring(i, j + 1);
                    if (maxString.contains(subString)) {
                        if (subString.length() == maxLen) {
                            temp.append(subString+",");
                            count++;
                        }
                    }

                }
            }
        }
        System.out.println(temp.toString());
        String[] result = temp.toString().split(",");
        return result;
    }




    public static void main(String[] args) {
        StringClass stringClass = new StringClass();
        stringClass.test5();
    }
}
