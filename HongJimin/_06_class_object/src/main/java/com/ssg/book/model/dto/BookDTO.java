package com.ssg.book.model.dto;

public class BookDTO {
    String title;
    String publisher;
    String author;
    int price;
    double discountRate;

    public BookDTO() {}
    public BookDTO(String title, String publisher, String author, int price, double discountRate){
        this(title, publisher, author);
        this.price = price;
        this.discountRate = discountRate;
    }

    public BookDTO(String title, String publisher, String author){
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.price = 0;
        this.discountRate = 0.0;
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

    public void printInformation(){
        //getter, setter 이용하기
        System.out.print(getTitle() + ", ");
        System.out.print(getPublisher() + ", ");
        System.out.print(getAuthor() + ", ");
        System.out.print(getPrice() + ", ");
        System.out.print(getDiscountRate() + ", \n");
    }
}
