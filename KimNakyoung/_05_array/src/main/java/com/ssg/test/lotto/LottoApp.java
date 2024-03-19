package com.ssg.test.lotto;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * 로또 번호 자동 생성기 프로그램을 작성하세요.
 *
 * 단, 중복 값이 있으면 안되고, 오름차순으로 정렬하여 출력하세요.
 *
 * Random클래스 사용 혹은 Math.random() 사용합니다.
 */
public class LottoApp {
    public static void main(String[] args) {
        Random rnd = new Random();

        int[] lotto = new int[6];// 숫자 6개
        for (int i = 0; i < lotto.length; i++) {
            int random = rnd.nextInt(45) +1; // 1~45 난수 생성
            // 중복하면 다시 난수 생성
            for (int j = 0; j < i; j++) {
                if(lotto[i] == lotto[j]){
                    i--;
                }
            }
            lotto[i] = random; // 생성된 값 넣기
//            System.out.println(lotto[i] + " ");
        }
        Arrays.sort(lotto); // 오름차순 정렬

        for (int i = 0; i < lotto.length; i++) {
            System.out.println(lotto[i] + " ");
        }
    }

}
