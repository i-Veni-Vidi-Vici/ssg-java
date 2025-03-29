package com.ssg.collections.list.book.controller;

import com.ssg.collections.list.book.model.compare.BookCategoryAsc;
import com.ssg.collections.list.book.model.vo.Book;

import java.util.*;

public class BookListManager {
    private List<Book> bookList = new ArrayList<>();

    public BookListManager() {}

    public BookListManager(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void deleteBook(int index) {
        bookList.remove(index);
    }

    public int searchBook(String title) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getTitle().equals(title)) {
                return i;
            }
        }
        return -1;
    }

    public void printBook(int index) {
        System.out.println(bookList.get(index));
    }

    public void printAll() {
        for (int i = 0; i < bookList.size(); i++) {
            printBook(i);
        }
    }

    public List<Book> sortedBookListByNo() {
        List<Book> bookClone = new ArrayList<>(bookList);
        bookClone.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getNo().compareTo(o2.getNo());
            }
        });
        return bookClone;
    }

    public List<Book> sortedBookListByCategory() {
        List<Book> bookClone = new ArrayList<>(bookList);
        bookClone.sort(new BookCategoryAsc());
        return bookClone;
    }

    public void printBookList(List<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
