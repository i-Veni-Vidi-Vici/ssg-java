package com.sh.collections._02.set;


import java.util.HashSet;
import java.util.Set;

/**
 *
 * <pre>
 *  커스텀 클래스 Set으로 관리하기
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book(100L, "홍길동전", "허균", 15000));
        bookSet.add(new Book(200L, "신사동 가로수길", "신사임당", 30000));
        bookSet.add(new Book(300L, "해시계 파헤치기", "장영실", 17000));

        // 2권 추가 (내부적으로 관리되는 배열의 크기를 신경쓰지 않아도 된다.)
        bookSet.add(new Book(400L, "한글2", "세종대왕", 20000));

        Book book5 = new Book(500L, "잠수왕", "논개", 12000);
        bookSet.add(book5);

        //동일한 내용의 Book객체 추가
        // 추가저장 잘됩니다 왜..? 잘돼? 원래 같은 내용 객체면 저장 안되는데 set인데
        // 메모리상에 북객체 6개임 new 연산자 할 때마다 객체 생김 그래서 서로 다른 객체라서 가능
        Book book6 = new Book(500L, "잠수왕", "논개", 12000);
        bookSet.add(book6);

        //equals/hashCode 비교후, equal결과가 true , hashCode가 동일할 때 같은 객체로 간주한다.
        // Book객체 가서 이퀄즈 해쉬코드 오버라이딩 해주기
        System.out.println(book5.equals(book6));
        System.out.println(book5.hashCode() == book6.hashCode());


        //Alt + Shift
        System.out.println(bookSet); // 순서 엉망입니다~
        System.out.println(bookSet.size());


    }
}
