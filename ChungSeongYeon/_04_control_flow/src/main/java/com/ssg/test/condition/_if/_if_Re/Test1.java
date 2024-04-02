package com.ssg.test.condition._if._if_Re;

import java.util.Scanner;

public class Test1 {

	public void test() {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 1 : ");
		int num1 = sc.nextInt();
		System.out.print("정수 입력 2 : ");
		int num2 = sc.nextInt();


		if (num1 < 0 || num2 < 0) {
			System.out.println("음수를 입력하셨습니다. 프로그램을 종료합니다.");
			return;
		}

		System.out.print("연산기호를 입력하세요(+,-,*,/,%) : ");
		char op = sc.next().charAt(0);
		

		// 조기 return
		if (op != '+' && op != '-' && op != '*' && op != '/' && op != '%') {
			System.out.println("잘못된 연산기호를 입력하셨습니다. 프로그램을 종료합니다.");
			return;
		}

		int result = 0;
		if (op == '+') {
			result = num1 + num2;
		} else if (op == '-') {
			result = num1 - num2;
		} else if (op == '*') {
			result = num1 * num2;
		} else if (op == '/') {
			result = num1 / num2;
		} else if (op == '%') {
			result = num1 % num2;
		}

		System.out.println("입력값 -> a = " + num1 + ", b = " + num2 + ", op = " + op);
		System.out.println(" " + num1 + op + num2 + " = " + result);
	}

}