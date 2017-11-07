package com.oneler.thread;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WriterAndReadLock {
    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    private static Lock writeLock = reentrantReadWriteLock.writeLock();
    private static Lock readLock = reentrantReadWriteLock.readLock();

    private int value;

    public Object handelRead(Lock lock) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);
            return value;
        } finally {
            lock.unlock();
        }
    }

    public void handelWrite(Lock lock, int value) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);
            this.value = value;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        WriterAndReadLock writerAndReadLock = new WriterAndReadLock();
        Runnable runnable = () -> {
            try {
                writerAndReadLock.handelRead(lock);
            } catch (InterruptedException e) {
            }
        };

        Runnable runnable1 = () -> {
            try {
                writerAndReadLock.handelWrite(lock, new Random().nextInt());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 18; i++) {
            new Thread(runnable).start();

        }

        for (int i = 0; i < 2; i++) {
            new Thread(runnable1).start();
        }
    }

}
