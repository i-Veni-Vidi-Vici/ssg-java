package com.sh.collections._01.list.comparator;

import com.sh.collections._01.list.Book;

import java.util.Comparator;

public class PriceAscending implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        // o1책제목이 사전등재순이 늦다면 양수 반환 -> 자리교환
        // o1, o2책제목이 같다면 0 반환
        // o1책제목이 사전등재순이 빠르다면 음수 반환
        return o1.getPrice() - o2.getPrice();
    }
}
