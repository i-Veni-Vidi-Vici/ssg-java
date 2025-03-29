package com.sh.api._02.string;

import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * <pre>
 * CSV 데이터
 * - Comma Seperated Value 구분자로 구분된 값
 * - 구분자(delimit) : 콤마, 슬래시, 달러기호..등 데이터에는 절대 존재하지 않는 값
 * - 홍길동, 33, 서울시 강남구
 *
 * 1. String#split(delimit:String):String[]
 * 2. new StringTokenizer(data:String, delimit:String)
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
        System.out.println(Arrays.toString(arr1)); // [100, 홍길동, 서울, 영업부]
        String[] arr2 = data2.split("/");
        System.out.println(Arrays.toString(arr2)); // [200, 신사임당, , 총무부]
//        String[] arr3 = data3.split("/"); // 마지막 빈문자열 처리 안됨 [300, 이순신, 경기도]
        String[] arr3 = data3.split("/", -1); // 두번째 값(몇개로 쪼갤지)에 -1 : 요소개수 제한없음
        System.out.println(Arrays.toString(arr3)); // [300, 이순신, 경기도, ]
        System.out.println();

        // 2. StringTokenizer
        // CSV데이터를 토큰으로 잘라내어 관리하는 객체
        StringTokenizer tokenizer = new StringTokenizer(data1, "/");
//        System.out.println(tokenizer); // java.util.StringTokenizer@36baf30c
        // 반복처리를 통해 토큰 열람(소비하는 형식)
        System.out.println(tokenizer.countTokens());
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            System.out.println("token = " + token + ", 남은 토큰수 = " + tokenizer.countTokens());
        }
        System.out.println();

        // StringTokenizer 특징 : 비어있는 문자열 요소는 제거
        StringTokenizer tokenizer1 = new StringTokenizer(data2, "/");
        System.out.println(tokenizer1.countTokens());
        while (tokenizer1.hasMoreTokens()) {
            String token = tokenizer1.nextToken();
            System.out.println("token = " + token + ", 남은 토큰수 = " + tokenizer1.countTokens());
        }
        System.out.println();

        StringTokenizer tokenizer2 = new StringTokenizer(data3, "/");
        System.out.println(tokenizer2.countTokens());
        while (tokenizer2.hasMoreTokens()) {
            String token = tokenizer2.nextToken();
            System.out.println("token = " + token + ", 남은 토큰수 = " + tokenizer2.countTokens());
        }

        // 구분자가 섞여있는 경우
        String dirtyData = "red/orange,blue yellow green";
        StringTokenizer tokenizer3 = new StringTokenizer(dirtyData, "/, "); // 내부적으로 문자 단위로 구분자 사용
        while (tokenizer3.hasMoreTokens()) {
            System.out.println(tokenizer3.nextToken());
        }

        // split 매개변수는 정규표현식(문자열 검색을 지원하는 표현식)을 인자로 함
        // [/, ] : 문자 하나에 대한 옵션 (/이거나 ,이거나 공백문자)
//        String[] arr4 = dirtyData.split("/, "); // 쌍따옴표에 있는걸 하나로 봄
//        System.out.println(Arrays.toString(arr4)); // [red/orange,blue yellow green]
//        System.out.println(arr4.length); // 1
        String[] arr4 = dirtyData.split("[/, ]");
        System.out.println(Arrays.toString(arr4)); // [red, orange, blue, yellow, green]
        System.out.println(arr4.length); // 5
    }
}
