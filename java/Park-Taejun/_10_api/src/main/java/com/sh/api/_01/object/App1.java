//package com.sh.api._01.object;
//
//import javax.lang.model.element.NestingKind;
//
//public class App1 {
//
//    /**
//     * Object 클래스
//     * - 모든 클래스의 부모 클래스임
//     * - 필드 없이 메소드만 제공
//     * - toString(), hashCOde
//     * @param args
//     */
//    public static void main(String[] args) {
//
//        Book book1 = new Book ( 1L , "홍길동전" , "허균" , 15000);
//        Book book2 = new Book ( 2L , "목민심서" , "정약용" , 30000);
//        Book book3 = new Book ( 2L , "목민심서" , "정약용" , 30000);
//
//        // toString 호출 : 객체를 문자열로서 출력해야 할 때 자동을 호출
//        //Object#toString : return getClass().getName() + "@" + Integer.toHexString(hashCode());
//        // 클래스객체(클래스 별로 메모리에 적재된 프로토타입 객체)의 이름 -> 클래스 풀네임
//
//        System.out.println("book1 : " + book1);
//        System.out.println("book1 : " + book1.toString());
//        System.out.println("book1 : " + book2);
//        System.out.println("book1 : " + book2.toString());
//        System.out.println("book1 : " + book3);
//        System.out.println("book1 : " + book3.toString());
//
//    }
//    @Override
//    public String toString(){
//        return "Book[id = " + id + ",title = " + title + "author  " + author  +"] "
//    }
//}
