package com.ssg.collections.list.customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerMain {
    public static void main(String[] args) {
        List<Customer> list=new ArrayList<>();

        //1. 지시한 순서대로 데이터
        list.add(new Customer("홍길동",25,"남",1250.5));
        list.add(new Customer("박문수",33,"남", 3457.8));
        list.add(new Customer("김춘추",38,"남",2485.6));
        list.add(new Customer("신사임당",43,"여",2300.9));
        System.out.println(list.toString());

        //2. 맨 앞에 추가
        list.add(0,new Customer("이황",66,"남",9999.9));

        //3. 가나다 순
        list.sort(new nameSort());
        System.out.println("이름 순 정렬 ");
        System.out.println(list.toString());

        //4. 나이 오름차순
        list.sort(new ageSort());
        System.out.println("나이순 정렬");
        System.out.println(list.toString());

        // 5. 포인트 내림차순
        list.sort(new PointSort().reversed());
        System.out.println("포인트 내림차순");
        System.out.println(list.toString());
    }
}
