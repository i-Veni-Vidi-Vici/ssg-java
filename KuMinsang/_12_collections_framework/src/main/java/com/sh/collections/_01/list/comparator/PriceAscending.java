package com.sh.collections._01.list.comparator;

import com.sh.collections._01.list.Book;

import java.util.Comparator;

public class PriceAscending implements Comparator<Book> {
    @Override
<<<<<<< HEAD
    public int compare(Book o1, Book o2){
=======
    public int compare(Book o1, Book o2) {
//        int price1 = o1.getPrice();
//        int price2 = o2.getPrice();
//        if(price1 > price2)
//            return 1;
//        if(price1 < price2)
//            return -1;
//        return 0;
>>>>>>> 97aa7183c9fb127e3cf611ff187d772054906c64
        return o1.getPrice() - o2.getPrice();
    }
}
