package com.billkang.designmode.abstractfactory;

/**
 * @author binkang
 * @date May 7, 2017
 */
public class MailSender implements Sender {

	public void send() {
		System.out.println("mail send");
	}

}
