package com.sh.test.lotto;
import java.util.Arrays;
import java.util.Random;

/**
 * 문제6
 * 로또 번호 자동 생성기 프로그램을 작성하세요.
 * 단, 중복 값이 있으면 안되고, 오름차순으로 정렬하여 출력하세요.
 *  Random클래스 사용 혹은 Math.random() 사용합니다.
 */

public class LottoApp {
    public static void main(String[] args){
        test6();
    }

    public static void test6(){
        // 번호 6개, 1~45중 랜덤숫자, 랜덤 중복x
        Random rnd = new Random();
        int[] lotto = new int[6];

        for(int i=0;i<lotto.length;i++){
            lotto[i] = rnd.nextInt(45) + 1;
            for(int j=0;j<i;j++){
                if(lotto[i] == lotto[j]){
                    lotto[i] = rnd.nextInt(45) + 1;
                }
            }
        }
        Arrays.sort(lotto);
        for(int i=0;i<lotto.length;i++){
            System.out.print(lotto[i]+" ");
        }
    }
}

