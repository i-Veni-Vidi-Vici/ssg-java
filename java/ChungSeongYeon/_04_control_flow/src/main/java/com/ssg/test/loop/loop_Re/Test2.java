package com.ssg.test.loop.loop_Re;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Test2 t = new Test2();
		t.test();
	}

	private void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();

		char odd = '수';
		char even = '박';
		String result = "";

		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0) {
				result += even;
			} else {
				result += odd;
			}
		}

		System.out.println(result);
	}

}
