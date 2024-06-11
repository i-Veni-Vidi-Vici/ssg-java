package com.sh.spring.common.book;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Component의 후손 어노테이션이므로, @ComponentScan에 의해서 자동으로 빈 등록
 * - 이 빈은 부모 BookDao타입으로 DI가능하다. - BookService에 줄20번
 */
@Repository("bookDao") // bean으로 등록해달라는 annotation
public class BookDaoImpl implements BookDao { // BookDao의 구현클래스
    Map<Long, BookDto> bookMap;

    public BookDaoImpl() {
        this.bookMap = new HashMap<>();
        this.bookMap.put(1L, new BookDto(1L, 123456789, "자바의 정석", "남궁 성", "도우출판", LocalDate.of(1999, 9, 9)));
        this.bookMap.put(2L, new BookDto(2L, 342342342, "칭찬은 고래도 춤추게 한다", "고래", "고래출판", LocalDate.of(2005, 5, 5)));
    }

    @Override
    public List<BookDto> findAll() {
        return new ArrayList<>(this.bookMap.values());
    }

    @Override
    public BookDto findById(Long id) {
        return this.bookMap.get(id);
    }
}
