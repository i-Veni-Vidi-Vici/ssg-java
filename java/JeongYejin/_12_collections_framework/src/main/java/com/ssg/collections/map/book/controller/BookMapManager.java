package com.ssg.collections.map.book.controller;

import com.ssg.collections.list.book.controller.BookListManager;
import com.ssg.collections.list.book.model.compare.BookCategoryAsc;
import com.ssg.collections.list.book.model.vo.Book;

import java.security.Key;
import java.util.*;

public class BookMapManager {
//    private HashMap<String, Book> bookMap;
    private Map<String, Book> bookMap = new HashMap<>();

    {
        bookMap.put("A3B2C1", new Book("A3B2C1", 2, "나미야 잡화점의 기적", "히가시노 게이고"));
        bookMap.put("35LK23", new Book("35LK23", 3, "파리의 아파트", "기욤 뮈소"));
        bookMap.put("DS25KZ", new Book("DS25KZ", 1, "ABCDE", "도레미"));
        bookMap.put("K0DR0S", new Book("K0DR0S", 2, "미중전쟁", "김진명"));
        bookMap.put("5KOSR3", new Book("5KOSR3", 1, "JAVA 삽질하기", "김동현"));
    }

    public BookMapManager() {
    }

    public BookMapManager(HashMap<String, Book> bookMap) {
        this.bookMap = bookMap;
    }

    /*
    private String no;
    private int category;
    private String title;
    private String author;
     */

    public void addBook(Book book) {
        bookMap.put(book.getNo(), book);
    }

    public void deleteBook(String key) {
        if (bookMap.containsKey(key)) {
            Book removed = bookMap.remove(key);
            System.out.println(removed.getTitle());
        } else {
            System.out.println("해당 도서가 존재하지 않습니다.");
        }
    }

    public String searchBook(String title) {
        Set<String> keySet = bookMap.keySet();
        for (String key : keySet) {
            if (bookMap.get(key).getTitle().equals(title)) {
                return bookMap.get(key).getNo();
            }
        }
        return null;
    }

    public void printBook(String key) {
        if (bookMap.containsKey(key))
            System.out.println(bookMap.get(key));
        else
            System.out.println("해당 도서가 존재하지 않습니다.");
    }

    public void printAll() {
        Set<String> keySet = bookMap.keySet();
        for (String key : keySet) {
            System.out.println(bookMap.get(key));
        }
    }

    public void printBookMap(List<Book> list) {
        for (Book book : list) {
            System.out.println(book);
        }
    }
    public List<Book> sortedBookListByNo() {
        ArrayList<Book> bookList = new ArrayList<>(bookMap.values());
        // 만약 리스트의 데이터 오브젝트가 Comparable을 implements한 오브젝트라면 null값을 입력해 오름차순으로 정렬할 수 있다.
        // Comparator 자리에 null이 들어오면 기본 정렬 기준을 따른다.
        bookList.sort(null);
        return bookList;
    }

    public void printBookList(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public List<Book> sortedBookListByCategory() {
        ArrayList<Book> bookList = new ArrayList<>(bookMap.values());
        bookList.sort(new BookCategoryAsc());
        return bookList;
    }

}
