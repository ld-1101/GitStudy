package com.zz.thread;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author zz
 * @create 2024-10-31   下午9:03
 */
public class Thread_test {
    public static void main(String[] args) {

        Employee employee = new Employee();
        Producer producer = new Producer();
        Customer customer = new Customer();

        producer.start(employee);
        customer.start(employee);


    }
}

class Employee {//员工类
    private int num = 20;
    void bought() {//购买商品方法
        while (true) {
            synchronized (this){
                if (num > 0) {
                    this.notifyAll();
//                    System.out.println(Thread.currentThread().getName() + "正在购买商品...");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int boughtNum = ThreadLocalRandom.current().nextInt(1, num + 1);
                    System.out.println(Thread.currentThread().getName() + "购买了" + boughtNum%5 + "件商品");
                    num -= boughtNum%5;

                } else {

                    System.out.println(Thread.currentThread().getName() + "暂时没有商品可以购买，等待制作食物...");
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
    void makefood() {
        while (true) {
            synchronized (this){
                if(num < 20){
                    this.notifyAll();
//                    System.out.println(Thread.currentThread().getName() + "正在制作食物...");//制作食物
                    num++;

                }else {
//                this.notifyAll();
                    System.out.println(Thread.currentThread().getName() + "食物已经做好，等待用户购买...");
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    }
}
class Producer implements Runnable {//生产者类

    private Employee employee;

    void start(Employee employee) {
        this.employee = employee;
        Thread producerThread = new Thread(this, "生产者");
        producerThread.start();
    }

    @Override
    public void run() {
        employee.makefood();//调用制作食物方法
    }
}
class Customer implements Runnable {//消费者类
    private Employee employee;

    void start(Employee employee) {
        this.employee = employee;
        Thread customerThread = new Thread(this, "消费者");
        customerThread.start();
    }
    @Override
    public void run() {
        employee.bought();//调用购买商品方法
    }
}