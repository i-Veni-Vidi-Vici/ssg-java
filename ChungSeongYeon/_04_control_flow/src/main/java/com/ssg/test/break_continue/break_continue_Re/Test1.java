package com.ssg.test.break_continue.break_continue_Re;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 하나 입력하세요.=> ");
		int num = sc.nextInt();

		long product = 1;

		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0)
				continue;
			product *= i;
		}
		System.out.printf("1부터 %d까지 홀수의 곱 %d", num, product);
	}

}
