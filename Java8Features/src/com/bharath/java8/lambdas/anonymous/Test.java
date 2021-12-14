package com.bharath.java8.lambdas.anonymous;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		Thread t = new Thread(()->{
			for(int i=1;i<=10;i++){
				System.out.println("Child Thread");
			}
		});

		t.start();
		t.join(1);

		for (int i = 1; i <= 10; i++) {
			System.out.println("Main Thread");
		}

	}

}
