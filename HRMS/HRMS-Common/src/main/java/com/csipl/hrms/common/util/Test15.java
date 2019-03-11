package com.csipl.hrms.common.util;

public class Test15 {
	 int a=4;
	protected int getA() {
		 return a;
	 }
	public static void main(String[] args) {
		VO a = new VO(2);
		VO b = new VO(3);
		swapONE(a, b);
		print(a, b);
		swapTWO(a, b);
		print(a, b);
	}

	private static void print(VO a, VO b) {
		System.out.print(a.toString() + b.toString());
	}

	public static void swapONE(VO a, VO b) {
		VO tmp = a;
		a = b;
		b = tmp;
	}

	public static void swapTWO(VO a, VO b) {
		int tmp = a.x;
		a.x = b.x;
		b.x = tmp;
	}
}

class VO {
	public int x;

	public VO(int x) {
		this.x = x;
	}

	public String toString() {
		return String.valueOf(x);
	}
}