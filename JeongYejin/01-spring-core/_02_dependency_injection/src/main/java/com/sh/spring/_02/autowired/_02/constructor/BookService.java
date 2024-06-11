package com.sh.spring._02.autowired._02.constructor;

import com.sh.spring.common.book.BookDao;
import com.sh.spring.common.book.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * Spring 4.3 버전 이후로는 생성자가 한 개 뿐이라면 @Autowired 어노테이션을 생략해도 자동으로 생성자 주입이 동작한다.
 * 단, 생성자가 1개 이상일 경우에는 명시적으로 작성을 해주어야 한다.
 * </p>
 * <pre>
 * 생성자 주입의 장점
 * - 객체가 생성 될 때 모든 의존성이 주입 되므로 의존성을 보장할 수 있다.
 *     - `순환 참조` 에 대해 필드 주입/세터 주입은 메소드 실행 시점에 오류가 발생한다.
 *     - 생성자 주입은 어플리케이션 실행 시점에 오류가 발생한다.
 * - 객체의 불변성을 보장할 수 있다. => (private이고 setter가 없으면 절대 바뀔 수 없다.)
 *     - 필드에 `final` 사용 가능하고 객체 생성 이후 의존성을 변경할 수 없어 안정성이 보장 된다.
 * - 코드 가독성이 좋다.
 *     - 해당 객체가 어떤 의존성을 가지고 있는지 명확히 알 수 있다.
 * - DI 컨테이너와의 결합도가 낮기 때문에 테스트 하기 좋다.
 *     - 스프링 컨테이너 없이 테스트를 할 수 있다.
 * </pre>
 *
 */

@Service("bookServiceByConstructor")
public class BookService {

    private final BookDao bookDao; // 의존주입 받아야 하는 애한테 final을 붙여버려
    // 기본 생성자를 쓰면 오류가 나지

//    @Autowired // 생성자가 하나뿐이라면 생략 가능하다
    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    } // 생성자가 호출할 때 의존 주입됨

    public List<BookDto> findAll() {
        return bookDao.findAll();
    } // bookDao가 비어있으면 안돼! -> "의존"한다!

    public BookDto findById(Long id) {
        return bookDao.findById(id);
    }
}
