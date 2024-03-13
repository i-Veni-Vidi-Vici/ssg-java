package com.sh.condition_if;

import java.util.Scanner;

/**
 * if~else if 표현식
 * - 조건식 1이 참인 경우, 해당 블럭 실행 후 탈출
 * - 조건식1이 거짓인 경우, 조건식2 검사
 * - 조건식 2가 참인 경우, 해당 블럭 실행 후 탈출
 * if(조건식1){
 *     // 조건식1이 true인 경우 실행코드
 * else is(조건식2){
 *     // 조건식2 이 true인 경으 실행코드
 * else{
 *     // 위의 조건식3이 true인 경우 실행코드
 * }
 * }
 * }
 */
public class IfElseIf {
    public void test(){
        Scanner sc = new Scanner(System.in);
        // 금도끼/은도끼/쇠도끼 예제
        System.out.println("풍덩~ 펑!");
        System.out.println("산신령 : 어느것이 네 도끼냐? 1. 금도끼 2. 은도끼 3. 쇠도끼");
        int choice = sc.nextInt();

        if(choice == 1){
            System.out.println("산신령 : 이런 욕심쟁이 어림없다.");
        }
        else if (choice == 2) {
            System.out.println("산신령 : 이런 거짓말쟁이 어림없다.");
        }
        else{
            System.out.println("산신령 : 진실된 자는 도끼를 모두 가질 수 있다.");
        }
    }

    /**
     * 학점 부여
     * - 90 ~ 100 -> A
     * - 80 ~ 89 -> B
     * - 70 ~ 79 -> C
     */
    public void test2(){
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        if(score<=59)
        {
            System.out.println("F");
        }
        else if(score<=69)
        {
            System.out.println("D");
        }
        else if (score<=79)
        {
            System.out.println("C");
        }
        else if (score<=89)
        {
            System.out.println("B");
        }else if (score<=100)
        {
            System.out.println("A");
        }
    }
    public void test3(){
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        if(score<=59)
        {
            System.out.println("F");
        }
        else if(score<=69)
        {
            System.out.println("D");
        }
        else if (score<=79)
        {
            System.out.println("C");
        }
        else if (score<=89)
        {
            System.out.println("B");
        }else if (score<=100)
        {
            System.out.println("A");
        }
    }
}
