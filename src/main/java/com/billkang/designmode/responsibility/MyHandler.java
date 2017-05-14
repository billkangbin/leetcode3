package com.billkang.designmode.responsibility;

/**
 * @author binkang
 * @date May 14, 2017
 */
public class MyHandler extends AbstractHandler {
	private String name;
	
	public MyHandler(String name) {
		this.name = name;
	}
	
	public void operator() {
		System.out.println(name + " deal!");
		 if(getHandler()!=null){  
            getHandler().operator();  
         } 
	}
}
