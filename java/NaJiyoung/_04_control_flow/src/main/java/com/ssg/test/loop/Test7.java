package com.ssg.test.loop;

public class Test7 {
    public static void main(String[] args) {
        Test7 test7 = new Test7();
        test7.test();
    }

    public void test() {
        String front = "1";  // 앞부분 문자열
        String back = "9";   // 뒷부분 문자열
        int frontNum = 0;   // 앞부분 숫자
        int backNum = 0;    // 뒷부분 숫자

        for(int i=1; i<=9; i++) {
            System.out.printf("%9s x 8 + %d = %-9s\n", front, i, back);
            front += (i+1);
            back += (9-i);
        }
    }
}
