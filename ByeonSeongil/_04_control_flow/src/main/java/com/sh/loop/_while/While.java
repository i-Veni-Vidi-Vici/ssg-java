package com.sh.loop._while;

/**
 * <pre>
 *
 * </pre>
 */
public class While {

    public void test1() {
        // 1~10 출력
//        int i = 1;
//        while (i <= 10) {
//            System.out.println(i);
//            i++;
//        }

        // 10~1 출력
//        int i =0;
//        while (i <= 10) {
//            System.out.println(10-i);
//            i++;
//        }

        // 2 4 6 ~ 20 출력
        int i = 2;
        while (i <= 20) {
            System.out.println(i);
            i += 2;
        }
    }

    /**
     * 1 ~ 10 누적합 구하기
     */
    public void test2() {
        int sum = 0;
        int i = 1;

//        while (i <= 10) {
//            sum += i;
//            i++;
//        }

        while (i <= 10) {
            sum += i++;
        }

        System.out.println(sum);
    }

    /**
     * 문자열에 인덱스별로 접근하기
     * - "apple"
     */

    public void test3() {
        // 마지막 인덱스는 글자수 -1 과 동일
        String str = "apple";
        int i = 0;

        while (i < 5) {
            char ch = str.charAt(i);
            System.out.println(i + " : " + ch);
            i++;

        }
    }

    /**
     * 구구단 2 ~ 9 단 while문으로 출력하기
     */

    public void test4() {
        int dan = 2;

        while (dan <= 9) {
            int mul=1;
            while (mul <= 9) {
                System.out.printf("%d x %d = %d\n", dan,mul, dan*mul++);
            }
            dan++;
        }

    }
}
