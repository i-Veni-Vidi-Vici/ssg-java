package com.ssg.test.operator.logical;

public class App {
    public static void main(String[] args) {

        // 정수 n이 1부터 100사이의 수인지 검사
        int n = 55;
        System.out.println(n >= 1 && n <= 100);

        // 문자 ch1이 영어 대문자인지 검사
        char ch1 = 'G'; // ch1이 아스키코드 G가 71이다. 대문자는 65부터 90이다. 따라서 ch1은 65보다 크면서 90보다는 작다.
        System.out.println(ch1 >= 65 && ch1 <= 90);

        // 문자 ch2가 영어 소문자인지 검사
        char ch2 = 'g'; // ch2이 아스키코드 g가 103이다. 소문자는 97부터 122이다. 따라서 ch2은 97보다 크면서 122보다는 작다.
        System.out.println(ch2 >= 'a' && ch2 <= 'z');

        // 문자 yn이 대소문자 관계없이 y인지 검사
        char yn = 'Y'; // y는 대문자여도 되고, 소문자여도 상관없다. 따라서 소문자 yn은 아스키코드로 97보다 크면서 122보다는 작다. 대문자 yn은 아스키코드로 65~90이다.
                      // 문제에서 대소문자 관계없이 y인지 검사하는 것으로 or을 사용하여 검사한다.
//        System.out.println(yn); // 소문자 yn은 아스키코드로 97 ~ 122 -> a
//        System.out.println(yn); // 대문자 yn은 아스키코드로 65 ~ 90 -> b
        System.out.println(( yn >= 97 && yn <= 122) ||
                            (yn >= 65 && yn <= 90 )); // a(yn >= 97 && yn <= 122) || b(yn >= 65 && yn <= 90)

        // 문자 k가 영문자인지 검사
        char k = 'z'; // 대문자 k는 아스키코드로 90이다. 소문자 k는 아스키코드로 122이다.
        System.out.println(k == 90 || k == 122);
//        System.out.println((k >= 65 && k <= 90) ||
//                (k >= 97 && k <= 122));




    }
}
