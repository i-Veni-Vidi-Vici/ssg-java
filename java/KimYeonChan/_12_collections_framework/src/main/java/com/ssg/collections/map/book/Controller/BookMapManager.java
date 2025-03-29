package com.ssg.collections.map.book.Controller;

import com.ssg.collections.list.book.model.compare.BookCategoryAsc;
import com.ssg.collections.list.book.model.vo.Book;

import java.util.*;

public class BookMapManager {
    private Map<String, Book> bookMap = new HashMap<>();

    public BookMapManager() {}

    public BookMapManager(Map<String, Book> bookMap) {
        this.bookMap = bookMap;
    }

    public void addBook(Book book) {
        bookMap.put(book.getNo(), book);
    }

    public void deleteBook(String key) {
        bookMap.remove(key);
    }

    public String searchBook(String title) {
        for (Book book : bookMap.values()) {
            if (book.getTitle().equals(title)) {
                return book.getNo();
            }
        }
        return null;
    }

    public void printBook(String key) {
        System.out.println(bookMap.get(key));
    }

    public void printAll() {
        for (Book book : bookMap.values()) {
            System.out.println(book);
        }
    }

    public void printBookMap(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public List<Book> sortedBookListByNo() {
        List<Book> bookList = new ArrayList<>(bookMap.values());
        bookList.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getNo().compareTo(o2.getNo());
            }
        });
        return bookList;
    }

    public List<Book> sortedBookListByCategory() {
        List<Book> bookList = new ArrayList<>(bookMap.values());
        bookList.sort(new BookCategoryAsc());
        return bookList;
    }
}
