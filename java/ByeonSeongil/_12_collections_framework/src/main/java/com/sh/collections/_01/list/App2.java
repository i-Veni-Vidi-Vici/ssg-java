package com.sh.collections._01.list;


import com.sh.collections._01.list.comparator.PriceAscending;
import com.sh.collections._01.list.comparator.TitleAscending;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App2 {
    public static void main(String[] args) {
        // Book 리스트로 관리
        List<Book> list = new ArrayList<>();
        list.add(new Book(100L, "홍길동전", "허균", 15000));
        list.add(new Book(200L, "신사동 가로수길", "신사임당", 30000));
        list.add(new Book(300L, "해시계 파헤치기", "장영실", 17000));


        // 2권 추가 (내부적으로 관리되는 배열의 크기를 신경쓰지 않아도 된다.)
        list.add(new Book(400L, "한글2", "허균",1333 ));
        list.add(new Book(500L, "한글3", "허균",1000 ));

        // 1권 삭제 (중간 2번지 데이터 삭제)
        list.remove(2);

        // 중간에 2번지 1권 추가
        list.add(2, new Book(150L,"골목대장", "윤봉준", 27000));
        System.out.println(list.toString());

        // 커스텀 클래스 정렬 - 정렬기준 Comparator를 제공
//        Collections.sort(list, new TitleAscending()); // 제목 오름차순
//        Collections.sort(list, Comparator.comparing(Book::getTitle));
//        Collections.sort(list, new PriceAscending().reversed());

        // 익명클래스 - 클래스 선언 + 객체 생성을 동시에 하는 방법. 클래스 이름이 없다. 1회용
        // 인터페이스/추상클래스 자식객체를 즉석에서 생성가능
//        Comparator<Book> bookComparator = new Comparator<>(){
//
//            @Override
//            public int compare(Book o1, Book o2) {
//                return o1.getPrice() - o2.getPrice();
//            }
//        };
//        Collections.sort(list, bookComparator);

        // 저자이름 오름차순 정렬(익명클래스방식)
//        Comparator<Book> bookComparator1 = new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                return o1.getAuthor().compareTo(o2.getAuthor());
//            }
//        };

        // 람다식(인터페이스 추상메서드가 하나인 경우) 작성도 가능함
        Collections.sort(list, (Book o1, Book o2)-> o1.getAuthor().compareTo(o2.getAuthor()));




        System.out.println(list);

    }
}
