package com.sh.collections._01.list.Coparator;

import com.sh.collections._01.list.Book;

import java.util.Comparator;

public class PriceAscending implements Comparator<Book> {
    public int compare(Book o1,Book o2){
        return o1.getPrice()-o2.getPrice();

    }
    }
