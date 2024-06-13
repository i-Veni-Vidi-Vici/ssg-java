package com.sh.spring.common.book;

import java.util.List;

// 인터페이스에는 Con이나 Service같은 어노테이션을 붙히지 않는다.
public interface BookDao {
    List<BookDto> findAll();
    BookDto findById(Long id);
}
