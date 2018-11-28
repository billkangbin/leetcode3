package com.billkang.algorithm;

/**
 * 两个线程 交替打印奇偶数
 *
 * @author Kangbin
 * @date 2018-11-28
 */
public class OddEven {

    public static class Num {
        int i = 1;

        /**
         * 线程交替标识，false时打印奇
         */
        boolean flag = false;
    }

    public static class PrintOdd implements Runnable {
        Num num;

        public PrintOdd(Num num) {
            this.num = num;
        }

        @Override
        public void run() {
            while (num.i < 100) {
                synchronized (num) {
                    if (num.flag) {
                        try {
                            num.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("打印奇数：" + num.i);
                        num.i++;
                        num.flag = true;
                        num.notify();
                    }
                }
            }
        }
    }

    public static class PrintEven implements Runnable {
        Num num;

        public PrintEven(Num num) {
            this.num = num;
        }

        @Override
        public void run() {
            while (num.i < 100) {
                synchronized (num) {
                    if (!num.flag) {
                        try {
                            num.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("打印偶数：" + num.i);
                        num.i++;
                        num.flag = false;
                        num.notify();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Num num = new Num();

        new Thread(new PrintOdd(num)).start();
        new Thread(new PrintEven(num)).start();
    }
}
