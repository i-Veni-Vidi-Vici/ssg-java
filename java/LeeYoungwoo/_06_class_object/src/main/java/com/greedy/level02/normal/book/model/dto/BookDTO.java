package com.greedy.level02.normal.book.model.dto;

/**
 * `-` private
 * `~` default
 * `#` protected
 * `+` public
 * 밑줄은 static을 의미합니다.
 */
public class BookDTO {
    private String title;
    private String publisher;
    private String author;
    private int price;
    private double discountRate;

    // Constructor
    public BookDTO(){}
    public BookDTO(String title, String publisher, String author){
        this.title = title;
        this.publisher = publisher;
        this.author = author;
    }
    public BookDTO(String title, String publisher, String author, int price, double discountRate){
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.price = price;
        this.discountRate = discountRate;
    }

    // setters, getters
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

    public void printlnformation() {
        System.out.print(getTitle() + ", ");
        System.out.print(getPublisher() + ", ");
        System.out.print(getAuthor() + ", ");
        System.out.print(getPrice() + ", ");
        System.out.print(getDiscountRate());
    }
}
