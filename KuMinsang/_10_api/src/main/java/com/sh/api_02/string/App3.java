package com.sh.api_02.string;

import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * <pre>
 *     CSV데이터
 *     - comma seperated value 구분자(,/$...)로 구분된 값
 *     - 홍길동,33,서울시 감남구
 *     - 구분자는 데이터에 결코 존재해선 안된다
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        String data1 = "100/홍길동/서울/영업부";
        String data2 = "200/박경리/제주//홍보부";
        String data3 = "300/김말뚝/강원/경상도/";

        //1. split
        String[] arr1 = data1.split("/");
        System.out.println(Arrays.toString(arr1));
        String[] arr2 = data2.split("/");
        System.out.println(Arrays.toString(arr2));  //빈공간을 인식
        //  String[] arr3 = data3.split("/");
        //  System.out.println(Arrays.toString(arr3));  //마지막 요소 처리안됨
        String[] arr3 = data3.split("/", -1);  //  <-요소의 갯수 제한 없음
        System.out.println(Arrays.toString(arr3));  //마지막 요소 처리


        // 2. StringTokenizer
        // - csv데이터를 토큰으로 잘라내어 관리하는 객체
        StringTokenizer tokenizer = new StringTokenizer(data1, "/");
        //System.out.println(tokenizer);    //java.util.StringTokenizer@#3%252
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            System.out.println("token = "+ token + ", 남은 토큰수 = " + tokenizer.countTokens());
        }
        System.out.println();

        StringTokenizer tokenizer2 = new StringTokenizer(data2, "/");
        //StringTokenizer 특) 비어있는 문자열 요소는 제거한다
        //토큰 4개가 아닌 3개 반환
        while (tokenizer2.hasMoreTokens()) {
            String token = tokenizer2.nextToken();
            System.out.println("token = "+ token + "남은 토큰 수 = " + tokenizer2.countTokens());
        }
        //공백없이 하고 파싱하고 싶으면 tokenizer, 빈문자열도 포함하고 싶으면 split

        StringTokenizer tokenizer3 = new StringTokenizer(data3, "/");
        System.out.println("현재 토큰수 : " + tokenizer3.countTokens());
        while (tokenizer3.hasMoreTokens()) {
            String token = tokenizer3.nextToken();
            System.out.println("token = "+ token + "남은 토큰 수 = " + tokenizer3.countTokens());
        }

        //구분자가 섞여 있는 경우
        String dirtyData = "red/orange, blue yellow green";
        StringTokenizer tokenizer4 = new StringTokenizer(dirtyData, "/, ");
        while(tokenizer4.hasMoreTokens())
            System.out.println(tokenizer4.nextToken());

        //split매개변수는 정규표현신(문자열 검색을 지원하는 표현식)을 인자로 한다.
        //[/, ] 문자 하나에 대한 옵션 (/이거나 ,이거나 공백 문자)
        //구분자를 3개로 분할한다
        String[] arr4 = dirtyData.split("[/,]");
        System.out.println(Arrays.toString(arr4));
        System.out.println(arr4.length);

    }   //end of main

}
