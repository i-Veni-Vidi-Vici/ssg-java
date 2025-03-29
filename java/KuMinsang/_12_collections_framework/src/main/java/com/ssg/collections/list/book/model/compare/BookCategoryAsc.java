package com.ssg.collections.list.book.model.compare;
import com.ssg.collections.list.book.model.vo.Book;

import java.util.Comparator;
public class BookCategoryAsc implements Comparator{
    //compare 메소드는 Object1과 Object2를 비교한다
    // 양수를 반환하면 Object1이 더 크다고 판단
    // 음수를 반환하면 Object2가 더 크다고 판단
    // 0을 반환하면 같은 값으로 판단한다
    // 기본 동작은 오름차순이며 출력 값을 반전하면 내림차순이 된다
    @Override
    public int compare(Object o1, Object o2) {
        Book book1 = (Book) o1;
        Book book2 = (Book) o2;
        // (Book) o1.getAuthor()
        // 이 코드가 안되는 이유
        // 캐스팅 연산보다 메소드 호출의 우선순위가 높기 떄문이다.
        // (Book) (o1.getAuthor())와도 같은것이다
        // 코드를 다음과 수정하면 동작한ㄷ
        // (Book o1).getAuthor
            return book1.getCategory() - book2.getCategory();
    }
}
