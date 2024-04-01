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
        Set<Book> bookSet = new HashSet<>();

        bookSet.add(new Book(100L, "홍길동전", "홍길동", 15000));
        bookSet.add(new Book(200L, "신사동 가로수길", "신사임당", 30000));
        bookSet.add(new Book(300L, "해시계 파헤치기", "장영실", 17000));
        bookSet.add(new Book(400L, "한글2", "세종대왕", 20000));
        bookSet.add(new Book(500L, "잠수왕", "논개", 12000));

        // 동일한 내용의 Book 객체 추가
        // new 연산자로 객체 새로 생성 -> 주소값 달라서 다른 객체로 인식 -> 내용 같아도 추가됨
        // equals/hashCode 비교후 각각 true/동일할때 같은 객체로 간주
        // 내용 같을때 추가 안되게 하고 싶으면 Book클래스에서 equals/hashCode 오버라이드
        bookSet.add(new Book(500L, "잠수왕", "논개", 12000));

        System.out.println(bookSet);
        System.out.println(bookSet.size());
    }
}
