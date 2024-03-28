package com.sh.collections._01.list;

import com.sh.collections.comparator.PriceAscending;
import com.sh.collections.comparator.TitleAscending;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <pre>
 * 배열 대신 List로 관리하기
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {;
        List<Book> list=new ArrayList<>();

        list.add(new Book(1l,"홍길동", "허균",15000));
        list.add(new Book(2l,"신사동 가로수길","신사임당",30000));
        list.add(new Book(3l,"해시계 파헤치기","장영실",17000));


        //2권 추가
        list.add(new Book(4l,"한글","세종대왕",20000));
        list.add(new Book(5l,"홍익인간","널리이롭게",20250));
        System.out.println("추가 후 사이즈 : "+ list.size()+ "\n"+list);

        //1권 삭제
        list.remove(2);
        System.out.println("삭제 후 사이즈 : "+ list.size()+ "\n"+list);

        //중간에 1번지 1권 추사
        list.add(1,new Book(5l,"골목대장","뿡뿡이",25000));
        System.out.println("중간에 추가 후 사이즈 : "+ list.size()+ "\n"+list);

        //1번지의 요소를 바꾼다 즉 = 리스트내용이 아닌 리스트의 내용물의 내용물을 바꾼다
        Book book=list.get(0);
        book.setTitle("홍길동 아버님");
        System.out.println("0번지 요소를 바꾼 후 사이즈 : "+ list.size()+ "\n"+list);

        //커스텀 클래스 정렬 - 정렬기준 Comparator
        Collections.sort(list,new TitleAscending());
        System.out.println("(타이틀)정렬 후 사이즈 : "+ list.size()+ "\n"+list);

        //커스텀 클래스 정렬 - 정렬기준 가격
        Collections.sort(list,new PriceAscending());
        System.out.println("(가격)정렬 후 사이즈 : "+ list.size()+ "\n"+list);
        Collections.sort(list,new PriceAscending().reversed());//내림차순
        System.out.println("(가격)정렬 후 사이즈 : "+ list.size()+ "\n"+list);

        //익명 클래스 - 클래스 선언 + 객체 생성을 동시에 하는 방법, 클래스 이름이 없다.+ 1회용이다
        // 인터페이스/추상클래스 자식 객체를 즉성에서 생성가능하다
        Comparator<Book> priceAscendingComparator = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPrice()-o2.getPrice();
            }
        };
        Collections.sort(list,priceAscendingComparator);

        // 저자이름 오름차순 정렬(익명클래스방식)
        Comparator<Book> authorAscendingComparator = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }

        };


    }
}
