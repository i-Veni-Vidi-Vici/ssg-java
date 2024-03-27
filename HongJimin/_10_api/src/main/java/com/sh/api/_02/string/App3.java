package com.sh.api._02.string;

import java.util.Arrays;
import java.util.StringTokenizer;

public class App3 {
    public static void main(String[] args) {
        //사번 / 이름/ 지역 / 부서
        String data1 = "100/홍길동/서울/영업부";
        String data2 = "200/신사임당//총무부";
        String data3 = "300/이순신/경기도/";

        //1. split
        String[] arr1 = data1.split("/");
        System.out.println(Arrays.toString(arr1)); // [100, 홍길동, 서울, 영업부] 이렇게 보이지만 실제로는 -> ["100", "홍길동", "서울", "영업부"] 전부 문자열임!!

        String[] arr2 = data2.split("/");
        System.out.println(Arrays.toString(arr2)); // ["200", "신사임당", , "총무부"]

//        String[] arr3 = data3.split("/"); //마지막 요소처리가 안됨
//        System.out.println(Arrays.toString(arr3)); // ["300", "이순신", "경기도"]

        String[] arr3 = data3.split("/", -1); //요소 개수 제한 없음
        System.out.println(Arrays.toString(arr3)); //["300", "이순신", "경기도", ]

        System.out.println(Arrays.toString(data3.split("/", 2))); // [300, 이순신/경기도/] -> 요소를 2개로 보여줘?랑 같은 의미
        System.out.println();

        //2. StringTokenizer(data : String, delimit : String)
        //   CSV데이터를 토큰으로 잘라내어 관리하는 객체
        StringTokenizer tokenizer = new StringTokenizer(data1, "/");
//        System.out.println(tokenizer); //java.util.StringTokenizer@36baf30c

        //반복 처리를 통해 토큰을 열람(소비)할 수 있음
        System.out.println("현재 토큰 수 : " + tokenizer.countTokens());
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            System.out.println("token = " + token + ", 남은 토큰 수 = " + tokenizer.countTokens());
        }
        System.out.println();

        //StringTokenizer특징 : 비어 있는 문자열 요소는 제거함
        StringTokenizer tokenizer2 = new StringTokenizer(data2, "/");
        System.out.println("현재 토큰 수 : " + tokenizer2.countTokens());
        while (tokenizer2.hasMoreTokens()) {
            String token = tokenizer2.nextToken();
            System.out.println("token = " + token + ", 남은 토큰 수 = " + tokenizer2.countTokens());
        }
        System.out.println();

        StringTokenizer tokenizer3 = new StringTokenizer(data3, "/");
        System.out.println("현재 토큰 수 : " + tokenizer3.countTokens());
        while (tokenizer3.hasMoreTokens()) {
            String token = tokenizer3.nextToken();
            System.out.println("token = " + token + ", 남은 토큰 수 = " + tokenizer3.countTokens());
        }
        System.out.println();

        // 구분자 섞여있는 경우
        String dirtyData = "red/orange,blue yellow green";
        StringTokenizer tokenizer4 = new StringTokenizer(dirtyData, "/, ");//내부적으로 문자 단위 구분자를 사용
        while (tokenizer4.hasMoreTokens()) {
            System.out.println(tokenizer4.nextToken());
        }

        //split 매개변수는 정규 표현식(문자열 검색을 지원하는 표현식)을 인자로 한다.
        // [/,] 문자 하나에 대한 옶견( / 이거나 , 이거나 공백 문자)
        String[] arr4 = dirtyData.split("[/,]"); // /이거나 , 이거나로 작동함
        System.out.println(Arrays.toString(arr4)); //[red/orange,blue yellow green]
        System.out.println(arr4.length); //1
    }
}
