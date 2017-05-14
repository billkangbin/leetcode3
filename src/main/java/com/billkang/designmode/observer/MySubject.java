package com.billkang.designmode.observer;

/**
 * @author binkang
 * @date May 14, 2017
 */
public class MySubject extends AbstractSubject {
	public void operation() {
		System.out.println("subject update self");
		notifyObservers();
	}
	
	public static void main(String[] args) {
		Subject sub = new MySubject();
		sub.add(new Observer1());
		sub.add(new Observer2());
		
		sub.operation();
	}
}
