package com.oneler.thread;

public class BadSuspend {
    public static Object object = new Object();

    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends  Thread {
        public ChangeObjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        t2.start();
       // Thread.sleep(100);
        t1.resume();

        t2.resume();
    }
}
