package com.zz.ThreadClass;

/**
 *  线程测试类
 *  线程创建方式：继承Thread类，重写run方法，调用start方法启动线程
 *  线程状态：新建、就绪、运行、阻塞、死亡
 *   线程优先级：1-10，默认5
 *   创建线程的两种方式：
 *   1. 继承Thread类，重写run方法，调用start方法启动线程
 *      创建一个Thread类的子类，并重写其run()方法，然后创建Thread类的对象，调用start()方法启动线程
 *      优点：简单，容易实现，线程间通信方便
 *      缺点：扩展性差，无法控制线程的优先级，无法获取线程的返回值
 *   2. 实现Runnable接口，重写run方法，创建Thread对象，调用start方法启动线程
 *      创建一个实现Runnable接口的类，并重写其run()方法，然后创建Thread类的对象，调用start()方法启动线程
 *      优点：可以控制线程的优先级，可以获取线程的返回值
 *      缺点：复杂，需要实现Runnable接口，线程间通信麻烦
 * @author zz
 * @create --   2019年1月10日   下午10:22:22
 */

public class Extend_thread extends Thread {

    public static void main(String[] args) throws InterruptedException {
//        Extend_thread extendthread = new Extend_thread();
//        extendthread.setName("线程");
//        extendthread.start();
//        System.out.println("主线程：" + Thread.currentThread().getName() + "，线程状态：" + Thread.currentThread().getState());
//        for (int i = 0; i < 10; i++) {
//            System.out.println("主线程：" + Thread.currentThread().getName() + "，i=" + i);
//        }
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.setName("1号线程");
        thread2.setName("主线程");
//        thread1.setPriority(Thread.MIN_PRIORITY);
//        thread2.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread1.join();
        thread2.start();
    }



    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "，线程状态：" + Thread.currentThread().getState() + "，i=" + i);
        }
        System.out.println(Thread.currentThread().getName() + "，线程状态：" + Thread.currentThread().getState() + "，线程结束");
    }



}
class Thread1 extends Thread {

    public void run() {
        System.out.println("线程" + this.getName() + "优先级：" + this.getPriority());
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "，线程状态：" + Thread.currentThread().getState() + "，i=" + i);
        }
        System.out.println(Thread.currentThread().getName() + "，线程状态：" + Thread.currentThread().getState() + "，线程结束");

    }
}
class Thread2 extends Thread {
    public void run() {

        System.out.println("线程" + this.getName() + "优先级：" + this.getPriority());
        for (int i = 0; i < 100; i++) {

            System.out.println(Thread.currentThread().getName() + "，线程状态：" + Thread.currentThread().getState() + "，i=" + i);
//            if (i%20 == 0) {
//                this.yield();//线程让出CPU资源，让其他线程运行
//                System.out.println("线程" + this.getName() + "，调用yield()");
//                System.out.println("线程" + this.getName() + "，调用sleep(1000)"+"状态"+Thread.currentThread().getState());
//            }
//            if (i%20 == 0) {//
//                try {
//                    sleep(1000);//线程休眠1秒钟，让出CPU资源
////                    System.out.println("线程" + this.getName() + "，调用sleep(1000)"+"状态"+Thread.currentThread().getState());
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.println("线程" + this.getName() + "，调用sleep(1000)"+"状态"+Thread.currentThread().getState());
//            }
        }

        System.out.println(Thread.currentThread().getName() + "，线程状态：" + Thread.currentThread().getState() + "，线程结束");
    }
}
