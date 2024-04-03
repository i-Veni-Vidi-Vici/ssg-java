package com.ssg.collections.list.book.model.compare;

import com.ssg.collections.list.book.model.vo.Book;

import java.util.Comparator;

public class BookCategoryAsc implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Book book1 = (Book) o1;
        Book book2 = (Book) o2;
        return book1.getCategory() - book2.getCategory();
    }
}
