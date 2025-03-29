package com.ssg.collections.list.customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomerMain {
    public static void main(String[] args) {

        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("홍길동",25,"남",1250.5));
        customerList.add(new Customer("박문수",33,"남",3457.8));
        customerList.add(new Customer("김춘추",38,"남",2485.6));
        customerList.add(new Customer("신사임당",43,"여",2300.9));

        // 이황 데이터 추가
        customerList.add(0,new Customer("이황",66,"남",9999.9));

        // 고객 이름 가나다순 정렬
        System.out.println("고객 이름 가나다순 정렬");
        Collections.sort(customerList, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(customerList);

        // 나이 오름차순 정렬
        System.out.println("고객 나이 오름차순 정렬");
        Collections.sort(customerList, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(customerList);

        // 포인트 내림차순 정렬
        System.out.println("고객 포인트 내림차순 정렬");
        Collections.sort(customerList, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return (int) (o2.getPoint() - o1.getPoint());
            }
        });
        System.out.println(customerList);
    }
}
