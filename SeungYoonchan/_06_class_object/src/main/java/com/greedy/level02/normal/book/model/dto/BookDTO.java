package com.greedy.level02.normal.book.model.dto;

public class BookDTO {
    private String title;
    private String publisher;
    private String author;
    private int price;
    private double discountRate;

    // 기본 생성자
    public BookDTO() {
    }

    // 제목, 출판사, 저자를 초기화하는 생성자
    public BookDTO(String title, String publisher, String author) {
        this.title = title;
        this.publisher = publisher;
        this.author = author;
    }

    // 모든 필드를 초기화하는 생성자
    public BookDTO(String title, String publisher, String author, int price, double discountRate) {
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.price = price;
        this.discountRate = discountRate;
    }

    // getter/setter
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

    public void printInformation() {
        System.out.println("제목: " + this.getTitle());
        System.out.println("출판사: " + this.getPublisher());
        System.out.println("저자: " + this.getAuthor());
        System.out.println("가격: " + this.getPrice());
        System.out.println("할인율: " + this.getDiscountRate());
        System.out.println();
    }
}
