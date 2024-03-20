package com.ssg.test.lotto;

import java.util.Arrays;
import java.util.Random;

public class LottoApp {
    public static void main(String[] args) {
        int[] lotto = new int[6];
        Random rand = new Random();
        boolean bool = true;
        int randomNumber;


        for (int i = 0; i < 6; i++) { // 로또 번호 6개
            while(true){
                randomNumber = rand.nextInt(45) + 1; // 1부터 45까지의 랜덤한 숫자 생성
                for (int j = 0; j < i; j++) {
                    if (lotto[j] == randomNumber) { // 중복 숫자 검열
                        bool = false; // 중복이 있다면 bool을 false 바꾸고 for문 break;
                        break;
                    }
                }
                // 중복되지 않는 숫자면 배열에 추가
                if (bool == true) { // bool이 true라면 배열에 숫자를 넣고 break 아니라면 while문 다시 반복
                    lotto[i] = randomNumber;
                    break;
                }
            }
        }

        // 번호 정렬
        Arrays.sort(lotto);
        System.out.println("로또 번호: " + Arrays.toString(lotto));
    }
}