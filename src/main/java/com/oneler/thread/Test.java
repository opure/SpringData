package com.oneler.thread;

import java.time.LocalDate;
import java.time.Period;

public class Test {

    public static void main(String[] args) {
        LocalDate today = LocalDate.parse("2018-12-31");
      //  LocalDate today = LocalDate.of(2018, 12, 31);
        System.out.println("Today : " + today);
        LocalDate birthDate = LocalDate.of(2018, 07, 11);
        System.out.println("BirthDate : " + birthDate);

        Period p = Period.between(birthDate, today);
        System.out.printf(" %d 日",today.toEpochDay() - birthDate.toEpochDay());
    }
}
//174  19 小时

//191 20.93

//174 19