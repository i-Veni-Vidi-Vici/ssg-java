package com.sh.condition.loop._while;


import java.util.Scanner;

/**
 * <pre>
 * while표현식
 *
 * 초기식;
 * while(조건식){
 *     //반복실행구문
 *
 *     증감식;
 *
 * }
 *
 * </pre>
 *
 *
 */



public class While {
    public void test1() {
        // 1~10
//        int i = 1;
//        while (i <= 10){
//            System.out.println(i);
//            i++;
//        }

        //10~1

//        int i = 10;
//        while (i > 0) {
//            System.out.println(i);
//            i--;
//        }

        // 2 4 6 8 10 12 14 16 18 20

        int i = 2;
        while (i <= 20) {
            System.out.println(i);
            i += 2;
        }
    }

    /**
     *
     * 누적합 구하기
     *
     */
    public void test2(){
        int sum = 0;
        int i = 1;
        while (i <= 10){
            sum += i;
            i++;
        }
//        while (i<=10){
//            sum += i++; // sum = sum + i++ 증감식과 실행코드 섞어쓰기 가능 while문의 장점~
//        }
        System.out.println(sum);
    }

    // 문자열에 인덱스별로 접근하기

    public void test3() {

        Scanner sc = new Scanner(System.in) ;
        System.out.println("아무말이나 하세요~");
        // 마지막 인덱스는 글자수 -1 과 동일하다.
//        String str = "apple";
        String str = sc.nextLine();
        System.out.println("문자열길이(공백포함)" + str.length());
        int i = 0;
//        while (i < 5){
//            char ch =str.charAt(i);
//            System.out.println(i + " : " + ch);
//            i++;
//        }
        while ( (i < str.length())){
            char ch =str.charAt(i);
            System.out.println(i + " : " + ch);
            i++;
        }

    }

    /**
     *
     * 구구단 2~ 9 단 while로 하세요
     *
     */


    public void test4() {
        int i = 2;

        while (i<= 9){
            int j = 1; // 여기에 초기화 안해주면 안쪽 반복문이 실행이 안됨
            while (j<=9){
                System.out.println(i +"*"+ j + "=" + i*j);
                j++;
            }
            i++;
        }

//        int dan = 2;
//        while (dan <= 9){
//            System.out.printf("-----%단-----\n", dan);
//            int n = 1;
//            while (n <= 9){
//                System.out.printf("%d * %d = %d\n", dan, n, dan * n);
//                n++;
//            }
//            System.out.println();
//            dan++;
//        }
    }
}
