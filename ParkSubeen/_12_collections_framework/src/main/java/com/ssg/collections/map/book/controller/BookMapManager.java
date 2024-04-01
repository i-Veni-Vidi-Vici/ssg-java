package com.ssg.collections.map.book.controller;

import com.ssg.collections.list.book.model.compare.BookCategoryAsc;
import com.ssg.collections.list.book.model.vo.Book;

import java.util.*;

public class BookMapManager {
    Map<String, Book> bookMap = new HashMap<String, Book>();

    {
        bookMap.put("A3B2C1", new Book("A3B2C1", 2, "나미야 잡화점의 기적", "히가시노 게이고"));
        bookMap.put("35LK23", new Book("35LK23", 3, "파리의 아파트", "기욤 뮈소"));
        bookMap.put("DS25KZ", new Book("DS25KZ", 1, "ABCDE", "도레미"));
        bookMap.put("K0DR0S", new Book("K0DR0S", 2, "미중전쟁", "김진명"));
        bookMap.put("5KOSR3", new Book("5KOSR3", 1, "JAVA 삽질하기", "김동현"));
    }

    public void addBook(Book book) {
        bookMap.put(book.getNo(), book);
    }

    public void deleteBook(String key) {
        bookMap.remove(key);
        System.out.println("삭제 완료!");
    }

    public String searchBook(String title) {
        Set<String> keyset = bookMap.keySet();
        Iterator<String> iter = keyset.iterator();
        int i = 0;
        while(iter.hasNext()) {
            String key = iter.next();
            Book book = bookMap.get(key);
            if(book.getTitle().equals(title)) {
                return book.getNo();
            }
        }
        return null;
    }

    public void printAll() {
        for(Book book : bookMap.values()) {
            System.out.println(book);
        }
    }

    public void printBookMap(List<Book> list) {
//        System.out.println("printBookMap list : " + list);
        for(Book book : list) {
            System.out.println(book);
        }
    }

    public void printBook(String key) {
        System.out.println("검색한 도서 : " + bookMap.get(key));
    }

    public List<Book> sortedBookListByNo() {
//        System.out.println("sortedBookListByNo bookMap.values : " + bookMap.values());
        List<Book> bookList = new ArrayList<>(bookMap.values());
        Collections.sort(bookList, (Book o1, Book o2) -> o1.getNo().compareTo(o2.getNo()));
        return bookList;
    }

    public List<Book> sortedBookListByCategory() {
        //        System.out.println("sortedBookListByCategory bookMap.values : " + bookMap.values());
        List<Book> bookList = new ArrayList<>(bookMap.values());
        Collections.sort(bookList, new BookCategoryAsc());
        return bookList;
    }
}
