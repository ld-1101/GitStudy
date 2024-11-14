package com.zz.ThreadClass;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zz
 * @create 2024-10-31   下午10:06
 */
public class Thread_pool {
    public static void main(String[] args) {
        // 创建线程池
        ExecutorService service = Executors.newFixedThreadPool(8);
        System.out.println(service.getClass().getName());
        ThreadPoolExecutor executor = (ThreadPoolExecutor) service;
        System.out.println("corePoolSize: " + executor.getCorePoolSize());// 线程池的基本大小
        System.out.println("maximumPoolSize: " + executor.getMaximumPoolSize());// 线程池最大线程数
        System.out.println("poolSize: " + executor.getPoolSize());// 当前线程池中线程数
        System.out.println("activeCount: " + executor.getActiveCount());// 当前线程池中活动线程数
        System.out.println("taskCount: " + executor.getTaskCount());// 当前线程池中排队等待的任务数
        System.out.println("completedTaskCount: " + executor.getCompletedTaskCount());// 当前线程池中已完成的任务数
        executor.setCorePoolSize(10);
//        service.execute();// 执行Runnable对象,没有返回值
        // service.submit();// 执行Callable对象,有返回值
//
//        Thread thread = new Thread(new Runnable(){
//            @Override
//            public void run() {
//                System.out.println("runnable");
//            }
//
//        });
////        service.submit(thread);
//        service.execute(thread);
//        service.submit(new Callable() {
//            @Override
//            public Object call() throws Exception {
//                System.out.println("callable");
//                return null;
//            }
//
//        });
    }
}
