package com.ssg.collections.list.book.model.vo;

public class Book {
    private String no; // 도서번호 (임의의 숫자/영대문자로 구성된 6자리 문자열)
    private int category; // 도서분류코드 (1.인문/2.자연과학/3.의료/4.기타)
    private String title; // 책 제목
    private String author; // 저자

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
        return String.format("Book[%s, %d, %s, %s]", no, category, title, author);
    }
}
