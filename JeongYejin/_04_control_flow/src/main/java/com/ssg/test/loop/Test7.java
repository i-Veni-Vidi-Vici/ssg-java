package com.ssg.test.loop;

public class Test7 {
    public static void main(String[] args) {
        Test7 test7 = new Test7();
        test7.test();
    }

    private void test() {
        String left = "";
        String right = "";
        int j = 9;
        for (int i = 1; i <= 9; i++) {
            left += i + "";
            right += j + "";
            System.out.printf("%9s x 8 + %d = %s\n",left, i, right);
            j--;
        }
    }
}