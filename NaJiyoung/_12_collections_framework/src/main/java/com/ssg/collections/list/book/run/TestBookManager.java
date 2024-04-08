package com.ssg.collections.list.book.run;

import com.ssg.collections.list.book.controller.BookListManager;
import com.ssg.collections.list.book.model.vo.Book;

import java.util.Scanner;

public class TestBookManager {
    private BookListManager manager = new BookListManager();
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        TestBookManager test = new TestBookManager();
        test.menu();
    }

    // 삭제 또는 검색을 위한 도서 타이틀을 키보드로 입력받아 리턴
    public String inputBookTitle() {
        System.out.print("> 책 제목을 입력하세요 : ");
        sc.nextLine();
        return sc.nextLine();
    }

    // Book 객체의 필드값을 키보드로 입력받아 초기화하고 객체 리턴
    public Book inputBook() {
        System.out.println("> Book 객체의 필드값을 입력하세요.");
        System.out.print("> 도서번호(no:String) : ");
        String no = sc.next();
        System.out.print("> 도서분류코드(category:int) : ");
        int category = sc.nextInt();
        System.out.print("> 책 제목(title:String) : ");
        sc.nextLine();
        String title = sc.nextLine();
        System.out.print("> 저자(author:String) : ");
        String author = sc.nextLine();
        Book book = new Book(no, category, title, author);
        return book;
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
                메뉴선택 :""";

        while(true) {
            System.out.println(menu);
            int choice = sc.nextInt();

            switch (choice) {
                case 1: // 새 도서 추가 addBook(inputBook()에서 반환받은 객체) 실행
                    manager.addBook(inputBook());
                    break;
                case 2: // 도서정보 정렬후 출력 (책번호 오름차순)
                    // - sortedBookList() 실행
                    // - List<Book> 리턴받아 `printBookList(List<Book>)` 실행
                    manager.printBookList(manager.sortedBookListByNo());
                    break;
                case 3: // 도서정보 정렬후 출력 (카테고리 오름차순)
                    // - sortedBookList() 실행
                    // - List<Book> 리턴받아 `printBookList(List<Book>)` 실행
                    manager.printBookList(manager.sortedBookListByCategory());
                    break;
                case 4: // 도서 삭제
                    // - inputBookTitle(삭제할 도서명) 실행
                    // - index를 리턴받아 deleteBook(index) 실행
                    manager.deleteBook(manager.searchBook(inputBookTitle()));
                    break;
                case 5: // 도서 검색출력
                    // - inputBookTitle(검색할 도서명) 실행
                    // - index 리턴받아 printBook(index) 실행
                    manager.printBook(manager.searchBook(inputBookTitle()));
                    break;
                case 6: // 전체 출력
                    manager.printAll();
                    break;
                case 0:
                    System.out.println("> 프로그램이 종료되었습니다.");
                    return;
                default:
                    System.out.println("> 잘못 입력하셨습니다. 다시 입력해주세요.");
                    break;
            }

            System.out.println();
        }
    }
}
