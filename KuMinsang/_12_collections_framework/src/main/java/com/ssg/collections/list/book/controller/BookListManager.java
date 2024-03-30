package com.ssg.collections.list.book.controller;

import com.ssg.collections.list.book.model.vo.Book;

import java.util.ArrayList;
import java.util.List;

public class BookListManager {
    ArrayList<Book> booklist;
    public BookListManager() {
        booklist = new ArrayList<Book>();
    }

    public BookListManager(ArrayList<Book> booklist) {
        this.booklist = new ArrayList<>(booklist);
    }

    //리스트에 객체 추가
    public void addBook(Book book) {
        if(book != null)
            booklist.add(book);
    }

    //리스트에서 객체 제거
    public void deleteBook(int index) {
        if(index >=0)
            booklist.remove(index);
    }

    //도서명이 일치하는 객체를 찾아 해당 인덱스를 리턴
    //도서명이 일치하는 객체가 없으면, -1 리턴
    public int searchBook(String title) {
        booklist.
        return 0;
    }

    //인덱스 위치의 객체 정보를 출력
    public void printBook(int index) {

    }

    //목록 정보 모두 출력
    public void printAll() {

    }

    //원본 List를 변경하지 않고 별도의 List<Book> 새로 생성후 정렬
    //기본 정렬 (번호 오름차순) 후 반환
    public void sortedBookListByNo() {

    }

    public List<Book> sortedBookListByCategory() {

    }

    public void printBookList(List<Book> books) {

    }

}
