package com.sh.spring.common.book;

import java.util.List;

public interface BookDao {
    List<BookDto> findAll();
    BookDto findById(Long id); // 한 건 조회
}
