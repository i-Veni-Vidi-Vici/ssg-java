package com.sh.spring.common.book;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Component의 후손 어노테이션이므로, @ComponentScan에 의해서 자동으로 빈 등록
 */
@Repository("bookDao")
public class BookDaoimpl implements BookDao{
    Map<Long, BookDto> bookMap;

    public BookDaoimpl() {
        this.bookMap = new HashMap<>();
        this.bookMap.put(1L, new BookDto(1L, 123456789, "자바의 정석", "남궁 성", "도우출판", LocalDate.of(1999,9,9)));
        this.bookMap.put(2L, new BookDto(2L, 987654321, "세이노의 가르침", "몰루", "빛과어둠", LocalDate.of(2000, 5, 5)));
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
