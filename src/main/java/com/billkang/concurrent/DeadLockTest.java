package com.billkang.concurrent;

public class DeadLockTest {

    static Object resource1 = new Object();
    static Object resource2 = new Object();

    public static void main(String[] args) {
        System.out.println("start");
        //线程1
        new Thread(()->{
            try {
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + "get resource1");
                    Thread.sleep(1000);
                    synchronized (resource2) {
                        System.out.println(Thread.currentThread().getName() + "get resource2");
                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        },"threat-1").start();


        //线程2
        new Thread(()->{
            try {
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + "get resource2");
                    Thread.sleep(1000);
                    synchronized (resource1) {
                        System.out.println(Thread.currentThread().getName() + "get resource1");
                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        },"threat-2").start();

    }
}
