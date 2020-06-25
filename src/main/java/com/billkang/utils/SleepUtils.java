package com.billkang.utils;


import java.util.Random;


public class SleepUtils {
    private SleepUtils() {

    }

    public static void sleep(long randomMillis, long extraFixMillis) {
        try {
            Random random = new Random();
            Thread.sleep((long) random.nextInt((int) randomMillis) + extraFixMillis);
        } catch (Exception e) {

        }
    }
}
