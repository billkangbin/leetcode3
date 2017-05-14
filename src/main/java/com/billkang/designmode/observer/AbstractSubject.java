package com.billkang.designmode.observer;

import java.util.Vector;

/**
 * @author binkang
 * @date May 14, 2017
 */
public abstract class AbstractSubject implements Subject{
	private Vector<Observer> vec = new Vector<Observer>();
	
	public void add(Observer observer) {
		vec.add(observer);
	}

	public void delete(Observer observer) {
		vec.remove(observer);
	}

	public void notifyObservers() {
		for(Observer observer: vec) {
			observer.update();
		}
	}
}
