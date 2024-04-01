package com.ssg.collections.list.book.model.vo;

/**
 * <pre>
 * Comparable 인터페이스 구현
 * - 정렬을 구현하는 다른 한가지 방법
 * - DTO클래스에서 직접 구현.
 * - Comparable<T>구현, compareTo(T):int 메소드 오버라이드
 * - 특정클래스의 기본정렬(한가지)를 작성해둔다.
 * </pre>
 * 
 */
public class Book implements Comparable<Book> {
	private String no;		// 임의의 숫자/영대문자로 구성된 6자리 문자열
	private int category;	// 도서분류코드(1.인문/2.자연과학/3.의료/4.기타)
	private String title;
	private String author;
		
	public Book(){}

	/**
	 * @param no
	 * @param category
	 * @param title
	 * @param author
	 */
	public Book(String no, int category, String title, String author) {
		super();
		this.no = no;
		this.category = category;
		this.title = title;
		this.author = author;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [no=" + no + ", category=" + category + ", title=" + title + ", author=" + author + "]";
	}

	@Override
	public int compareTo(Book other) {
		return this.no.compareTo(other.no); // no(String) 오름차순(사전 등재순)
	}
	
	
	
}
