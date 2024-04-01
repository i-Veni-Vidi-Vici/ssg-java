package com.ssg.collections.list.customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CustomerMain {
    public static void main(String[] args) {
        List<Customer> list = new ArrayList<>();

        // 1
        list.add(new Customer("홍길동", 25, '남', 1250.5));
        list.add(new Customer("박문수", 33, '남', 3457.8));
        list.add(new Customer("김춘추", 38, '남', 2485.6));
        list.add(new Customer("신사임당", 43, '여', 2300.9));

        // 2
        list.add(0, new Customer("이황", 66, '남', 9999.9));

        // 3
        Collections.sort(list, (Customer o1, Customer o2) -> o1.getName().compareTo(o2.getName()));
        System.out.println(list);

        // 4
        Collections.sort(list, (Customer o1, Customer o2) -> o1.getAge() - o2.getAge());
        System.out.println(list);

        // 5
        Collections.sort(list, (Customer o1, Customer o2) -> (int) (o2.getPoint() - o1.getPoint()));
        System.out.println(list);
    }
}
