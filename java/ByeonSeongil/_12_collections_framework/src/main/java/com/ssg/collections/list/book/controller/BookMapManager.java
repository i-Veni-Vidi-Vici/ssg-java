package com.ssg.collections.list.book.controller;

import com.ssg.collections.list.book.model.compare.BookCategoryAsc;
import com.ssg.collections.list.book.model.vo.Book;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookMapManager {
    private Map<String, Book> bookMap;

    public BookMapManager() {
        bookMap = new HashMap<>();
    }

    public BookMapManager(Map<String, Book> bookMap) {
        this.bookMap = bookMap;
    }

    public void addBook(Book book) {
        bookMap.put(book.getNo(),book);
    }

    public void deleteBook(String key) {
        bookMap.remove(key);
    }

    public String searchBook(String title) {
        for (String s : bookMap.keySet()) {
            if (bookMap.get(s).getTitle().equals(title)) {
                return s;
            }
        }

        return null;
    }

    public void printBookMap(List<Book> books) {
        System.out.println(books);
    }

    public void printAll() {
        System.out.println(bookMap);
    }

    public void printBook(String key) {
        System.out.println(bookMap.get(key));
    }

    public List<Book> sortedBookListByNo() {
        List<Book> result =new ArrayList<>(bookMap.values());
        result.sort(Comparator.comparing(Book::getNo));
        return result;
    }

    public List<Book> sortedBookListByCategory() {
        List<Book> result =new ArrayList<>(bookMap.values());
        result.sort(new BookCategoryAsc());
        return result;
    }

}
