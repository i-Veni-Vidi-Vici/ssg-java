package com.sh.collections._01.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class App1 {
    public static void main(String[] args) {
        ArrayList<Book> list1 = new ArrayList<>();
        List list2 = new ArrayList<Book>();

        list2.add(new Book(1L, "홍길동전", "허균",10000));
        list2.add(new Book(2L, "노인과바다", "헤밍웨이",15000));
        list2.add(new Book(3L, "성경", "미상",20000));

        Iterator<Book> iter = list2.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }

    }
}
