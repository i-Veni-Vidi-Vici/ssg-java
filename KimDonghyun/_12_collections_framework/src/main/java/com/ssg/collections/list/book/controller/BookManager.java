package com.ssg.collections.list.book.controller;

import com.ssg.collections.list.book.model.compare.BookCategoryAsc;
import com.ssg.collections.list.book.model.vo.Book;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
	private ArrayList<Book> bookList = new ArrayList<>();
	{
		bookList.add(new Book("A3B2C1", 2, "나미야 잡화점의 기적", "히가시노 게이고"));
		bookList.add(new Book("35LK23", 3, "파리의 아파트", "기욤 뮈소"));
		bookList.add(new Book("DS25KZ", 1, "ABCDE", "도레미"));
		bookList.add(new Book("K0DR0S", 2, "미중전쟁", "김진명"));
		bookList.add(new Book("5KOSR3", 1, "JAVA 삽질하기", "김동현"));
	}

	public BookManager() {
	}

	public BookManager(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}

	public void addBook(Book book) {
		bookList.add(book);
	}

	public void deleteBook(int index) {
		if (index != -1) {
			bookList.remove(index);
			System.out.println("해당 도서를 삭제했습니다.");
		}
		else
			System.out.println("해당 도서가 존재하지 않습니다.");
	}

	public int searchBook(String title) {
		for (int i = 0; i < bookList.size(); i++) {
			Book b = (Book) bookList.get(i);
			if (title.equals(b.getTitle()))
				return i;
		}
		return -1;
	}

	public void printBook(int index) {
		if (index != -1)
			System.out.println((Book) bookList.get(index));
		else
			System.out.println("해당 도서가 존재하지 않습니다.");
	}

	public void printAll() {
		for (int i = 0; i < bookList.size(); i++) {
			System.out.println(bookList.get(i));
		}
	}

	/**
	 * <pre>
	 * 원본 List를 직접 정렬하게 되면, 실제 리스트의 저장순서(index)가 바뀐다. 
	 * 저장순서가 중요하다면, 정렬은 복사본을 통해 처리하는 것이 좋다. 
	 * - ArrayList#clone 오버라이드를 해두었음. 
	 * - 리턴타입은 Object이다.
	 * 
	 * @return
	 */
	public List<Book> sortedBookListByNo() {
		List<Book> copied = (List<Book>) bookList.clone(); // 동적바인딩 
		copied.sort(null);
		return copied;
	}

	public void printBookList(List<Book> bookList) {
		for (Book book : bookList) {
			System.out.println(book);
		}
	}

	public List<Book> sortedBookListByCategory() {
		ArrayList<Book> _bookList = (ArrayList<Book>) bookList;
		List<Book> copied = (List<Book>) _bookList.clone();
		copied.sort(new BookCategoryAsc());
		return copied;
	}
}
