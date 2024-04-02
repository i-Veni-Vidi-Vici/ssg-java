package com.sh.collections._02.set;

public class Book {

    private long id;

    private String title;

    private String author;

    private int price;

    public Book(long id, String title, String author, int price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    public Book() {


    }

    public void setTitle(String 대로변대장) {
    }

    public Comparable<Object> getTitle() {
        return null;
    }

    public int getPrice() {
        return 0;
    }


    public Comparable<Object> getAuthor() {
        return null;
    }
}
