package com.sh.spring._02.autowired._02.constructor;

import com.sh.spring.common.book.BookDao;
import com.sh.spring.common.book.BookDaoImpl;
import com.sh.spring.common.book.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceByConstructor")
public class BookService {
//    private BookDao bookDao = new BookDaoImpl(); // 이걸 안함 어플리케이션컨덱스트에서 BookDao빈을 관리 함. 그래서 필요할때 넣어주는거임.
    // 근데 방법이 3가지 임.

//    @Autowired 여기에 있떤거 -> 자동연결임.
    private final BookDao bookDao; // 북서비스는 북디에이오에 의존 합니다 이거 없으면(null)이면 메소드 실행 못해요


//    @Autowired // 생성자에 붙이세요 BookDao bookDao 이거 필요하잖아 여기다가 DI 해줄게 // 객체 만듦과 동시에 호출해줌
    // 생성자 호출할 때 의존 객체가 들어옵니다.
    // BookDao 객체가 먼저 만들고 BookServive 객체 그 다음 만듦.
    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public List<BookDto> findAll() {
        return bookDao.findAll();
    }
    public BookDto findById(Long id) {
        return bookDao.findById(id);
    }


}
