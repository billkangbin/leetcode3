package com.billkang.designmode.abstractfactory;

/**
 * @author binkang
 * @date May 7, 2017
 */
public class MailFactory implements Factory {
	public Sender produce() {
		return new MailSender();	
	}
}
