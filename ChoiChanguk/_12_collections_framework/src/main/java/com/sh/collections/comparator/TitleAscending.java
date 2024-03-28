package com.sh.collections.comparator;

import com.sh.collections._01.list.Book;

import java.util.Comparator;
public class TitleAscending implements Comparator<Book>{
    /**
     * <pre>
     * 양수 ( 자리 교환)
     * 0
     * 음수
     *
     * </pre>
     */

    @Override
    public int compare(Book book1, Book book2) {
        // book1책제목이 사전등재순이 늦다면 양수 반환 -> 크다=늦게 있다
        // book1, book2책제목이 같다면 0 반환
        // book1<book2 음수가 나옴
        return book1.getTitle().compareTo(book2.getTitle());
    }

}
