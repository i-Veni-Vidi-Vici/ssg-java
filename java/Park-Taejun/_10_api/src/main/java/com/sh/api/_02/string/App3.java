package com.sh.api._02.string;

import java.util.Arrays;
import java.util.StringJoiner;

public class App3 {
    /**
     * <pre>
     * CSV 데이터
     * -Comma Seperated Value 구분자(,/$...)로 구분된 값
     * 데이터에는 절대 존재하지 않는 값을 구분자로 사용해야 한다.
     * -"홍길동,33,서울시 강남구, 농구/축구/배구"
     *
     * 1.String#split(delimit:String):String[]
     * 2. new StringTokenizer(data :String, delimit:String)
     *
     * </pre>
     *
     * @param args
     */

    public static void main(String[] args) {
        String data1 = "100/홍길동/서울/영업부 ";
        String data2 = "200/신사임당/서울/영업부 ";
        String data3 = "300/이순신/경기도/ ";

        //1.split
        String[] arr1 = data1.split("/");
        System.out.println(Arrays.toString(arr1));
//}
//    String [] arr = data1.split("/");
//
//    StringJoinerTO
    }

}