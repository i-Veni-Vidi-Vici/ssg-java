package com.ssg.collections.list.book.run;

import com.ssg.collections.list.book.controller.BookListManager;
import com.ssg.collections.list.book.model.vo.Book;

import java.util.Scanner;

public class TestBookManager {
    private Scanner sc = new Scanner(System.in);
    private BookListManager manager;
    public static void main(String[] args) {
        TestBookManager testBookManager = new TestBookManager();
        testBookManager.manager = new BookListManager();



    }

    public String inputBookTitle(){
        //Index를 리턴한다
        String title = sc.next();
        int index = manager.searchBook(title);
        return Integer.toString(index);
    }

    public Book inputBook(){
        Book tmpBook = new Book();
        System.out.println("도서 정보를 입력하세요");
        System.out.println("도서번호 : ");
        tmpBook.setNo(sc.next());
        System.out.println("도서분류코드(1.인문 / 2.자연과학 / 3.의료 / 4. 기타 : ");
        tmpBook.setCategory(sc.nextInt());
        System.out.println("책 제목 : ");
        tmpBook.setTitle(sc.next());
        System.out.println("저자 : ");
        tmpBook.setAuthor(sc.next());
        return tmpBook;
    }

    public void menu(){
        String str = """
                *** 도서 관리 프로그램 ***
                1. 새 도서 추가
                2. 도서정보 출력(책번호 오름차순)
                3. 도서정보 출력(카테고리 오름차순)
                4. 도서 삭제
                5. 도서 검색출력
                6. 전체 출력
                0. 끝내기
                --------------------
                메뉴선택 : """;
        System.out.println(str);
    }
}
