package com.sh.api._02.string;

import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * <pre>
 *     CSV 데이터
 *     - Comma Seperated Value 구분자(콤마, 슬래시, 달러사인... , / $)로 구분된 값
 *     (데이터에는 절대 존재하지 않는 값을 구분자로 사용해야 한다.)
 *     - "홍길동, 33, 서울시 강남구, 농구, 축구, 배구"
 *
 *     1. String#split(delimit:String):String[]
 *     2. new StringTokenizer(data:String, delimit:String)
 *
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
        System.out.println(Arrays.toString(arr1));  // ["100", "홍길동", "서울", "영업부"]
        String[] arr2 = data2.split("/");
        System.out.println(Arrays.toString(arr2));  // ["200", "신사임당", "", "총무부"]
//        String[] arr3 = data3.split("/");     // 마지막 요소 처리 안 됨, ["300", "이순신", "경기도"]
        String[] arr3 = data3.split("/", -1); // 요소 개수 제한 없음
        System.out.println(Arrays.toString(arr3));  // ["300", "이순신", "경기도", ""]
        System.out.println(Arrays.toString(data3.split("/", 2)));   // ["300", "이순신/경기도/"]

        // 2. StringTokenizer
        // - CSV 데이터를 토큰으로 잘라내어 관리하는 객체
        StringTokenizer tokenizer = new StringTokenizer(data1, "/"); // 데이터, 구분자
//        System.out.println(tokenizer);              // java.util.StringTokenizer@36baf30c
        // 반복처리를 통해 토큰을 열람 (소비하는 방식), nextToken()으로 토큰 리턴하면 사라지게 된다.
        System.out.println("현재 토큰 수 : " + tokenizer.countTokens());
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            System.out.println("token = " + token + ", 남은 토큰수 = " + tokenizer.countTokens());

        }
        System.out.println();

        // 구분자 섞여 있는 경우
        String dirtyData = "red/orange,blue yellow green";
        StringTokenizer tokenizer4 = new StringTokenizer(dirtyData, "/, "); // 내부적으로
        while(tokenizer4.hasMoreTokens())
            System.out.println(tokenizer4.nextToken());
        System.out.println();

        // split 매개변수는 정규표현식(문자열 검색을 지원하는 표현식)을 인자로 한다.
        // [/, ] 문자 하나에 대한 옵션 (/이거나 ,이거나 공백문자)
        String[] arr4 = dirtyData.split("[/, ]");     // 전혀 잘리지 않는다.
//        String[] arr4 = dirtyData.split("/, ");     // 전혀 잘리지 않는다.
        System.out.println(Arrays.toString(arr4));
        System.out.println(arr4.length);

    }
}


