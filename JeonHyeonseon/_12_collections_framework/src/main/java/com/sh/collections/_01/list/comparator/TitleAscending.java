package com.sh.collections._01.list.comparator;

import com.sh.collections._01.list.Book;

import java.util.Comparator;

public class TitleAscending implements Comparator<Book> {

    /**
     * 양수 반환(자리 교환이 일어남)
     * 0 반환
     * 음수 반환
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(Book o1, Book o2) {
        // o1의 책 제목이 사전등재순이 늦다면 양수 반환 -> 자리교환
        // o1, o2 책 제목이 같다면 0을 반환하고 자리교환이 일어나지 않는다.
        // o1책제목이 사전등재순이 빠르다면 음수 반환
        return o1.getTitle().compareTo(o2.getTitle());

    }
}
