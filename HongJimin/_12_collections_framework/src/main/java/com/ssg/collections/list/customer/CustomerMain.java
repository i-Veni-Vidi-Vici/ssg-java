package com.ssg.collections.list.customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerMain {
    public static void main(String[] args) {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("홍길동", 25, "남", 1250.5));
        customerList.add(new Customer("박문수", 33, "남", 3457.8));
        customerList.add(new Customer("김춘추", 38, "남", 2485.6));
        customerList.add(new Customer("신사임당", 43, "여", 2300.9));

        customerList.add(0, new Customer("이황", 66, "남", 9999.9));

        Collections.sort(customerList, new NameAscending());
        System.out.println("""
                ✅ 이름 가나다 순 정렬
               =============================
                이름  나이  성별  포인트
               =============================""");
        for(Customer customer : customerList){
            System.out.print(customer);
        }

        System.out.println("=============================");
        System.out.println("✅ 나이 오름차순 정렬");
        System.out.println("=============================");
        Collections.sort(customerList, new AgeAscending());
        for(Customer customer : customerList){
            System.out.print(customer);
        }

        System.out.println("=============================");
        System.out.println("✅ 포인트 내림차순 정렬");
        System.out.println("=============================");
        Collections.sort(customerList, new PointDescending().reversed());
        for(Customer customer : customerList){
            System.out.print(customer);
        }
    }
}
