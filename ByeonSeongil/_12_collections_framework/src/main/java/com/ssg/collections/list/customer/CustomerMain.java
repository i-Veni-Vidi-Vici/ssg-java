package com.ssg.collections.list.customer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomerMain {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>(){
            {
                add(new Customer("홍길동", 25, "남", 1250.5));
                add(new Customer("박문수", 33, "남", 3457.8));
                add(new Customer("김춘추", 38, "남", 2485.6));
                add(new Customer("신사임당", 43, "여", 2300.9));
            }
        };
        customers.add(0, new Customer("이황", 66, "남", 9999.9));

        customers.sort(Comparator.comparing(Customer::getName));
        System.out.println(customers);

        customers.sort(Comparator.comparingInt(Customer::getAge));
        System.out.println(customers);

        customers.sort(Comparator.comparingDouble(Customer::getPoint).reversed());
        System.out.println(customers);
    }
}
