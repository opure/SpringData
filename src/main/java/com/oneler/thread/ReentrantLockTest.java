package com.oneler.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();
    public static int i =0;
    @Override
    public void run() {
        for (int j = 0; j <10000000 ; j++) {
            lock.lock();
            try {
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest t1 = new ReentrantLockTest();
        Thread x = new Thread(t1);
        Thread y = new Thread(t1);
        x.start();
        y.start();
        x.join();
        y.join();
        System.out.println(i);
    }
}
