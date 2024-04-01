package com.ssg.collections.list.book.run;

import com.ssg.collections.list.book.controller.BookListManager;
import com.ssg.collections.list.book.model.vo.Book;

import java.util.Scanner;

public class TestBookManager {
    private static BookListManager manager;
    private static Scanner sc;
    public static void main(String[] args) {
        TestBookManager testBookManager = new TestBookManager();
        manager = new BookListManager();

        sc = new Scanner(System.in);
        manager.addBook(new Book("1", 1, "김춘추와연회", "박진"));
        manager.addBook(new Book("10", 3, "장수왕의복수", "핫하"));
        manager.addBook(new Book("6", 2, "고이왕의선택", "멍멍"));
        manager.addBook(new Book("8", 4, "장보고의대검", "애옹"));
        int choose;
        boolean flag = true;
        while(flag){
            testBookManager.menu();
            int index=-1;
            choose = sc.nextInt();
            switch (choose){
                case 1 :
//                1. 새 도서 추가
                    manager.addBook(testBookManager.inputBook());
                    break;
                case 2 :
//                2. 도서정보 출력(책번호 오름차순)
                    System.out.println("도서정보를 번호 오름차순으로 출력");
                    manager.printBookList(manager.sortedBookListByNo());
                    break;
                case 3 :
//                3. 도서정보 출력(카테고리 오름차순)
                    System.out.println("도서정보를 카테고리 오름차순 출력");
                    manager.printBookList(manager.sortedBookListByCategory());
                    break;
                case 4 :
//                4. 도서 삭제
                    System.out.print("삭제할 도서 이름을 입력하세요 : ");
                    index = Integer.parseInt(testBookManager.inputBookTitle());
                    if(index>=0)
                        manager.deleteBook(index);
                    break;
                case 5 :
//                5. 도서 검색출력
                    System.out.println("검색할 도서명을 입력하세요");
                    index = Integer.parseInt(testBookManager.inputBookTitle());
                    if(index>=0)
                        manager.printBook(index);
                    break;
                case 6 :
//                6. 전체 출력
                    manager.printAll();
                    break;
                default :
                    flag =false;
//                0. 끝내기
            }

        }
    }

    public String inputBookTitle(){
        //Index를 리턴한다
        String title = sc.next();
        int index = manager.searchBook(title);
//        sc.close();
        return Integer.toString(index);
    }

    public Book inputBook(){
        Book tmpBook = new Book();
        System.out.println("새로운 도서를 추가합니다.");
        System.out.println("도서 정보를 입력하세요.");
        System.out.print("도서번호 : ");
        tmpBook.setNo(sc.next());
        System.out.print("도서분류코드(1.인문 / 2.자연과학 / 3.의료 / 4. 기타 : ");
        tmpBook.setCategory(sc.nextInt());
        System.out.print("책 제목 : ");
        tmpBook.setTitle(sc.next());
        System.out.print("저자 : ");
        tmpBook.setAuthor(sc.next());
//        sc.close();
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
