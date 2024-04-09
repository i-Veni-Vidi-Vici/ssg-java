package com.ssg.collections.list.customer;

import java.util.Comparator;

public class PointDescending implements Comparator<Customer> {
    @Override
    public int compare(Customer c1, Customer c2) {
        return (int) (c1.getPoint() - c2.getPoint());
    }
}
