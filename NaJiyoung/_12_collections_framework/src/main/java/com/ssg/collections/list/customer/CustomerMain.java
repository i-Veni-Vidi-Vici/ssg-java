package com.ssg.collections.list.customer;

import java.util.*;

public class CustomerMain {
    private List<Customer> list = new ArrayList<>();

    public static void main(String[] args) {
        CustomerMain main = new CustomerMain();
        main.test1();
        main.test2();
        main.test3();
        main.test4();
        main.test5();
    }

    public void test1() {
        list.add(0, new Customer("홍길동", 25, '남', 1250.5));
        list.add(1, new Customer("박문수", 33, '남', 3457.8));
        list.add(2, new Customer("김춘추", 38, '남', 2485.6));
        list.add(3, new Customer("신사임당", 43, '여', 2300.9));
        System.out.println("[문제 1] " + list);
    }

    public void test2() {
        list.add(0, new Customer("이황", 66, '남', 9999.9));
        System.out.println("[문제 2] " + list);
    }

    public void test3() {
        Comparator<Customer> nameAscendingComparator = new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Collections.sort(list, nameAscendingComparator);
        System.out.println("[문제 3] " + list);
    }

    public void test4() {
        Comparator<Customer> ageAscendingComparator = new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getAge() - o2.getAge();
            }
        };
        Collections.sort(list, ageAscendingComparator);
        System.out.println("[문제 4] " + list);
    }

    public void test5() {
        Comparator<Customer> pointAscendingComparator = new Comparator<Customer>() {
          @Override
          public int compare(Customer o1, Customer o2) {
              return (int)(o1.getPoint() - o2.getPoint());
          }
        };
        Collections.sort(list, pointAscendingComparator.reversed());
        System.out.println("[문제 5] " + list);
    }
}
