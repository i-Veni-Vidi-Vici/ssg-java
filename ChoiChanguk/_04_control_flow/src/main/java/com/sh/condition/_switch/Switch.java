package com.sh.condition._switch;


import java.util.Scanner;

/**
 * <pre>
 * switch문
 *  - 논리값이 값으로써 분기처리하는 제어문
 *  - 값 자리에는 변수 또는 값으로 처리되는 계산식 작성
 *  - byte, short, int, char, String, enum 가능
 *  - long, float, double, boolean 불가능
 * switch(값){
 *     case 값1 : 값1 일때 실행 코드
 *     case 값2 : 값2 일때 실행 코드
 *     ~~~~~
 *     break;
 *     ~~~~
 *     default
 * }
 * </pre>
 */
public class Switch

        /**
         * <p
         *
         */
         {
    public void test()
    {
        String name;
        int price;
        Scanner sc = new Scanner(System.in);
        String menu = "---------------------\n" +
                      "        자판기\n" +
                      "-----------------------\n" +
                      "   사이다  "+"콜라  "+"환타\n"+"--------------------입력 : ";
        name= sc.next();

        switch (name){
        case "11":
            name = "사이다";
            break;
            case "2":
            System.out.println("사이다 1000원 선택됨");
            break;

            case "3":
                System.out.println("콜라 800원 선택됨");
                break;

            case "4":

                System.out.println("환타 1200원 선택됨");
                break;
            default:
                System.out.println("잘못 입력하였습니다");

        }
    }

    public void  test2()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print(" 점수 입력 해주세요 : ");
        int score= sc.nextInt();
        char grade=' ';

        /**
         * switch-case문에서 break를 생략하면, 하위 case문으로 진행된다.
         * fall-through 쭉 떨어진다
         */
        switch (score/10)
        {
            case 10:grade='A';
                break;
            case 9: grade='A';
                break;
            case 8:grade='B';
                break;
            case 7:grade='C';
                break;
            case 6:grade='D';
                break;
            default:grade='F';

        }

        System.out.println(score + "점은"+grade+"학점입니다");
    }

             /**
              * 사용자에게 정수 2개, 연산자(+-* / % )1개를 입력받아서
              * 정수2개에 대해 해당되는 연산 결과 출력하세요
              */
    public void test3()
    {
        Scanner sc=new Scanner(System.in);
        int result=0;
        System.out.print("첫번째 숫자 : ");
        int num1=sc.nextInt();

        System.out.print("두번째 숫자 : ");
        int num2=sc.nextInt();

        System.out.print("연산자 : ");
        char ch=sc.next().charAt(0);

        switch (ch)
        {
            case '+':result=num1+num2;
                //break;
            case '-':result=num1-num2;
                //break;
            case '*':result=num1*num2;
               // break;
            case '/':result=num1/num2;
                //break;
            case '%':result= num1%num2;
                //break;
            default:
                System.out.println("연산자를 잘못 입력 함");
                //return;
        }
        System.out.println(num1 +" " +ch+" " +num2 +"="+result);

    }
}
