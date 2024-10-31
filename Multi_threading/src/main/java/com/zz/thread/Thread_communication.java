package com.zz.thread;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 线程通信
 *
 * @author zz
 * @create --
 */
public class Thread_communication {

    public static void main(String[] args) {

        MyThread2 myThread2 = new MyThread2();
        myThread2.start();

    }

}

class MyThread implements Runnable {
    private int count = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                this.notify();
                if(count <= 20){
                    System.out.println(Thread.currentThread().getName() + " : " + count);
                    count++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    break;
                }
            }

        }
    }
}

class MyThread2 implements Runnable {

    private int product_num = 5;

    @Override
    public void run() {
    }
//    private void init(){
//        if(product_num %5 == 0){
//            start();
//        }
//    }
    public void start(){

        customerThread.start();
        productThread.start();
//        init();

    }
    Thread customerThread = new Thread("消费者线程"){

        MyThread myThread = new MyThread();
        @Override
        public void run() {

            while(true){
                synchronized (this) {
                    if(product_num > 0){//消费者线程--消费1-10个产品

                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        int Bought_num = ThreadLocalRandom.current().nextInt(1, (product_num+1));
                        System.out.println(Thread.currentThread().getName() + " : " + Bought_num%5);
                        product_num -= Bought_num%5;
                        }
                    else{
                        customerThread.setPriority(Thread.MIN_PRIORITY);
                        productThread.setPriority(Thread.MAX_PRIORITY);
                            this.notify();
                            try {
                                wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                    }
                }
            }

        }

    };
    Thread productThread = new Thread("生产者线程"){//生产者线程--生产到20个产品
        @Override
        public void run() {
            while(true){
                synchronized (this) {

                    if(product_num <20){
                        System.out.println(Thread.currentThread().getName() + " : " + product_num);
                        product_num += 1;
                    }
                        else{
                            customerThread.setPriority(Thread.MAX_PRIORITY);
                            productThread.setPriority(Thread.MIN_PRIORITY);
                            this.notify();
                            try {
                                wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                    }

                }
            }
        }
    };
}


