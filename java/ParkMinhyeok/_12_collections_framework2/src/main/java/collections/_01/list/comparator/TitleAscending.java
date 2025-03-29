package collections._01.list.comparator;

import collections._01.list.Book;

import java.util.Comparator;

public class TitleAscending implements Comparator<Book> {
    /**
     * 양수(자리교환)
     * 0
     * 음수
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(Book o1, Book o2) {

        return o1.getTitle().compareTo(o2.getTitle());
    }
}
