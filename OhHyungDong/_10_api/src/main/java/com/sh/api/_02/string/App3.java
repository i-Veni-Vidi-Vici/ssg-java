package com.sh.api._02.string;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * <pre>
 *  CSV데이터
 *  - Comma Separted Value : 콤마 or 구분자로 구분 된 값(데이터에는 절대 존재하지 않는 값을 구분자로 사용해야 한다.)
 *  - 홍길동 , 33, ,서울시 강남구,
 *
 *  1. String#split(delimit : String) : String[]
 *  2. new StringTokenizer(data : String, delimit : String)
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {

        String data1 = "100/홍길동/서울/영업부 ";
        String data2 = "200/신사임당 //총무부 ";
        String data3 = "300/이순신/ 경기도  ";


        //1. split
        String[] split = data1.split("/");
        System.out.println(Arrays.toString(split));
        String[] split2 = data2.split("/");
        System.out.println(Arrays.toString(split2));
        String[] split3= data2.split("/", -1); //-1 : 요소개수 제한 없음
        System.out.println(Arrays.toString(split3));

        //2. tringTokenizer
        // - CSV데이터를 토큰으로 잘라내어 관리하는 개게
        StringTokenizer stringTokenizer = new StringTokenizer(data1,"/");
        System.out.println(stringTokenizer); //java.util.StringTokenizer@7ad041f3

        //반복 처리를 통해서 토큰을 열람(소비)
        System.out.println("현재 토큰 수 : " + stringTokenizer.countTokens());
        while(stringTokenizer.hasMoreTokens()){
            String token = stringTokenizer.nextToken();

            System.out.println("token 수 : " + token + ", 남은 토큰 수 = "  + stringTokenizer.countTokens());
        }
        System.out.println();

        StringTokenizer tokenizer2 = new StringTokenizer(data2, "/");
        System.out.println("현재 토큰 수 : " + tokenizer2.countTokens());
        while(tokenizer2.hasMoreTokens()) {
            String token = tokenizer2.nextToken();
            System.out.println("token 수 : " + token + ", 남은 토큰 수 = "  + tokenizer2.countTokens());
        }


        StringTokenizer str3 = new StringTokenizer(data3,"/");
       while(str3.hasMoreTokens()){
           String token = str3.nextToken();
           System.out.println("token 수 : " + token + ", 남은 토큰 수 = "  + str3.countTokens());

       }

       //구분자  섞여있는 경우
        String dirtyData = "red/oragne, blue yellow green";
       StringTokenizer tokenizer4 = new StringTokenizer(dirtyData,"/, ");
       while(tokenizer4.hasMoreTokens()) System.out.println(tokenizer4.nextToken());

        //split 매개변수는 정규표현식을 인자로한다.
        //[/,] 문자 하나에 대한 옵션 (/이거나, 이거나 공백문자) -> [/ , ]
       String[] arr4 = dirtyData.split("[/,]");
        System.out.println(Arrays.toString(arr4));
        System.out.println(arr4.length);


    }
}
