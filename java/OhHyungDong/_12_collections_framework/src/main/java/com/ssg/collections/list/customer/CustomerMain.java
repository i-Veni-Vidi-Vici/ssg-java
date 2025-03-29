package com.ssg.collections.list.customer;

import com.sh.collections._01.list.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomerMain
{
    public static void main(String[] args) {
        List<Customer> list = new ArrayList<>();

        list.add(new Customer("홍길동", 25, "남", 1250.5));
        list.add(new Customer("박문수", 33, "남", 3457.8));
        list.add(new Customer("김춘추", 38, "남", 2485.6));
        list.add(new Customer("신사임당", 43, "여", 2300.9));

        //이황 데이터 맨 앞으로 추가
        list.add(0,new Customer("이황", 66, "남", 9999.9));
        for (Customer customer : list) {
            System.out.println(customer);
        }

        //고객 이름 가나다순으로 정렬
        Collections.sort(list, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(list);

        //나이 오름차순으로 정렬
        Collections.sort(list, new Comparator<Customer>(){
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(list);

        //포인트 내림차순으로 정렬
        Collections.sort(list, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return (int)(o2.getPoint() - o1.getPoint());
            }
        });
        System.out.println(list);
    }
}
