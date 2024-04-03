package com.ssg.collections.map.book;

import com.ssg.collections.list.book.model.vo.Book;
import com.ssg.collections.map.book.controller.BookMapManager;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class TestBookManager {
    BookMapManager bookMapManager = new BookMapManager();
    Scanner sc = new Scanner(System.in);

    public void main() {
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
                메뉴선택 :
                """;
        boolean loop = true;
        while (loop) {
            System.out.println(menu);
            String selected = sc.next();
            switch (selected) {
                case "1":
                    bookMapManager.addBook(inputBook());
                    break;
                case "2":
                    System.out.println(bookMapManager.sortedBookListByNo());
                    break;
                case "3":
                    System.out.println(bookMapManager.sortedBookListByCategory());
                    break;
                case "4":
                    System.out.print("삭제할 ");
                    String index = bookMapManager.searchBook(inputBookTitle());
                    if (index == null) {
                        System.out.println("삭제 대상이 없습니다!");
                    }
                    bookMapManager.deleteBook(index);
                    break;
                case "5":
                    System.out.print("검색할 ");
                    String index2 = bookMapManager.searchBook(inputBookTitle());
                    if (index2 == null) {
                        System.out.println("검색 대상이 없습니다!");
                    }
                    bookMapManager.printBook(index2);
                    break;
                case "6":
                    bookMapManager.printAll();
                    break;
                case "0":
                    loop = false;
                    break;
                default:
                    System.out.println("잘못된 입력값입니다.");
            }
        }
    }

    public String inputBookTitle() {
        System.out.println("도서명을 입력하세요 : ");
        sc.nextLine();
        String title = sc.nextLine();
        return title;
    }

    public Book inputBook() {
        String no = generateNo();
        System.out.print("도서분류코드 (1.인문/2.자연과학/3.의료/4.기타) : ");
        int category = sc.nextInt();
        sc.nextLine();
        System.out.println("책 제목 : ");
        String title = sc.nextLine();
        System.out.println("책 저자 : ");
        String author = sc.nextLine();
        Book book = new Book(no, category, title, author);
        return book;
    }

    public String generateNo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            Random random = new Random();
            if (random.nextBoolean()) {
                stringBuilder.append(random.nextInt(10) + 0);
            } else {
                stringBuilder.append((char)(random.nextInt(26) + 'A'));
            }
        }
        return stringBuilder.toString();
    }
}
