package com.billkang.concurrent;

/**
 * @author kangbin <kangbin@kuaishou.com>
 * Created on 2020-06-21
 */
public class DataRaceTest {
    private static int a = 0;

    public static void main(String[] args) {
        new Thread(()->{
            a = 1; //线程1修改a的值
        },"threat-1").start();

        new Thread(()->{
            if(a==0) {
                System.out.println("a="+a); //线程2读取a的值输出
            }
        },"threat-2").start();
    }
}
