package com.sh.spring._02._autowired._01.field;

import com.sh.spring.common.book.BookDao;
import com.sh.spring.common.book.BookDaoImpl;
import com.sh.spring.common.book.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;



 @Service("bookServiceByField")
public class BookService {

    @Autowired //BookDao는 인터페이스이므로 component하면 안된다.
    private BookDao bookDao;

    public List<BookDto> findAll(){
        return bookDao.findAll();
    }

    public BookDto findById(Long id){
        return bookDao.findById(id);
    }
}
