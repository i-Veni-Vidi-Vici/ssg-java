package com.ssg.test.lotto;

import java.util.Arrays;

import static com.sh.array.sort.Swap.print;

public class LottoApp {
    public static void main(String[] args) {
        int[] lotto = new int[6];
        for (int i = 0; i < lotto.length; i++) {
            int num = (int) (Math.random() * 45) + 1;
            if (!duplication(num, lotto)) {
                lotto[i] = num;
            }
        }
//        ascending(lotto);
        Arrays.sort(lotto);
        print(lotto);
    }

    public static boolean duplication(int num, int[] lotto) {
        for (int i = 0; i < lotto.length; i++) {
            if (lotto[i] == num) {
                return true;
            }
        }
        return false;
    }

    public static int[] ascending(int[] lotto) {
        for (int i = 1; i < lotto.length; i++) {
            int temp = lotto[i];
            int j;
            for (j = i; j > 0; j--) {
                if (lotto[j - 1] > temp) {
                    lotto[j] = lotto[j - 1];
                } else {
                    break;
                }
            }
            lotto[j] = temp;
        }
        return lotto;
    }

    public static void print(int[] arr){
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

//package com.ssg.test.lotto;
//
//import java.util.Arrays;
//
//public class LottoApp {
//    public static void main(String[] args) {
//        int[] lotto = new int[6];
//        int index = 0;
//
//        // 6개의 중복없는 난수를 뽑기 위해 몇번을 반복할지 알수 없어 무한반복 처리한다.
//        abc:
//        while (true) {
//            int n = (int) (Math.random() * 45) + 1;
//            // 이미 뽑힌 숫자와 중복여부 검사
//            // 중복되었다면 abc반복문 처음으로 가서 다시 뽑는다.
//            for (int j = 0; j < index; j++) { // index 0일 때는 중복검사가 필요없기 때문에 생략됨
//                if (n == lotto[j]) {
//                    continue abc;
//                }
//            }
//            // 중복되지 않았다면, lotto 배열에 추가한다.
//            lotto[index++] = n;
//            // lotto[0] = n으로 대입 후 index = 1이 되므로 중복검사 for문 실행!
//            // 중복없이 6개를 모두 뽑은 경우 반복 중지한다.
//            if (index == lotto.length)
//                break;
//        }
//
//        Arrays.sort(lotto); // Arrays가 제공하는 sort메소드
//        System.out.println(Arrays.toString(lotto));
//    }
//}
