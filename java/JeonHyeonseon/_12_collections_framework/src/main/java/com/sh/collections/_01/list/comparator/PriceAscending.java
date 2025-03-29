package com.sh.collections._01.list.comparator;

import com.sh.collections._01.list.Book;

import java.util.Comparator;

public class PriceAscending implements Comparator<Book> {

    // 가격 오름차순 정렬
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getPrice() - (o2.getPrice());  // o1이 o2보다 크면 양수, 작으면 음수, 같으면 0
    }

}
