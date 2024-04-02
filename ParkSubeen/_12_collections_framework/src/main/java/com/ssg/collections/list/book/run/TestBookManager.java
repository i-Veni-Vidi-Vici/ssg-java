package com.ssg.collections.list.book.run;

import com.ssg.collections.list.book.controller.BookListManager;
import com.ssg.collections.list.book.model.vo.Book;

import java.util.Random;
import java.util.Scanner;

public class TestBookManager {
    BookListManager bookListManager = new BookListManager();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        TestBookManager test = new TestBookManager();
        test.menu();
    }

    public String inputBookTitle() {
        sc.nextLine();
        System.out.print("> 도서 제목 입력 : ");
        return sc.nextLine();
    }

    public Book inputBook() {
        String no = rndBookNum();
        System.out.print("> 도서분류코드 (1.인문/2.자연과학/3.의료/4.기타) : ");
        int category = sc.nextInt();
        sc.nextLine();
        System.out.print("> 책제목 : ");
        String title = sc.nextLine();
        System.out.print("> 저자 : ");
        String author = sc.nextLine();
        return new Book(no, category, title, author);
    }

    private String rndBookNum() {
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();
        for(int i = 0; i < 6; i++)
            if(rnd.nextInt(2) == 1)
                sb.append(rnd.nextInt(10)); // 0 ~ 9사이의 임의수 1
            else
                sb.append((char) (rnd.nextInt(26) + 'A')); // A ~ Z
        return sb.toString();
    }

    public void menu() {
        String menu = """
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

        while(true) {
            System.out.print(menu);
            String choice = sc.next();
            System.out.println();
            switch(choice) {
                case "1": bookListManager.addBook(inputBook()); break;
                case "2":
                    bookListManager.printBookList(bookListManager.sortedBookListByNo());
                    break;
                case "3":
                    bookListManager.printBookList(bookListManager.sortedBookListByCategory());
                    break;
                case "4":
                    bookListManager.deleteBook(bookListManager.searchBook(inputBookTitle()));
                    break;
                case "5":
                    bookListManager.printBook(bookListManager.searchBook(inputBookTitle()));
                    break;
                case "6": bookListManager.printAll(); break;
                case "0": return;
                default: System.out.println("잘못 입력하셨습니다."); break;
            }
            System.out.println();
        }
    }
}
