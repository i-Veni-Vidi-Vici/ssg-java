package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test1 {
    Scanner scanner = new Scanner(System.in);

    public void test1() {

        System.out.println();
        System.out.println("정수1을 입력해주세요");
        int inum1 = scanner.nextInt();

        System.out.println("정수2를 입력해주세요");
        int inum2 = scanner.nextInt();


        if( inum1< 0 || inum2 < 0){
            System.out.println("잘못 입력 하셨습니다");
            return;
        }

        int result;

        System.out.println("연산자를 입력해주세요(+ - * / %)");


        String operator = scanner.next();

        System.out.println("-------------------");

        switch (operator) {
            case "+":

                result = (inum1 + inum2);
                System.out.println(result);
                break;


            case "-":
                result = (inum1 - inum2);
                System.out.println(result);
                break;

            case "*":
                result = (inum1 * inum2);
                System.out.println(result);
                break;
            case "/":
                result = (inum1 / inum2);
                System.out.println(result);
                break;

            case "%":
                result = (inum1 % inum2);
                System.out.println(result);
                break;

            default:
                System.out.println("잘못된 연산자 입니다.");


                }


        }

       }

