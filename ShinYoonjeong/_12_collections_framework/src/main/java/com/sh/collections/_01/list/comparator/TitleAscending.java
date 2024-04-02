package com.sh.collections._01.list.comparator;

import com.sh.collections._01.list.Book;

import java.util.Comparator;

public class TitleAscending  implements Comparator<Book> {
    /**
     * 양수
     * 음수
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return
     */

    @Override
    public int compare(Book o1, Book o2) {
        // o1 책 제목이 사전등재순이 늦다면 양수 반환 -> 자리교환
        // o1, o2 책제목이 같다면 0 반환
        // o1 책제목이 사전 등재순이 빠르다면 음수 반환
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
