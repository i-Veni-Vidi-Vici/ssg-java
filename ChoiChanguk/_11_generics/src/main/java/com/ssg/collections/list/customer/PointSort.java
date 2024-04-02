package com.ssg.collections.list.customer;

import java.util.Comparator;

public class PointSort implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        return (int)o1.getPoint()-(int)o2.getPoint();
    }
}
