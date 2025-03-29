package com.sh.collections._01.list;

/**
 * <pre>
 *  Collections Framework
 *  - 자바 진영에서 대용량 데이터 처리르 위해 만들어둔 자료 구조
 *
 *  1. List 계열 : 순서가 유지되야하는 데이터 처리
 *  2. Set 게열 : 중복을 허용해서 안되는 데이터 처리
 *  3. Map 계열 : key/value로 하나의 요소를 구성하는 데이터처리 (key는 중복을 허용하지 않는다.)
 * </pre>
 */
public class App0 {
    public static void main(String[] args) {
        Book[] books = new Book[]{
                new Book(100L, "홍길동전", "허균", 15000),
                new Book(200L, "신사동 가로수길", "신사임당", 35000),
                new Book(300L, "해시계 파헤치기", "장영실", 40000)
        };
        // 2권 추가 (배열은 크기 변경이 불가능해서 2권을 추가하기에는 새로운 배열을 생성해서 대입해야하는 단점이 있음.
        Book[] books2 = new Book[5]; //불필요한 공간을 미리 저장하여 메모리 낭비
        System.arraycopy(books,0,books,0,books2.length);
        books2[3] = new Book(400L, "gksr", "tpwhdeodhkd", 20000);
        books2[3] = new Book(500L, "qkdakddl", "ehRoql", 10000);

        //1권 삭제(중간의 데이터를 삭제)
        // books[2] = null //중간에 데이터를 비워두지 않는다.
        books2[2] = books[3];

    }
}

