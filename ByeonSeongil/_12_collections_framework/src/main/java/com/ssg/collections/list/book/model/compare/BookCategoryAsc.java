package com.ssg.collections.list.book.model.compare;

import com.ssg.collections.list.book.model.vo.Book;
import java.util.Comparator;

public class BookCategoryAsc implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.getCategory() - o2.getCategory();
    }
}
