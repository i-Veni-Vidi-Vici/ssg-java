package com.sh.condition.loop._while;


import java.util.Scanner;

/**
 * <pre>
 *
 *   while표현식
 *
 *   초기식;
 *   while(조건식){
 *       //반복 실행 구문
 *
 *       증감식;
 *   }
 * </pre>
 */
public class While
{

    public void test()
    {
        //1-10
//        int i = 1;
//        while(i<=10)
//        {
//            System.out.println(i);
//            i++;
//        }
//        int i =10;
//        while(i>=1)
//        {
//            System.out.println(i);
//            i--;
//        }
        //2 4 ... 20
        int i = 2;
        while(i<=20)
        {
            System.out.println(i);
            i += 2;
        }

    }

    /**
     * 누적 합 구하기
     */

    public void test2()
    {

        int sum = 0;
        int i = 1;
//        while(i <= 10)
//        {
//            sum += i;
//            i++;
//        }

        //증감식이랑 연산식을 같이 씀.
        while(i<=10)
        {
            sum += i++;
        }
    }

    /**
     * 문자열에 인덱스 별로 접근하기
     * - apple
     */
    public void test3()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("아무말이나 하세요. ");
        String str = scanner.nextLine();
        System.out.println(str.length());
        int i  =0;
        while(i<str.length())
        {
            char ch = str.charAt(i);
            System.out.println(ch);
            i++;
        }
    }

    /**
     * 구구단 2-9
     */
    public void test4()
    {
        int i = 2;
        int j ;
        while(i <= 9)
        {
            System.out.println("\t"+i + "단");
            j = 1;
            while(j<=9)
            {
                System.out.println(i + " * " +  j + " = " + i*j );
                j++;
            }
            i++;
        }
    }

}
