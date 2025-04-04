package com.ssg.collections.list.book.model.vo;

public class Book {
    private String no;
    private int category;
    private String title;
    private String author;

    public Book() {
    }

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

//    @Override
//    public int compareTo(Book other) {
//        return this.no.compareTo(other.no); // no(String) 오름차순(사전 등재순)
//    }
}
