package com.ssg.collections.list.customer;

import java.util.Comparator;

public class ageSort implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.getAge()-o2.getAge();
    }
}
