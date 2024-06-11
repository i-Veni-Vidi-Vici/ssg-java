package com.sh.spring._02.autowired._01.field;

import com.sh.spring.common.book.BookDao;
import com.sh.spring.common.book.BookDaoImpl;
import com.sh.spring.common.book.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Component이 후손 어노테이션이므로, @ComponentScan에 의해서 자동으로 빈 등록
 */
@Service("bookServiceByField")
public class BookService {
    @Autowired
    private BookDao bookDao;

    public List<BookDto> findAll(){
        return bookDao.findAll();
    }
    public BookDto findById(Long id){
        return bookDao.findById(id);
    }
}
