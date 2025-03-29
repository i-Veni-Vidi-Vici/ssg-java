package com.sh.spring._02.autowired._01.fileld;

import com.sh.spring.common.book.BookDao;
import com.sh.spring.common.book.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceByField")
public class BookService {
//    private BookDao bookDao = new BookDaoImpl(); // 이걸 안함 어플리케이션컨덱스트에서 BookDao빈을 관리 함. 그래서 필요할때 넣어주는거임.
    // 근데 방법이 3가지 임.

    @Autowired
    private BookDao bookDao;

    public List<BookDto> findAll() {
        return bookDao.findAll();
    }
    public BookDto findById(Long id) {
        return bookDao.findById(id);
    }


}
