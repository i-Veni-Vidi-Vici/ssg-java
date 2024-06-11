package com.sh.spring._02.autowired._03.setter;

import com.sh.spring.common.book.BookDao;
import com.sh.spring.common.book.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Component의 후손 어노테이션이므로, @ComponentScan에 의해서 자동으로 @Bean 등록이 된다
 */

@Service("bookServiceBySetter")
public class BookService {


    private BookDao bookDao;

    @Autowired
    public void setBookDao(BookDao bookDao){
        this.bookDao=bookDao;
    }

    public List<BookDto> findAll() {
        return bookDao.findAll();
    }

    public BookDto findById(Long id) {
        return bookDao.findById(id);
    }
}
