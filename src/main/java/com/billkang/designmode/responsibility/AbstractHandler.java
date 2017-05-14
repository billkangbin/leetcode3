package com.billkang.designmode.responsibility;

/**
 * @author binkang
 * @date May 14, 2017
 */
public abstract class AbstractHandler implements Handler {
	private Handler handler;

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
}
