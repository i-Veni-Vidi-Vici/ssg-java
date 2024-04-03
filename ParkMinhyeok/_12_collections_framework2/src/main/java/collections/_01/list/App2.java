package collections._01.list;

import collections._01.list.comparator.PriceAscending;
import collections._01.list.comparator.TitleAscending;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <pre>
 * 배열 대신
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();
        list.add(new Book(100L, "홍길동전", "허균", 15000));
        list.add(new Book(200L, "신사동 가로수길", "신사임당", 30000));
        list.add(new Book(300L, "해시계 파헤치기", "장영실", 17000));

        // 2권 추가
        list.add(new Book(400L, "추가1번", "작성자2", 20000));
        list.add(new Book(400L, "추가1번", "작성자2", 20000));

        // 1권 삭제
        list.remove(0);

        // 중간에 2번지 1권 추가
        list.add(0, new Book(700L, "어쩌구", "저쩌구", 20000));

        // 커스텀 클래스 정렬- 정렬기준 Comparator를 제공
//        Collections.sort(list, new TitleAscending());
//        Collections.sort(list, new PriceAscending());

        // 익명클래스 - 클래스 선언 + 객체 생성을 동시에 하는 방법. 클래스 이름이 없다. 1회용
        // 인터페이스/추상클래스 자식객체를 즉석에서 생성가능
        Comparator<Book> priceAscendingComparator = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPrice() - o2.getPrice();
            }
        };
//        Collections.sort(list, priceAscendingComparator);

        // 저자이름 오름차순 정렬 (익명클래스 방식)
//        Comparator<Book> authorAscendingComparator = new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                return o1.getAuthor().compareTo(o2.getAuthor());
//            }
//        };
//        Collections.sort(list, authorAscendingComparator);

        // 람다식(인터페이스 추상메소드가 딱 하나인 경우) 작성도 가능하다.
        Collections.sort(list, (Book o1, Book o2) -> o1.getAuthor().compareTo(o2.getAuthor()));


        System.out.println(list);
    }
}
