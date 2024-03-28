package com.sh.collections._01.list;
import com.sh.collections._01.list.comparator.PriceAscending;

import java.util.*;

/**
 *
 */
public class App4 {
    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();
        list.add(new Book(100L, "홍길동", "허균", 15000));
        list.add(new Book(200L, "넛지", "제러드", 15000));
        list.add(new Book(300L, "이기적유전자", "엣킨슨", 15000));

        //2권추가
        list.add(new Book(400L, "한글2", "세종대왕", 20000));
        System.out.println(list);
        //1권 삭제(중간 2번지 데이터 삭제)
        list.remove(2);
        System.out.println(list);
        //중간에 2벉에 1권 추가
        list.add(2 ,new Book(500L, "해상왕", "지중왕", 25000));
        System.out.println(list);

        Collections.sort(list, new PriceAscending());
        System.out.println(list);

        Comparator authorAscending = new Comparator<Book>(){
            @Override
            public int compare(Book o1, Book o2){
                return o1.getAuthor().compareTo(o2.getAuthor());
            }
        };
        Collections.sort(list, authorAscending);
        System.out.println(list);

        //

    }
}
