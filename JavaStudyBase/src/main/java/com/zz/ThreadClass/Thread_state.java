package com.zz.ThreadClass;

/**
 * state of thread
 * 线程状态
 *  1. NEW: 新创建的线程，尚未启动
 *  2. RUNNABLE: 线程正在执行 Runnable 的 run() 方法
 *  3. BLOCKED: 线程被阻塞，即线程正在等待一个 Monitor lock
 *  4. WAITING: 线程处于等待状态，即调用了 Object.wait() 方法
 *  5. TIMED_WAITING: 线程处于等待状态，但只在指定的时间段内有效
 *  6. TERMINATED: 线程已经执行完毕
 *  7. UNKNOWN: 线程处于未知状态
 * @author zz
 * @create --
 */
public class Thread_state {
}
