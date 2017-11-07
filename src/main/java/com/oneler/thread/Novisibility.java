package com.oneler.thread;

public class Novisibility {
    private static boolean ready;
    private static int number;

    private static class ReadThread extends Thread {
        @Override
        public void run() {
            while (!ready);
            System.out.println("aa");

        }
    }

    public static void main(String[] args) throws InterruptedException {
        ready = true;
        new ReadThread().start();
        Thread.sleep(100);
        number = 42;
        Thread.sleep(10000);
    }

}
