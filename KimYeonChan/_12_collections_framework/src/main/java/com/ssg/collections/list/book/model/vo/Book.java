package com.ssg.collections.list.book.model.vo;

/**
 * Comparable 인터페이스 구현
 * - 정렬을 구현하는 다른 한가지 방법
 * - DTO 클래스에서 직접 구현
 * - Comparable<T> 구현, compareTo(T):int 메소드 오버라이드
 * - 특정 클래스의 기본 정렬 (한가지)를 작성해둔다.
 */
public class Book {
    private String no;
    private int category;
    private String title;
    private String author;

    public Book() {}

    public Book(String no, int category, String title, String author) {
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
        return "Book{" +
                "no='" + no + '\'' +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
