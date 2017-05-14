package com.billkang.designmode.observer;

/**
 * @author binkang
 * @date May 14, 2017
 */
public interface Subject {
	//添加观察者
	void add(Observer observer);
	
	//删除观察者
	void delete(Observer observer);
	
	//通知所有观察者
	void notifyObservers();
	
	//自身的操作
	void operation();
}
