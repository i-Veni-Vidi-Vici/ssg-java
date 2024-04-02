package com.ssg.test.loop.loop_Re;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		Test1 t = new Test1();
		t.test();
	}

	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수입력 : ");
		int num = sc.nextInt();
		int sum = 0;

		for (int i = 2; i <= num; i += 2) {
//			System.out.println(i);
			sum += i; // sum = sum + i; 랑 똑같음
		}
		System.out.println(sum);

	}

}
