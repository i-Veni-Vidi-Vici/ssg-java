package com.sh.collections._01.list;

import com.sh.collections._01.list.comparator.PriceAscending;
import com.sh.collections._01.list.comparator.TitleAscending;

import java.util.*;

/**
 * <pre>
 *     배열 대신 List로 관리하기
 * </pre>
 */

public class App2 {
    public static void main(String[] args) {

        //Book 리스트로 관리
        List<Book> list = new ArrayList<>();
        list.add(new Book(100L, "홍길동전", "허균", 15000));
        list.add(new Book(200L, "신사동 가로수길", "신사임당", 30000));
        list.add(new Book(300L, "해시계 파헤치기", "장영실", 17000));


        //책 2권 추가 (내부적으로 관리되는 배열의 크기를 신경쓰지 않아도 됨!)
        list.add(new Book(400L, "한글2", "세종대왕", 20000));
        list.add(new Book(500L, "잠수왕", "논개", 12000));

        // 책 1권 삭제(중간의 데이터 삭제) - 중간에 데이터가 null로 두지 않음 -> 데이터 관리의 어려움이 있기 때문!
        list.remove(2);

        // 중간에 책 1권 추가
        list.set(1, new Book(150L, "골목대장", "윤봉준", 27000));


        //1번지 요소의 필드 값 변경
        Book book = list.get(1);
        book.setTitle("대로변 대장");

        //커스텀 클래스 정렬 - 정렬기준 Comparator를 제공
//        Collections.sort(list, new TitleAscending()); //제목 오름차순
//        Collections.sort(list, new PriceAscending()); //가격 오름차순
        Collections.sort(list, new PriceAscending().reversed()); //가격 내림차순 -> compared된 것들의 부호를 바꿔줌

        //익명 클래스 - ✨클래스 선언 + 객체 생성을 동시에✨ 하는 방법, 클래스 이름이 없음, 1회용
        //인터페이스/추상클래스 자식 객체를 즉석에서 생성가능
//        Comparator<Book> priceAscendingComparator = new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                return o1.getPrice() - o2.getPrice();
//            }
//        };
//        Collections.sort(list, priceAscendingComparator);

        //저자 이름오름차순 정렬(익명 클래스 방식)
//        Collections.sort(list, new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                return o1.getAuthor().compareTo(o2.getAuthor());
//            }
//        });


        //람다식 (인터페이스 추상메소드가 딱 하나일 때) 작성도 가능함
        Collections.sort(list, (Book o1, Book o2) -> {
            return o1.getAuthor().compareTo(o2.getAuthor());
        });

        System.out.println(list);
    }
}
