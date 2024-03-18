package com.ssg.test.lotto;

import static com.sh.array.sort.Swap.swap;

public class LottoApp {
    public static void main(String[] args) {
        // 로또 번호 저장 배열 선언 및 생성
        int[] lottoNum = new int[6];

        // 로또 번호 뽑기
        // 1 ~ 45까지 랜덤 정수, 중복 불가
        int index = 0;
        int randNum;

        rand:
        while(true) {
            randNum = (int) (Math.random() * 45) + 1;

            // 중복 체크
            for(int i = 0; i <= index; i++) {
                if(lottoNum[i] == randNum)
                    continue rand;
            }

            // 지금까지 뽑힌 로또 수와 발생한 난수가 중복 값이 없으면
            lottoNum[index] = randNum;
            index++;

            // 로또 번호 다 뽑음
            if(index == lottoNum.length)
                break;
        }

        // 오름차순 정렬
        for(int i = 0; i < lottoNum.length - 1; i++) {
            for(int j = i + 1; j < lottoNum.length; j++) {
                if(lottoNum[i] > lottoNum[j]) {
                    swap(lottoNum, i ,j);
                }
            }
        }

        // 로또 배열 출력
        print(lottoNum);
    }

    // 배열 출력 메소드
    public static void print (int[] arr){
        for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
