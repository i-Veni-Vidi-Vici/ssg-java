package com.ssg.collections.list.customer;

import java.util.*;

public class CustomerMain {
    public static void main(String[] args) {
        List<Customer> list = new ArrayList<>();
        list.add(new Customer("홍길동", 25, "남", 1250.5));
        list.add(new Customer("박문수", 33, "남", 3457.8));
        list.add(new Customer("김춘추", 38, "남", 2485.6));
        list.add(new Customer("심사임당", 43, "여", 2300.9));

        list.add(0, new Customer("이황", 66, "남", 9999.9));

        System.out.println(list);

        Comparator<Customer> nameDescending = new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Collections.sort(list, nameDescending);
        System.out.println("고객 이름 가나다순");
        System.out.println(list);

        Comparator<Customer> ageAscending = new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getAge() - o2.getAge();
            }
        };
        Collections.sort(list, ageAscending);
        System.out.println("나이 오름차순");
        System.out.println(list);

        Comparator<Customer> pointDescending = new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return (int)(o2.getPoint() - o1.getPoint());
            }
        };
        Collections.sort(list, pointDescending);
        System.out.println("포인트 내림차순");
        System.out.println(list);
    }
}
