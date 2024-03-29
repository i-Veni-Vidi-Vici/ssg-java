package com.sh.collections._01.list.Coparator;

import com.sh.collections._01.list.Book;

import java.util.Comparator;

public class TitleAscending implements Comparator<Book> {
    /**
     * 양수(자리교환)
     * 0
     * 음수
     *
     *
     *
     */
    public int compare(Book o1,Book o2){
        //o1책제목이 사전등재순이 늦다면 양수반환 ->자리교환
        //o1 ,o2 책제목이 같다면 0반환
        //o1 책제목이 사전등재순이 빠르다면 음수 반환
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
