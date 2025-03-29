package com.sh.condition._if;

import java.util.Scanner;
/**
 * if(조건식1){
 *     //조건식 1이 참인 경우 해당 블럭 실행 후 탈출
 * }else if(조건식2){
 *
 * }else if(조건식3){
 *
 * }else{
 *
 * }
 */



/**
 * 학점부여
 * -90~100 = A
 * -80~90 = B
 * -70~80 = C
 * -60~70 = D
 * 0~59 = F
 */
public class IfElseIf {
    public void test(){
        Scanner sc = new Scanner(System.in);
        System.out.println("> 정수 입력(0~100) : ");
        int score = sc.nextInt();
        char grade;
        if(89<score)
            grade = 'A';
        else if (79<score)
            grade = 'B';
        else if (69<score)
            grade = 'C';
        else if (59<score)
            grade = 'D';
        else
            grade = 'F';


        System.out.println(score + "점은 학점"+ grade + "입니다.");
    }



}
