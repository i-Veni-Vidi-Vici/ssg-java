package com.sh.collections._03.map;

public class Book {
    private long id; //식별값
    private String title;
    private String author;
    private  int price;

    @Override
    public String toString()
    {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    public Book(long id, String title, String author, int price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
