package com.ssg.test.loop.loop_Re;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		Test4 t = new Test4();
		t.test();
	}

	private void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 입력 : ");
		String str = sc.nextLine();

		System.out.print("검색할 문자 입력 : ");
		char srchChar = sc.next().charAt(0);


		if ((srchChar >= 'A' && srchChar <= 'Z') || (srchChar >= 'a' && srchChar <= 'z')) {
			int cnt = 0;

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c == srchChar)
					cnt++;
			}

			System.out.println("'" + srchChar + "'가 포함된 갯수 : " + cnt + "개");
		} else {
			System.out.println("영문자가 아닙니다.");
		}

	}

}
