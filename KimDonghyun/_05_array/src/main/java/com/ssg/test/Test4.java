package com.ssg.test;

import java.util.Scanner;

public class Test4 {

    public static void main(String[] args) {
        Test4 t = new Test4();
        t.test();
    }

    /**
     * <pre>
     * 사용자의 전화번호를 입력받고, 11자리의 문자형배열에 저장한후,
     * 가운데 4자리를 *로 가리기.
     *
     * </pre>
     */
    private void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("전화번호를 (-)없이 입력하세요 (예시.01012345678) ==> ");
        String phNum = sc.next();

        char[] cArr = new char[phNum.length()];
        for (int i = 0; i < cArr.length; i++) {
            if (i > 2 && i < 7) {
                cArr[i] = '*';
            }
			else
                cArr[i] = phNum.charAt(i);
        }

        for (int i = 0; i < cArr.length; i++) {
            System.out.print(cArr[i]);
        }
    }

}
