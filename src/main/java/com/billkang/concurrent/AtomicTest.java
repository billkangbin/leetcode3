package com.billkang.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    private Integer val = 0;

    public Integer getValue() {
        return val;
    }

    public void increment() {
        ++val;
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicTest automicTest = new AtomicTest();

        new Thread(() -> {
            automicTest.increment();
        }, "threat-1").start();

        new Thread(() -> {
            automicTest.increment();
        }, "threat-2").start();

        Thread.sleep(1000);
        System.out.println("val=" + automicTest.getValue());
    }

}
