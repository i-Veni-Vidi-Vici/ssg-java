package com.sh.greedy.level02.normal.book.run;
import com.sh.greedy.level02.normal.book.model.dto.BookDTO;

import java.awt.print.Book;

public class Application {
    public static void main(String[] args) {
        BookDTO book1 = new BookDTO();
        book1.printInformation();

        BookDTO book2 = new BookDTO("넛지", "믿음사", "리처드 세일러");
        book2.printInformation();;

        BookDTO book3 = new BookDTO("세이노의 가르침","데이 원" ,"세이노" ,6480, 10);
        book3.printInformation();
    }
}
