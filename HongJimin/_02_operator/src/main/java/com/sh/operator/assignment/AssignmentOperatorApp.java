package com.sh.operator.assignment;

public class AssignmentOperatorApp {
    public static void main(String[] args) {
        int num = 10;

        //복합 대입 연산자
        num += 3; // num = num + 3;
        System.out.println(num);

        num -= 3;
        System.out.println(num);

        num *=3;
        System.out.println(num);

        num /= 5;
        System.out.println(num);

        num %= 5;
        System.out.println(num);
    }
}
