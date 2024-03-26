package com.sh.api._02.string;

import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * <pre>
 * CSV데이터
 * - Comma Seperated Value 구분자로 구분된 값
 * (데이터에는 절대 존재하지 않는 값을 구분자로 사용해야 한다)
 * - 홍길동, 33, 서울시 강남구, 농구, 축구, 배구
 *
 * 1. String#split
 * 2. new StringTokenizer
 *  - 비어있는 문자열 요소는 제거
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        // 사번/이름/지역/부서
        String data1 = "100/홍길동/서울/영업부";
        String data2 = "200/신사임당//총무부";
        String data3 = "300/이순신/경기도/";

        // 1. split
        String[] arr1 = data1.split("/");
        System.out.println(Arrays.toString(arr1)); // ["100", "홍길동", "서울", "영업부"]

        String[] arr2 = data2.split("/");
        System.out.println(Arrays.toString(arr2)); // [200, 신사임당, , 총무부]

//        String[] arr3 = data3.split("/");
        String[] arr3 = data3.split("/", -1); // 요소 개수 제한 없음
        System.out.println(Arrays.toString(arr3)); // [300, 이순신, 경기도]

        System.out.println(Arrays.toString(data3.split("/", 2)));


        // 2. StringTokenizer
        // - CSV데이터를 토큰으로 잘라내어 관리하는 객체
        StringTokenizer tokenizer = new StringTokenizer(data1, "/");
        System.out.println(tokenizer);
//        System.out.println(tokenizer);
        // 반복처리를 통해 토큰을 열람(소비)
        System.out.println("현재 토큰 수 : " + tokenizer.countTokens());
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            System.out.println("token = "+ token+ ", 남은 토큰수 = "+ tokenizer.countTokens());
        }
        System.out.println();


        // 비어있는 문자열 요소는 제거함
        StringTokenizer tokenizer2 = new StringTokenizer(data2,"/");
        System.out.println("현재 토큰 수 : " + tokenizer2.countTokens());
        while (tokenizer2.hasMoreTokens()) {
            String token = tokenizer2.nextToken();
            System.out.println("token = " + token+ ", 남은 토큰수 = "+ tokenizer2.countTokens());
        }
        System.out.println();

        StringTokenizer tokenizer3 = new StringTokenizer(data3, "/");
        System.out.println("현재 토큰 수 : " + tokenizer3.countTokens());
        while (tokenizer3.hasMoreTokens()) {
            String token = tokenizer3.nextToken();
            System.out.println("token = " + token+ ", 남은 토큰수 = "+ tokenizer3.countTokens());
        }

        // 구분자 섞여있는 경우
        String dirtyData = "red/orange,blue yellow green";
        StringTokenizer tokenizer4 = new StringTokenizer(dirtyData, "/, "); // 내부적으로 문자단위 구분자사용
        while (tokenizer4.hasMoreTokens()) {
            System.out.println(tokenizer4.nextToken());
        }

        // split매개변수느 정규표현식(문자열 검색을 지원하는 표현식)을 인자로 한다.
        // [/, ] 문자하나에 대한 옶견 (/이거나 ,이거나 공백문자)
        String[] arr4 = dirtyData.split("[/, ]");
        System.out.println(Arrays.toString(arr4));
        System.out.println(arr4.length);
    }
}
