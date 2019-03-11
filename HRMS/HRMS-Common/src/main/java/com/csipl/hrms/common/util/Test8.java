package com.csipl.hrms.common.util;

public   class Test8 implements Runnable {
	
	

	public static void main( String s[]) {
		Test15 tts  = new Test15();
		System.out.println( " Main Thread"+tts.getA());
		tts.getA();
		Thread t =new Thread(new Test8());
		t.start();
		System.out.println( " Main Thread");
		for(int i=0;i<5;i++) {
			try {
				Thread.sleep(1000);
				t.stop();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println( " Main Thread");
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=0;i<5;i++) {
			System.out.println( " child Thread");
			try {
				Thread.sleep(1000);
				//Thread.interrupted();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
}
