package com.ssg.thread.alphabet;


public class AlphabetTest {
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			for (int i = 'A'; i <='Z'; i++) {
				System.out.println("Upper : "+ (char)i);
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 'a'; i <='z'; i++) {
				System.out.println("  Lower : "+ (char)i);
			}
		});
		t1.start();
		t2.start();
	}
}

