package org.saswata.interthread.communication;

public class InterThredCommunication {

	public static void main(String args[]) {
		final CustomerDepo c = new CustomerDepo();
		new Thread() {
			public void run() {
				c.withdraw(15000);
			}
		}.start();
		new Thread() {
			public void run() {
				c.deposit(10000);
			}
		}.start();

	}

}
