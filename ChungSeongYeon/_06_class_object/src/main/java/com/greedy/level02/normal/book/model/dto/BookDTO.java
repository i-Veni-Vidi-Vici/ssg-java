package com.greedy.level02.normal.book.model.dto;

public class BookDTO {
    private String title;
    private String publisher;

    private String author;

    private int price;
    private double discountRate;

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
        this.author = author; // 앞에 3줄을 this(title, publisher, author)로 줄여서 사용 가능.
        this.price = price;
        this.discountRate = discountRate;
    }

    public void printInformation() {
        System.out.println(title +", "+ publisher +", "+author +", "+price +", "+ discountRate);;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

}