package com.sh.spring._02.autowired._01.field;

import com.sh.spring.common.book.BookDao;
import com.sh.spring.common.book.BookDaoImpl;
import com.sh.spring.common.book.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Component의 후손 어노테이션이므로, @ComponentScan에 의해서 자동 빈 동록
 */
@Service("bookServiceByField")
public class BookService {
    @Autowired // 의존주입 받고 싶어
    private BookDao bookDao; // 실제 얘는 인터페이스지만 빈 등록을 해야 하니까 Impl에 해줘야 한다.

    public List<BookDto> findAll() {
        return bookDao.findAll();
    }

    public BookDto findById(Long id) {
        return bookDao.findById(id);
    }
}
