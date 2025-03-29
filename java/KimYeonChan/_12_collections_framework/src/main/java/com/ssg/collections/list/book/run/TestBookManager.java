package com.ssg.collections.list.book.run;

import com.ssg.collections.list.book.controller.BookListManager;
import com.ssg.collections.list.book.model.compare.BookCategoryAsc;
import com.ssg.collections.list.book.model.vo.Book;

import java.util.Comparator;
import java.util.Scanner;

public class TestBookManager {
    private static BookListManager bookListManager = new BookListManager();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        TestBookManager testBookManager = new TestBookManager();
        testBookManager.menu();
        System.out.println("프로그램 종료");
    }

    public String inputBookTitle() {
        System.out.print("도서 타이틀을 입력: ");
        return sc.next();
    }

    public Book inputBook() {
        System.out.print("도서번호(임의의 숫자/영대문자로 구성된 6자리 문자열: ");
        String no = sc.next();
        System.out.print("도서분류코드 (1.인문/2.자연과학/3.의료/4.기타): ");
        int category = sc.nextInt();
        System.out.print("책 제목: ");
        String title = sc.next();
        System.out.print("저자: ");
        String author = sc.next();
        return new Book(no, category, title, author);
    }

    public void menu() {
        while (true) {
            String menuStr = """
                *** 도서 관리 프로그램 ***
                1. 새 도서 추가
                2. 도서 정보 출력(책 번호 오름차순)
                3. 도서 정보 출력(카테고리 오름차순)
                4. 도서 삭제
                5. 도서 검색 출력
                6. 전체 출력
                0. 끝내기
                ---------------------
                메뉴 선택: """;
            System.out.print(menuStr);
            int choice = sc.nextInt();
            switch (choice) {
                case 1: bookListManager.addBook(inputBook()); break;
                case 2: bookListManager.printBookList(bookListManager.sortedBookListByNo()); break;
                case 3: bookListManager.printBookList(bookListManager.sortedBookListByCategory()); break;
                case 4: bookListManager.deleteBook(bookListManager.searchBook(inputBookTitle())); break;
                case 5: bookListManager.printBook(bookListManager.searchBook(inputBookTitle())); break;
                case 6: bookListManager.printAll(); break;
                case 0: return;
                default:
                    System.out.println("잘못된 입력 입니다.");
            }
        }
    }
}
