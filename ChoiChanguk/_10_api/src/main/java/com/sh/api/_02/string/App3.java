package com.sh.api._02.string;

import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * <pre>
 * CSV데이터
 * - Comma Seperated Value 콤마로 구분된 값(,/$...)
 * (데이터에는 절대 존재하지 않는 값을 구분자로 사용해야 한다.
 * - ex) 홍길동, 33, 서울시 강남구
 *
 * 1. String#split(delimi : string : String[])
 * 2. new StringTokenizer(data:String, delimit:String)
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        String data1="100/홍길동/서울/영업부";
        String data2="200/신사임당//총무부";
        String data3="300/이순신/경기도/";

        // 1. split
        String[] arr1=data1.split("/");
        System.out.println(Arrays.toString(arr1));

        String[] arr2=data2.split("/");
        System.out.println(Arrays.toString(arr2));

        String[] arr3=data3.split("/",-1);// 마지막요소 처리가 안된다,-1=요소재수 재한 없음
        System.out.println(Arrays.toString(arr3));

        String[] arr4=data3.split("/",4);
        System.out.println(Arrays.toString(arr4));
        System.out.println();


        //2. StringTokenzier
        // - CSV데이터를 토큰으로 잘라내어 관리하는 객체
        StringTokenizer stringTokenizer=new StringTokenizer(data1,"/");
        //System.out.println(stringTokenizer.toString());//java.util.StringTokenizer@36baf30c
        //반복처리를 통해서 토큰을 열람할 수 있다(소비)
        System.out.println("현재 토큰 수 : "+stringTokenizer.countTokens());
        while (stringTokenizer.hasMoreElements()) {
            System.out.println(stringTokenizer.nextToken());
            System.out.println("남은 토큰 수 : "+stringTokenizer.countTokens());
        }
        System.out.println();

        //StringTokenizer특징 : 비어있는 문자열 요소는 제거한다.
        StringTokenizer stringTokenizer2=new StringTokenizer(data2,"/");
        System.out.println("현태 토큰구 : "+stringTokenizer2.countTokens());
        while (stringTokenizer2.hasMoreTokens()) {
            String token=stringTokenizer2.nextToken();
            System.out.println("token = "+"token"+","+"남은"+"토큰큰수+"+stringTokenizer2.countTokens());

        }


        // 구분자가 섞여 있는부분
        String dirtyData = "red/orandge,blue yellow green";
        StringTokenizer  stringTokenizer1=new StringTokenizer(dirtyData,"/");
        while (stringTokenizer1.hasMoreTokens()) {
            System.out.println(stringTokenizer1.nextToken());
        }

        String[] arr5=dirtyData.split("/");
        System.out.println(Arrays.toString(arr5));

        // split 매개변수는 정규표현식 (문자열 검색을 지원하는 표현식)을 인자로 한다.
        //[/,] 문자하나에 대한 옵션 (/이거나 ,이거나 공백 문자)
        String[] arr6=dirtyData.split("/"); //대괄호를 쓰면 따로따로 본다ex) /, 이걸 한덩이, [/,]슬래시거나 컴마로 인식
    }
}
