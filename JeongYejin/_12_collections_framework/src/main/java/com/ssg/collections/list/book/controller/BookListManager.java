package com.ssg.collections.list.book.controller;

import com.ssg.collections.list.book.model.compare.BookCategoryAsc;
import com.ssg.collections.list.book.model.vo.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookListManager {
    List<Book> bookList = new ArrayList<>();

    public BookListManager() {
    }

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
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public List<Book> sortedBookListByNo() {
        List<Book> sortedByNo = bookList;
        Comparator<Book> sortByNo = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getNo().compareTo(o2.getNo());
            }
        };
        Collections.sort(sortedByNo, sortByNo);
        return sortedByNo;
    }
    // List has a Comparator interface

    public List<Book> sortedBookListByCategory() {
        List<Book> sortedByCategory = bookList;
        BookCategoryAsc bookCategoryAsc = new BookCategoryAsc();
        Collections.sort(sortedByCategory, bookCategoryAsc);
        return sortedByCategory;
    }

    public void printBookList(List<Book> books) {
        System.out.println(books);
//        for (Book book : books) {
//            System.out.println(book);
//        }
    }
}
