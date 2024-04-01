package com.ssg.collections.list.book.controller;

import com.ssg.collections.list.book.model.compare.BookCategoryAsc;
import com.ssg.collections.list.book.model.vo.Book;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookListManager {
    private List<Book> bookList;

    public BookListManager() {
        bookList = new ArrayList<>();
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
        for (Book book : bookList) {
            if (book.getTitle().equals(title)) {
                return bookList.indexOf(book);
            }
        }

        return -1;
    }

    public void printBook(int index) {
        System.out.println(bookList.get(index));
    }

    public void printAll() {
        System.out.println(bookList);
    }

    public List<Book> sortedBookListByNo() {
        List<Book> result =new ArrayList<>(bookList);
        result.sort(Comparator.comparing(Book::getNo));
        return result;
    }

    public List<Book> sortedBookListByCategory() {
        List<Book> result =new ArrayList<>(bookList);
        result.sort(new BookCategoryAsc());
        return result;
    }

    public void printBookList(List<Book> books) {
        System.out.println(books);
    }
}
