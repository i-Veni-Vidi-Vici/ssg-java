package com.sh.collections._01.list.comparator;

import com.sh.collections._01.list.Book;

import java.util.Comparator;

public class TiltleAscending implements Comparator<Book> {
    /**
     * 양수
     * 0
     * 음수
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(Book o1, Book o2) {
        // o1책제목이 사전등재순이 늦다면 양수 반환 -> 자리교환 O
        // o1, o2책제목이 같다면 0 반환 -> 자리교환 X
        // o1책제목이 사전등재순이 빠르다면 음수 반환 -> 자리교환 X
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
