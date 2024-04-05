package com.ssg.collections.list.customer;

import java.util.Comparator;

public class AgeAscending implements Comparator <Customer>{
    @Override
    public int compare(Customer n1, Customer n2) {
        return n1.getAge() - n2.getAge();
    }
}
