package com.ssg.collections.list.book.controller;


import com.ssg.collections.list.book.model.compare.BookCategoryAsc;
import com.ssg.collections.list.book.model.vo.Book;

import java.util.*;

public class BookListManager {
    private List<Book> bookList = new ArrayList<>();

    {
        bookList.add(new Book("A3B2C1", 2, "나미야 잡화점의 기적", "히가시노 게이고"));
        bookList.add(new Book("35LK23", 3, "파리의 아파트", "기욤 뮈소"));
        bookList.add(new Book("DS25KZ", 1, "ABCDE", "도레미"));
        bookList.add(new Book("K0DR0S", 2, "미중전쟁", "김진명"));
        bookList.add(new Book("5KOSR3", 1, "JAVA 삽질하기", "김동현"));
    }
    public void addBook(Book book) {
        bookList.add(book);
    }

    public void deleteBook(int index) {
        if(index != -1) {
            bookList.remove(index);
        }
        else{
            System.out.println("삭제를 실패했습니다. 다시 시도해주세요.");
        }
    }

    public int searchBook(String title) {
        for(int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            if(title.equals(book.getTitle())) {
                return i;
            }
        }
        return -1;
    }

    public void printBook(int index) {
        System.out.println(bookList.get(index));
    }

    public void printAll() {
        for(int i = 0; i < bookList.size(); i++) {
            System.out.println(bookList.get(i));
        }
    }

    public List<Book> sortedBookListByNo() {
        List<Book> newBook = new ArrayList<>(bookList);
        Collections.sort(newBook, (Book o1, Book o2) -> o1.getNo().compareTo(o2.getNo()));
        return newBook;
    }

    public List<Book> sortedBookListByCategory() {
        List<Book> newBook = new ArrayList<>(bookList);
        Collections.sort(newBook, new BookCategoryAsc());
        return newBook;
    }

    public void printBookList(List<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
