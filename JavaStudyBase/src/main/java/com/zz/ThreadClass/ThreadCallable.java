package com.zz.ThreadClass;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zz
 * @create 2024-10-31   下午9:42
 */
public class ThreadCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallThread callThread = new CallThread();
        FutureTask<Integer> futureTask = new FutureTask<>(callThread);
        new Thread(futureTask).start();
        Integer result = futureTask.get();
        System.out.println("result:" + result);
//        try {
//            System.out.println(futureTask.get());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }
}

class CallThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        return 100;
    }
}
