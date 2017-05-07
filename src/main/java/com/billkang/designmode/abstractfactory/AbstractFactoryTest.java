package com.billkang.designmode.abstractfactory;

/**
 * @author binkang
 * @date May 7, 2017
 */
public class AbstractFactoryTest {
	public static void main(String[] args) {  
        Factory provider = new MailFactory();  
        Sender sender = provider.produce();  
        sender.send();  
    }  
}
