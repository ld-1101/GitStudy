package com.zz.ThreadClass;

/**
 * @author zz
 * @create --
 */
public class Imp_runnable implements Runnable {
    public static void main(String[] args) {
        Imp_runnable runnable = new Imp_runnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }



    @Override
    public void run() {
            System.out.println("Hello from runnable");
    }
}
