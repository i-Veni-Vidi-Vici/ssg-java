package com.sh.spring.common.book;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDaoImpl implements BookDao{
    private Map<Long, BookDto> bookMap;

    public BookDaoImpl() {
        this.bookMap = new HashMap<>();
        this.bookMap.put(1L, new BookDto(1L, 123456789, "자바의 정석", "남궁 성", "도우출판", LocalDate.of(1999, 9, 9)));
    }

    @Override
    public List<BookDto> findAll() {
        return List.of();
    }

    @Override
    public BookDto findById(Long id) {
        return null;
    }
}
