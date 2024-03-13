package com.sh.condition._if;

import java.util.Scanner;

/**
 * if-else if 표현식
 * if(조건식1){
 *  //조건식1이 true인 경우 실행코드
 *  }
 * else if(조건식2){
 *  //조건식2가 true인 경우 실행코드
 * }
 * ......
 */
public class IfelseIf {
    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.println("풍덩~펑!");
        System.out.println("산신령 : 어느것이 네 도끼냐? 1. 금도끼 2. 은도끼 3. 쇠도끼");
        int choice = sc.nextInt();
        if(choice==1){
            System.out.println("이런 욕심쟁이 어림없다");
        } else if (choice == 2) {
            System.out.println(("거짓말쟁이 어림없다"));
        }
        else{
            System.out.println("착하구나 다 니해라");
        }

    }
    public void test2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("점수를 입력하세요 : (0~100)");
        String grade;
        int score = sc.nextInt();
        if(score>=95){
            grade="A+";
        }
        else if(score>=90){
            grade="A";
        }
        else if(score>=85){
            grade="B+";
        }
        else if(score>=80){
            grade="B";
        }
        else if(score>=75){
            grade="C+";
        }
        else if(score>=70){
            grade="C";
        }
        else if(score>=65){
            grade="D+";
        }
        else if(score>=60){
            grade="D";
        }
        else{
            grade="F";
        }
        System.out.println(score + "점은 학점"+grade+"입니다.");
    }

}
