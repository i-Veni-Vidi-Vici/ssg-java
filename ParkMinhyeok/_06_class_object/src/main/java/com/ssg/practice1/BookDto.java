package com.ssg.practice1;

public class BookDto {
    private String title;
    private String publisher;
    private String author;
    private int price;
    private double discountRate;

    public BookDto() {
        this.title = null;
        this.publisher = null;
        this.author = null;
        this.price = 0;
        this.discountRate = 0.0;
    }
    public BookDto(String title, String publisher, String author) {
        this.title = title;
        this.publisher = publisher;
        this.author = author;
    }
    public BookDto(String title, String publisher, String author, int price, double discountRate) {
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.price = price;
        this.discountRate = discountRate;
    }
    public void printInformation() {
        title = getTitle();
        publisher = getPublisher();
        author = getAuthor();
        price = getPrice();
        discountRate = getDiscountRate();

        System.out.printf("%s, %s, %s, %d, %.1f", title, publisher, author, price, discountRate);
        System.out.println();
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return this.title;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getPublisher() {
        return this.publisher;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getAuthor() {
        return this.author;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getPrice() {
        return this.price;
    }
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    public double getDiscountRate() {
        return this.discountRate;
    }
}
