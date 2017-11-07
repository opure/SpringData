package com.oneler.thread;

import java.util.Random;
import java.util.concurrent.*;

public class ThreadLocalTest {
    public static final int GEN_COUNT = 100000000;

    public static final int COUNT_THREAD = 4;

    static ExecutorService ex = Executors.newFixedThreadPool(COUNT_THREAD);

    public static Random rd = new Random(123);

    public static ThreadLocal<Random> tRd = new ThreadLocal<Random>() {
        @Override
        protected Random initialValue() {
            return new Random(123);
        }
    };

    public static class RandTask implements Callable<Long> {

        private int code = 0;

        public RandTask(int code) {
            this.code = code;
        }


        public Random getRando() {
            if (code == 0) {
                return rd;
            } else {
                return tRd.get();
            }
        }

        @Override
        public Long call() throws Exception {
            long start = System.currentTimeMillis();
            for (int i = 0; i < GEN_COUNT; i++) {
                getRando().nextInt();
            }
            long end = System.currentTimeMillis();
            System.out.println("spend" + (end - start));
            return end -start;
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<Long>[] futures = new Future[COUNT_THREAD];

        for (int i = 0; i < futures.length ; i++) {
            futures[i] = ex.submit(new RandTask(0));
        }
        long time = 0;
        for (int i = 0; i < COUNT_THREAD ; i++) {
            time += futures[i].get();
        }

        System.out.println("start"+time);

        System.out.println("-------------------------");
        for (int i = 0; i < futures.length ; i++) {
            futures[i] = ex.submit(new RandTask(1));
        }
         time = 0;
        for (int i = 0; i < COUNT_THREAD ; i++) {
            time += futures[i].get();
        }
        System.out.println(time+"end");

        ex.shutdown();




    }

}
