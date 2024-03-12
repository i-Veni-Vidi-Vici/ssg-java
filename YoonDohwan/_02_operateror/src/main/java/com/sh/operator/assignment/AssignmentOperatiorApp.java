package com.sh.operator.assignment;
/*
대입연산자
 */

public class AssignmentOperatiorApp {
    public static void main(String[] args){
        int num = 10;
        //복합대입 연산자
        num += 3;
        System.out.println(num);
        num -= 3;
        System.out.println(num);
        num *= 3;
        System.out.println(num);
        num /= 3;
        System.out.println(num);
        num %= 3;
        System.out.println(num);

    }

}
