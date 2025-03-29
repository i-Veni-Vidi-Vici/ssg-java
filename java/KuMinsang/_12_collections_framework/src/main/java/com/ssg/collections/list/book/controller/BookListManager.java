package com.ssg.collections.list.book.controller;

import com.ssg.collections.list.book.model.compare.BookCategoryAsc;
import com.ssg.collections.list.book.model.vo.Book;

import java.util.*;

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
        Iterator<Book> iterator = booklist.iterator();
        int index = -1;
        Book tmpBook;
        while(iterator.hasNext()){
            tmpBook = iterator.next();
            index++;
            if(tmpBook.getTitle().equals(title))
                return index;
        }
        return index;
    }

    //인덱스 위치의 객체 정보를 출력
    public void printBook(int index) {
        System.out.println("요청하신 도서 정보입니다 : " + booklist.get(index));
    }

    //목록 정보 모두 출력
    public void printAll() {
        System.out.println("""
                ==========================
                모든 도서 목록 출력
                ==========================
                도서번호  분류코드  제목  저자""");
        for(Book iterBook : booklist){
            System.out.println(iterBook.getNo() +"    "+ iterBook.getCategory()+"    "+iterBook.getTitle()+ " "+ iterBook.getAuthor() );
        }
    }

    //원본 List를 변경하지 않고 별도의 List<Book> 새로 생성후 정렬
    //기본 정렬 (번호 오름차순) 후 반환
    public List<Book> sortedBookListByNo() {
        List<Book> otherBook = new ArrayList<Book>(this.booklist);
        /*
        Comparator<Book> comparator = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getNo().compareTo(o2.getNo());
            }
        };  //메소드 내에서 comparator를 재정의

        Collections.sort(otherBook, comparator);
         */
        Collections.sort(otherBook, new Comparator<Book>(){
            @Override
            public int compare(Book o1, Book o2){
                return Integer.parseInt(o1.getNo()) - Integer.parseInt(o2.getNo());
            }
        });
        return otherBook;
    }

    public List<Book> sortedBookListByCategory() {
        List<Book> sortedBook = new ArrayList<>(this.booklist);
        Collections.sort(sortedBook, new BookCategoryAsc());
        return sortedBook;
    }

    public void printBookList(List<Book> books) {
        System.out.println("""
                ==========================
                도서번호  분류코드  제목  저자""");
        for(Book iterBook : books){
            System.out.println(iterBook.getNo() +"    "+ iterBook.getCategory()+"    "+iterBook.getTitle()+ " "+ iterBook.getAuthor());
        }
        System.out.println();
    }

}
