package com.ssg.collections.list.customer;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CustomerMain {
    public static void main(String[] args) {
        List<Customer> list = new LinkedList<>();

        // 위 표에 제시한 순서대로 데이터를 List 에 추가 하세요.
        list.add(new Customer("홍길동", 25, '남', 1250.5));
        list.add(new Customer("박문수", 33, '남', 3457.8));
        list.add(new Customer("김춘추", 38, '남', 2485.6));
        list.add(new Customer("심사임당", 43, '여', 2300.9));

        // 위 리스트에 다음데이터를 맨앞에 추가하세요.
        list.add(0, new Customer("이황", 66, '남', 9999.9));

        // 고객 이름 가나다순으로 정렬 해서 출력하세요.
        System.out.println("===== 고객 이름 가나다순 정렬 =====");
        test(list, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        // 나이 오름차순으로 정렬해서 출력하세요.
        System.out.println("===== 고객 나이 오름차순 정렬 =====");
        test(list, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        // 포인트 내림차순으로 정렬해서 출력하세요.
        System.out.println("===== 고객 포인트 내림차순 정렬 =====");
        test(list, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return (int)(o2.getPoint() - o1.getPoint());
            }
        });
    }

    private static void test(List<Customer> list, Comparator<Customer> comparator) {
        list.sort(comparator);
        for (Customer customer : list) {
            System.out.println(customer.information());
        }
    }
}
