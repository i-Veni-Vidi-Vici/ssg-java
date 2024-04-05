package com.ssg.collections.list.book.controller;

import com.ssg.collections.list.book.model.compare.BookCategoryAsc;
import com.ssg.collections.list.book.model.vo.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookListManager {
    private List<Book> bookList = new ArrayList<>();

    // 기본생성자 : bookList 객체 생성함
    public BookListManager() {
        bookList.add(new Book("A3B2C1", 2, "나미야 잡화점의 기적", "히가시노 게이고"));
        bookList.add(new Book("35LK23", 3, "파리의 아파트", "기욤 뮈소"));
        bookList.add(new Book("DS25KZ", 1, "ABCDE", "도레미"));
        bookList.add(new Book("K0DR0S", 2, "미중전쟁", "김진명"));
        bookList.add(new Book("5KOSR3", 1, "JAVA 삽질하기", "김동현"));
    }

    // 매개변수있는 생성자 : 다른 리스트를 전달받아, bookList 객체의 초기값으로 사용함
    public BookListManager(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    // 리스트에 객체 추가
    public void addBook(Book book) {
        bookList.add(book);
        System.out.println("> 새 도서를 추가했습니다.");
    }

    // 리스트에서 객체 제거
    public void deleteBook(int index) {
        if(index > -1) {
            bookList.remove(index);
            System.out.println("> 도서를 삭제했습니다.");
        }
        else
            System.out.println("> 도서를 삭제하지 못 했습니다. 도서명을 잘못 입력하셨습니다.");
    }

    // 도서명이 일치하는 객체를 찾아 해당 인덱스를 리턴
    // 도서명이 일치하는 객체가 리스트에 없으면, -1 리턴함
    public int searchBook(String title) {
        for(int i=0; i<bookList.size(); i++) {
            if(title.equals(bookList.get(i).getTitle()))
                return i;
        }
        return -1;
    }

    // 인덱스 위치의 객체의 정보를 출력함
    public void printBook(int index) {
        if(index > -1) {
            System.out.println("> 도서를 검색했습니다.");
            System.out.println("index[" + index + "] : " + bookList.get(index));
        }
        else
            System.out.println("> 도서를 검색하지 못 했습니다. 도서명을 잘못 입력하셨습니다.");
    }

    // 목록정보 모두 출력
    public void printAll() {
        System.out.println("BookList=" + bookList);
    }

    // 원본 List를 변경하지 않고 별도의 List<Book> 새로 생성후 정렬
    // 기본정렬(번호 오름차순) 후 반환
    public List<Book> sortedBookListByNo() {
        List<Book> bookList1 = new ArrayList<>(bookList);
        Comparator<Book> bookNoAscComparator = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getNo().compareTo(o2.getNo());
            }
        };
        Collections.sort(bookList1, bookNoAscComparator);
        return bookList1;
    }

    // 원본 List를 변경하지 않고 별도의 List<Book> 새로 생성후 정렬
    // 카테고리 오름차순 정렬후 반환
    public List<Book> sortedBookListByCategory() {
        List<Book> bookList1 = new ArrayList<>(bookList);
        Collections.sort(bookList1, new BookCategoryAsc());
        return bookList1;
    }

    // 전달한 books 출력
    public void printBookList(List<Book> books) {
        System.out.println("BookList=" + books);
    }
}
