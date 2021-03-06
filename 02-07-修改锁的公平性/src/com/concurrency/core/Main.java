package com.concurrency.core;

import com.concurrency.task.Job;
import com.concurrency.task.PrintQueue;

public class Main {
    public static void main(String[] args) {
        // 创建一个打印队列
        PrintQueue printQueue = new PrintQueue();

        // 创建10个打印任务并且将其放入到不同的线程中运行
        Thread thread[] = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread " + i);
        }

        // 每隔0.1s运行一个线程，一个10个线程
        for (int i = 0; i < 10; i++) {
            thread[i].start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
