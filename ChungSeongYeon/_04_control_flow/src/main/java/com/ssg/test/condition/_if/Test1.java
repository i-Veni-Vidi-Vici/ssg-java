package com.ssg.test.condition._if;

import java.util.Scanner;

/**
 * <pre>
 * 정수 두개를 입력 받고, 연산자(+,-,*,/)를 입력받은 다음 계산한 뒤  
 * 결과를 출력하는 계산기 프로그램을 만들어보세요.
 * 
 * 출력 예) 
 * 입력 5, 6, +
 * 5 + 6 = 11
 * 
 * 음수가 입력되거나 +,-,*,/ 이외의 문자가 입력되면 
 * “잘못 입력 하셨습니다.  프로그램을 종료합니다.” 라는 문구가 출력되게 하세요.
 * </pre>
 */
public class Test1 {
	/**
	 * 정수2개 
	 * 연산자1개
	 */
	public void test() {
		Scanner sc = new Scanner(System.in);

		System.out.print("첫번째 정수를 입력하세요 ==>");
		int a = sc.nextInt();
		System.out.print("두번째 정수를 입력하세요 ==>");
		int b = sc.nextInt();

		// 조기 return
		if (a < 0 || b < 0) {
			System.out.println("음수를 입력하셨습니다. 프로그램을 종료합니다.");
			return; // 이하는 실행하지 않고, 메소드 호출부로 돌아간다.
		}

		System.out.print("연산기호를 입력하세요(+,-,*,/,%) ==>");
		char op = sc.next().charAt(0);
		

		// 조기 return
		if (op != '+' && op != '-' && op != '*' && op != '/' && op != '%') {
			System.out.println("잘못된 연산기호를 입력하셨습니다. 프로그램을 종료합니다.");
			return;
		}

		int result = 0;
		if (op == '+') {
			result = a + b;
		} else if (op == '-') {
			result = a - b;
		} else if (op == '*') {
			result = a * b;
		} else if (op == '/') {
			result = a / b;
		} else if (op == '%') {
			result = a % b;
		}

		System.out.println("입력값 > a=" + a + ", b=" + b + ", op=" + op);
		System.out.println("" + a + op + b + "=" + result);
	}

}