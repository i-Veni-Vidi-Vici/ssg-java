package com.sh.collections._03.map;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 커스텀클래스 맵으로 관리하기
 * - Map<K,V>
 * - Map<Long, Book> 식별필드를 key로, Book객체를 value로 관리
 * - Map<Book, Integer> Book 객체를 Key로, 판매량데이터(int)를 value로 관리
 * </pre>
 */
public class App3  {
    public static void main(String[] args) {

        //new Book(1l,"홍길동", "허균",15000));
        //        bookSet.add(new Book(2l,"신사동 가로수길","신사임당",30000));
        //        bookSet.add(new Book(3l,"해시계 파헤치기","장영실",17000));
        Map<Long, Book> bookMap=new HashMap<>();
        bookMap.put(1l, new Book(1l,"홍길동", "허균",15000));
        bookMap.put(2l, new Book(1l,"신사동", "호랭이",15000));
        bookMap.put(3l, new Book(1l,"해시계", "장영실",15000));
        System.out.println(bookMap.get(1l));

        // 2. 책별 판매량 관리
        Map<Book, Integer> bookSaleMap=new HashMap<>();
        bookSaleMap.put(new Book(1l,"홍길동", "허균",15000), 10);
        bookSaleMap.put(new Book(2l,"신사동", "호랭이",15000), 15);

        // 어디서 뭘 가져오는지, 어디에 담아야 하는지 확인하면서 해야됨
        Book hongBook=new Book(1l,"홍길동","허균",15000);
        if(bookSaleMap.containsKey(hongBook))
        {
            int value=bookSaleMap.get(hongBook);
            bookSaleMap.put(hongBook,value+5);
        }
        else
            bookSaleMap.put(hongBook,5);

        System.out.println(bookSaleMap);


    }
}
