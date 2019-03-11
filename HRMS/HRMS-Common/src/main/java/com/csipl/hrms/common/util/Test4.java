package com.csipl.hrms.common.util;

public class Test4 {
	static int a;
	int b;

	public Test4() {
		int c;
		c = a;
		a++;
		b += c;
		System.out.println("one");
	}

	public void Test4() {
		int c;
		c = a;
		a++;
		b += c;
		System.out.println("two");
	}

	public static void main(String args[]) {

		Test4 t = new Test4();
	}
}
