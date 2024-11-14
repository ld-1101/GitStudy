package com.zz.ThreadClass;

/**
 * thread方法
 * 1.start()：启动线程，调用该方法后，线程开始执行；
 * 2.run()：线程体，线程执行体，由子类实现；
 * 3.currentThread()：获取当前线程对象；
 * 4.getName()：获取线程名称；
 * 5.setName()：设置线程名称；
 * 6.yield()：暂停当前线程的执行，并让其他线程有机会执行；
 * 7.join()：等待线程执行结束后再继续执行, 调用该方法的线程会被阻塞，直到目标线程执行结束, 才会继续执行.
 * 8.sleep()：暂停当前线程指定的时间，单位为毫秒；
 * 9.stop()：停止线程，不推荐使用；
 * 10.isAlive()：判断线程是否存活；
 * 11.setPriority()：设置线程优先级, 范围为1~10，数值越大优先级越高,并不是绝对的，具体取决于系统资源，一般情况下，优先级为5。
 *
 * @author zz
 * @create --
 */
public class Thread_method extends Thread {

    private static int count = 100;
    public static void main(String[] args) throws InterruptedException {
//        Thread_method thread = new Thread_method();
//        Thread_method thread2 = new Thread_method();
//        Thread_method thread3 = new Thread_method();
//        thread.setName("thread1");
//        thread2.setName("thread2");
//        thread3.setName("thread3");
//        thread.start();
//        thread2.start();
//        thread3.start();

        Theard1 t1 = new Theard1();
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t1);
        thread1.start();
        thread2.start();

    }
    public void run() {
        ;
        while (count > 0){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        if(count > 0){
            System.out.println(Thread.currentThread().getName() + " count = " + count);
            count--;

        }
    }}
}

class Theard1 implements Runnable {
    private int count = 100;
    @Override
    public void run() {
        while (true){
//            try {
//                Thread.sleep(1000);
//
//            }    catch (InterruptedException e) {
//                e.printStackTrace();
//                }
        if (count > 0){
            System.out.println(Thread.currentThread().getName() + " count = " + count);
            count--;
        }else {
            break;
        }
    }}
}
