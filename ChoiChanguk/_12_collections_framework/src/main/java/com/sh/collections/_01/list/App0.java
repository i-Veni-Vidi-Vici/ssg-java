package com.sh.collections._01.list;
import java.util.Arrays;

/**
 * <pre>
 * Collections Framework
 * - 자바진영에서 대용량데이터 처리를 위해 만들어준 자료구조
 *
 *
 * 1. List 계열 : 순사가 유지되어야 하는 데이터 처리 담당
 * 2. Set 계열 : 중복을 허용해서는 안되는 데이터 처리 담당
 * 3. Map 계열 : key/value로 하나의 요소를 구성하는 데이터 처리
 *  (이때 key는 중복허용 X
 * </pre>
 */
public class App0 {
    public static void main(String[] args) {
        Book[] books=new Book[]{
                new Book(100l,"홍길동", "허균",15000)
        ,new Book(100l,"신사동 가로수길","신사임당",30000)
        , new Book(300l,"해시계 파헤치기","장영실",17000)};

    //2권 추가(배열은 크기 변경이 불가능하다)
        Book[] books2=new Book[100]; // 불피요한 공간을 미리 할당 (공간 낭비)
        System.arraycopy(books,0,books2,0,books.length);
        books2[3] = new Book();
        books2[4] = new Book(500l, "잠수왕", "논개", 20000);

        System.out.println(Arrays.toString(books2));
        books2[2]=books2[3];// books2[2]삭제한 과정이다
        books2[3]=books2[4];
        books2[4]=null;

        //중간에 1권 추가
        books2[4]=books2[3];
        books2[3]=books2[2];
        books2[2]=books2[1];
        books2[1]=new Book(100l,"골목대장","윤동주",27000);
    }

}
