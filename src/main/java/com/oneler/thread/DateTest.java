package com.oneler.thread;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateTest {
    public static void main(String[] args) throws InterruptedException {

        LocalDateTime now = LocalDateTime.now();

        System.out.println(now);

        LocalDateTime data = LocalDateTime.parse("2017-10-27T18:17:00");
        LocalDateTime data1 = LocalDateTime.parse("2017-10-27T18:47:00");
        System.out.println(data.plusSeconds(1));

        while (true) {
            if(LocalDateTime.now().isAfter(data1)) {
                System.out.println("T^TTTETE");
                break;
            } else {
               // Thread.sleep(1000);
                System.out.println("没有到");
            }
        }
    }
}
