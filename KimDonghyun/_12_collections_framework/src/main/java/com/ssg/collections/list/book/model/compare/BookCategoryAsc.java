package com.ssg.collections.list.book.model.compare;

import com.ssg.collections.list.book.model.vo.Book;

import java.util.Comparator;


public class BookCategoryAsc implements Comparator<Book> {

	@Override
	public int compare(Book b1, Book b2) {
		return b1.getCategory()-b2.getCategory();
	}

}

/**
 * 두개이상의 필드를 기준으로 정렬하기 - 순서대로 처리해야 한다.
 * - category
 * - title : category값이 동일할때만 비교
 */
/*
public class AscCategory implements Comparator<Book> {
	@Override
	public int compare(Book b1, Book b2){
		int result = 0;
		if(b1.getCategory()-b2.getCategory() > 0){
			result = 1;
		}
		else if(b1.getCategory()-b2.getCategory() < 0){
			result = -1;
		}
		else {
			if(b1.getTitle().compareTo(b2.getTitle())<0)
				result = -1;
			else if (b1.getTitle().compareTo(b2.getTitle())>0)
				result = 1;
			else 
				result = 0;
		}
		
		return result;
	}
}
*/