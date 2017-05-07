package com.billkang.designmode.abstractfactory;

/**
 * @author binkang
 * @date May 7, 2017
 */
public class SmsFactory implements Factory {
	public Sender produce() {
		return new SmsSender();
	}
}
