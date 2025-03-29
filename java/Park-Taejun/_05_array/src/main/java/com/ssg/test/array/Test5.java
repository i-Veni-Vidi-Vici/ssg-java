package com.ssg.test.array;

import java.util.Scanner;

import java.util.Arrays;

public class Test5 {
    public static void main(String[] args){
        // 궁금한것? 이건 왜 main 안에 하면 안되고 따로 test 를 만들어야 하는지?
        Scanner sc = new Scanner(System.in);
        System.out.println(" 홀수인 양의 정수를 입력하세요");
        int holSu = sc.nextInt();
        if (holSu % 2 == 0) {
            System.out.println("no holsu");
            return;
        } else {
            int[] arr = new int[holSu];
            for(int i = 0; i < holSu; i++) {
                arr[i] = holSu+1;
                if(i >= holSu/2 ){
                    arr[i] --;
                }
                else {arr[i] ++;}

                }
            }

        }


            } //모르겠습니다.ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ
