package com.ssg.collections.map.book.controller;


import com.ssg.collections.list.book.model.compare.BookCategoryAsc;
import com.ssg.collections.list.book.model.vo.Book;

import java.util.*;



public class BookManager {
	private Map<String, Book> bookMap = new HashMap<>();
	{
		bookMap.put("A3B2C1", new Book("A3B2C1", 2, "나미야 잡화점의 기적", "히가시노 게이고"));
		bookMap.put("35LK23", new Book("35LK23", 3, "파리의 아파트", "기욤 뮈소"));
		bookMap.put("DS25KZ", new Book("DS25KZ", 1, "ABCDE", "도레미"));
		bookMap.put("K0DR0S", new Book("K0DR0S", 2, "미중전쟁", "김진명"));
		bookMap.put("5KOSR3", new Book("5KOSR3", 1, "JAVA 삽질하기", "김동현"));
	}

	public void addBook(Book book) {
		bookMap.put(book.getNo(), book);
	}

	public void deleteBook(String key) {
		if (bookMap.containsKey(key)) {
			Book removed = bookMap.remove(key); // 삭제된 Book객체 반환
			System.out.println(removed.getTitle() + " 도서를 삭제했습니다.");			
		}
		else
			System.out.println("해당 도서가 존재하지 않습니다.");
	}

	public String searchBook(String title) {
		Set<Map.Entry<String, Book>> entrySet = bookMap.entrySet();
		for (Map.Entry<String, Book> entry : entrySet) {
			String key = entry.getKey();
			Book value = entry.getValue();
			if (value.getTitle().equals(title))
				return key;
		}
		return null;
	}

	public void printBook(String key) {
		if (bookMap.containsKey(key))
			System.out.println(bookMap.get(key));
		else
			System.out.println("해당 도서가 존재하지 않습니다.");
	}

	public void printAll() {
		Set<String> keySet = bookMap.keySet();
		Iterator<String> iter = keySet.iterator();

		System.out.println();
		System.out.printf("%10s %10s %10s %10s%n", "번호", "카테고리", "제목", "작가");
		System.out.println("-------------------------------------------------------------");
		
		while(iter.hasNext()) {
			String key = iter.next();
			Book value = bookMap.get(key);
				System.out.printf("%10s %10s %10s %10s%n", 
									value.getNo(),
									value.getCategory(),
									value.getTitle(),
									value.getAuthor());
		}
		System.out.println();
	}

	/**
	 * 원본 List를 직접 정렬하게 되면, 실제 리스트의 저장순서(index)가 바뀐다. 저장순서가 중요하다면, 정렬은 복사본을 통해 처리하는
	 * 것이 좋다. - ArrayList#clone 오버라이드를 해두었음. - List가 아닌 ArrayList 타입으로 호출해야 한다. -
	 * 리턴타입은 Object이다.
	 * 
	 * @return
	 */
	public List<Book> sortedBookListByNo() {
		ArrayList<Book> bookList = new ArrayList<>(bookMap.values());
		bookList.sort(null);
		return bookList;
	}

	public void printBookList(List<Book> bookList) {
		for (Book book : bookList) {
			System.out.println(book);
		}
	}

	public List<Book> sortedBookListByCategory() {
		ArrayList<Book> bookList = new ArrayList<>(bookMap.values());
		bookList.sort(new BookCategoryAsc());
		return bookList;
	}

}
