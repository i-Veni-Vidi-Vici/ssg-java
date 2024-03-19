package com.ssg.book;

public class BookDto {

    private String title;
    private String publisher;
    private String author;
    private int price;
    private double discountRate;

    public BookDto() {
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

    public void printInformation(BookDto bookDto) {
        System.out.print(bookDto.getTitle() + ", ");
        System.out.print(bookDto.getPublisher() + ", ");
        System.out.print(bookDto.getAuthor() + ", ");
        System.out.print(bookDto.getPrice() + ", ");
        System.out.print(bookDto.getDiscountRate());
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
