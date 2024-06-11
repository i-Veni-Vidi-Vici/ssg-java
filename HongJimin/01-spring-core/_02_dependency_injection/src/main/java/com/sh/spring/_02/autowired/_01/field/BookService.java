package com.sh.spring._02.autowired._01.field;

import com.sh.spring.common.book.BookDao;
import com.sh.spring.common.book.BookDaoImpl;
import com.sh.spring.common.book.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Component의 후손 어노테이션이므로, @ComponentScan에 의해서 자동으로 빈 등록 됨
 */
@Service("bookServiceByField")
public class BookService {
    @Autowired // 받으려고 하는 것도 Bean이어야 함 - 인터페이스를 객체화할 수 없기 때문에 구현 클래스에 가서 Component를 붙혀주고, Dao역할도 할 수 있게 하기 ->
    private BookDao bookDao;

    public List<BookDto> findAll() {
        return bookDao.findAll();
    }

    public BookDto findById(Long id) {
        return bookDao.findById(id);
    }
}
