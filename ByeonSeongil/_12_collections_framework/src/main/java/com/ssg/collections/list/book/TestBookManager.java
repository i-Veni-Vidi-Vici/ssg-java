package com.ssg.collections.list.book;

import com.ssg.collections.list.book.controller.BookMapManager;
import com.ssg.collections.list.book.model.vo.Book;
import java.util.Scanner;

public class TestBookManager {
    private BookMapManager bookMapManager = new BookMapManager();

    public static void main(String[] args) {
        com.ssg.collections.list.book.run.TestBookManager testBookManager = new com.ssg.collections.list.book.run.TestBookManager();
        testBookManager.menu();
    }

    public String inputBookTitle() {
        Scanner sc = new Scanner(System.in);
        System.out.print("타이틀 입력:");
        return sc.next();
    }

    public Book inputBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("넘버 입력:");
        String no = sc.next();

        System.out.print("카테고리 입력:");
        int category = sc.nextInt();

        System.out.print("타이틀 입력:");
        String title = sc.next();

        System.out.print("작가 입력:");
        String author = sc.next();

        return new Book(no, category, title, author);
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("*** 도서 관리 프로그램 ***\n"
                    + "1. 새 도서 추가\n"
                    + "2. 도서정보 출력(책번호 오름차순)\n"
                    + "3. 도서정보 출력(카테고리 오름차순)\n"
                    + "4. 도서 삭제\n"
                    + "5. 도서 검색출력\n"
                    + "6. 전체 출력\n"
                    + "0. 끝내기\n"
                    + "--------------------\n메뉴선택 :");
            switch (sc.nextInt()) {
                case 1:
                    bookMapManager.addBook(inputBook());
                    break;
                case 2:
                    bookMapManager.printBookMap(bookMapManager.sortedBookListByNo());
                    break;
                case 3:
                    bookMapManager.printBookMap(bookMapManager.sortedBookListByCategory());
                    break;
                case 4:
                    bookMapManager.deleteBook(bookMapManager.searchBook(inputBookTitle()));
                    break;
                case 5:
                    bookMapManager.printBook(bookMapManager.searchBook(inputBookTitle()));
                    break;
                case 6:
                    bookMapManager.printAll();
                    break;
                case 0:
                    return;
            }
        }

    }
}
