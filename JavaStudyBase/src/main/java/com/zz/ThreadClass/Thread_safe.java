package com.zz.ThreadClass;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程安全问题
 *解决方案：
 * 1.使用同步机制，确保同一时间只有一个线程可以访问共享资源。
 *   synchronized关键字可以保证线程安全，因为它可以保证同一时间只有一个线程可以访问共享资源。
 *    同步机制可以保证共享资源的原子性，即一个操作要么全部完成，要么全部不完成。
 *
 * 2.使用线程安全的容器，比如ConcurrentHashMap。
 * 3.使用锁机制，比如ReentrantLock。
 * 4.使用原子类，比如AtomicInteger。
 * 5.使用volatile关键字。
 * 6.使用线程本地存储。
 * 7.使用不可变类。
    @author zz
    @create --
*/public class Thread_safe {
    public static void main(String[] args) {

//        TheardSafeExample theardSafeExample = new TheardSafeExample();
//        TheardSafeExample2 theardSafeExample = new TheardSafeExample2();
//        TheardSafeExample3 theardSafeExample = new TheardSafeExample3();
        TheardSafeExample4 theardSafeExample = new TheardSafeExample4();
        Thread t1 = new Thread(theardSafeExample, "用户1");
        Thread t2 = new Thread(theardSafeExample, "用户2");
        Thread t3 = new Thread(theardSafeExample, "Thread-3");
        Thread t4 = new Thread(theardSafeExample, "Thread-4");
        Thread t5 = new Thread(theardSafeExample, "Thread-5");
        Thread t6 = new Thread(theardSafeExample, "Thread-6");
        Thread t7 = new Thread(theardSafeExample, "Thread-7");
        Thread t8 = new Thread(theardSafeExample, "Thread-8");
        t1.start();
        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
//        t6.start();
//        t7.start();
//        t8.start();
    }
}
//#########################
//synchronized 关键字可以保证线程安全，因为它可以保证同一时间只有一个线程可以访问共享资源。
class TheardSafeExample implements Runnable {
    private int count = 100000;
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        while (count > 0){
            synchronized (this) {//同步监视器，任何线程要访问共享资源，必须先获取同步监视器，任何类都可以作为同步监视器
                if (count > 0){
                    System.out.println(Thread.currentThread().getName() + " : " + count);
                    count--;
                }else{
                    break;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + " : " + (end - start) + "ms");
    }
}
//##############################
//同步方法 实现线程安全
class TheardSafeExample2 implements Runnable {
    private int count = 100000;
    @Override
    public void run() {
        int i = 0;
        long start = System.currentTimeMillis();
        while (i == 0){

            i=buy_ticket(count);

        }
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + " : " + (end - start) + "ms");
    }
    private static  synchronized int buy_ticket(int count){
        if (count > 0){
            System.out.println(Thread.currentThread().getName() + " : " + count);
            count--;
        }else{
//            System.out.println("票已售完");
            return -1;
        }
        return 0;
    }
}
//########################
//lock 机制
class TheardSafeExample3 implements Runnable {
    private int count = 100000;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        while (true) try {
            lock.lock();
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + count);
                count--;
            } else {
//            System.out.println("票已售完");
                break;
            }
        } finally {
            lock.unlock();
        }
        long end = System.currentTimeMillis();
        System.out.println(     Thread.currentThread().getName() + " : " + (end - start) + "ms");
    }

}
//########################
class TheardSafeExample4 implements Runnable {

    private int bankCardMoney = 1000;
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        for (int i = 0; i <3 ; i++) {
            try {
                lock.lock();
                bankCardMoney += 1000;
                System.out.println("用户"+Thread.currentThread().getName()+"充值1000元，当前余额："+bankCardMoney);
            }finally {
                lock.unlock();
            }
        }

    }
}