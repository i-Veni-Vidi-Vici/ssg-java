package com.greedy.level02.normal.book.model.dto;

public class BookDTO {
    // 필드
    private String title;
    private String publisher;
    private String author;
    private int price;
    private double discountRate;

    // 생성자
    public BookDTO() {

    }
    public BookDTO(String title, String publisher, String author) {
        this.title = title;
        this.publisher = publisher;
        this.author = author;
    }
    public BookDTO(String title, String publisher, String author, int price, double discountRate) {
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.price = price;
        this.discountRate = discountRate;
    }

    // 메소드
    // setter, getter
    public void setTitle(String title) {
        this.title = title;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public String getTitle() {
        return this.title;
    }
    public String getPublisher() {
        return this.publisher;
    }
    public String getAuthor() {
        return this.author;
    }
    public int getPrice() {
        return this.price;
    }
    public double getDiscountRate() {
        return this.discountRate;
    }

    // 필드값 출력용 메소드
    public void printInformation() {
        System.out.printf("%s, %s, %s, %d, %.1f\n", title, publisher, author, price, discountRate);
    }
}
