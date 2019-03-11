package com.csipl.hrms.common.util;

public class Test2 extends Thread {
	private int value;

	public Test2(int value) {
		this.value = value;
	}

	public static void main(String[] args) {
		Test2 t1 = new Test2(1);
		Test2 t2 = new Test2(2);
		Test2 t3 = new Test2(3);
		t1.start();
		t2.start();
		t3.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("Thread" + value + " with value " + i + " Started");
			try {
				sleep(100);
			} catch (InterruptedException ex) {
				// Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
			}
			System.out.println("Thread" + value + " with value " + i + " Completed");
		}
	}
}
