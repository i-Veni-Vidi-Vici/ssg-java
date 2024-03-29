package com.sh.collections._02.set;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 * 커스텀 클래스 Set으로 관리하기
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        Set<Book> bookSet=new HashSet<>();
        bookSet.add(new Book(1l,"홍길동", "허균",15000));
        bookSet.add(new Book(2l,"신사동 가로수길","신사임당",30000));
        bookSet.add(new Book(3l,"해시계 파헤치기","장영실",17000));

        System.out.println(bookSet);
        System.out.println(bookSet.size());
        bookSet.add(new Book(5l,"장수왕","논개",12000));


        //동일한 내용의 Book객체 추가
        // equals/ HashCode기뵤equls결과가 trueㅡ, hashcode가 동일할 떄 같은 객체로 간주한다
        Book book6=new Book(500l,"장수앙","논개",25000);
//        System.out.println(b);


    }
}
