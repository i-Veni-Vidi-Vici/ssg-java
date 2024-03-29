package com.sh.collections._01.list;

import com.sh.collections._01.list.Coparator.PriceAscending;
import com.sh.collections._01.list.Coparator.TitleAscending;

import java.util.*;

public class App2 {
    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();
        list.add(new Book(100L,"홍길동전","허균",15000));
        list.add(new Book(200L,"신사동 가로수길","신사임당",30000));
        list.add(new Book(300L,"해시계 파헤치기","장영실",17000));
     //   };
        //2권추가
        list.add(new Book(400L,"한글2","세종대왕",20000));
        list.add(new Book(500L,"참수왕","논개",12000));
        //1권 삭제 (중간 2번지 데이터삭제)
        list.remove(2);
        //중간에 2번지 1권 추가

        list.add(2,new Book(150L,"골목대장","윤봉준",27000));
        //new Book(150L,"골목대장","윤봉준",27000)

       //1번지요소의 필드값 변경
        Book book = list.get(1);
        book.setTitle("대로변 대장");
        //커스텀 클래스 정렬
        //Collections.sort(list, new TitleAscending());
        Collections.sort(list,new PriceAscending().reversed());//가격내림차순 리버스 박아서

        //익명클래스 - 클래스 선언 + 객체 생성을 동시에 하는 방법. 클래스 이름이 없다. 1회용
        //인터페이스/추상클래스 자식객체를 즉석에서 생성가능
        Comparator<Book> priceAscendingComparator = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPrice()-o2.getPrice();
            }
        };

        Collections.sort(list, priceAscendingComparator);

        //저자이름 오름차순 정렬(익명클래스방식)
        Comparator<Book> AuthorAscendingComparator = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getAuthor().compareTo(o2.getAuthor());
            }
        };
        Collections.sort(list,AuthorAscendingComparator);
        //람다식(인터페이스 추상메소드가 딱 하나인 경우) 작성도 가능하다.
        Collections.sort(list,( Book o1, Book o2)->o1.getAuthor().compareTo(o2.getAuthor()));


        System.out.println(list);


    }
}
