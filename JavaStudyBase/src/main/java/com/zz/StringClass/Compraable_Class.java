package com.zz.StringClass;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zz
 * @create 2024-11-11   上午10:29
 */
public class Compraable_Class implements Comparable<String> {


    @Test
    public void test() {
//        Comparable<String> comparable = new String("abc");
//        Comparable<String> comparable1 = new String("abc");
//        System.out.println(comparable.toString());
        Integer[]  integer = new Integer[10];
        integer[0]=1;
        integer[1]=2;
        integer[2]=3;
        integer[3]=4;
        integer[4]=5;
        integer[5]=6;
        integer[6]=7;
        integer[7]=8;
        integer[8]=9;
        integer[9]=10;
        Arrays.sort(integer);
        System.out.println(Arrays.toString(integer));
    }


    @Override
    public int compareTo(String o) {
        return 0;
    }
}

class Person1 {
    Person[] person=new Person[]{new Person("zhangsan",18),new Person("lisi",54),new Person("wangwu",36)};

    Comparator<Person> comparator=new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getAge() - o2.getAge();
        }
    };
}



