package com.sh.level02.normal.book;

import java.awt.print.Book;

public class BookDTO {
    private String title;
    private String publisher;
    private String author;
    private int price;
    private double discountRate;

    public BookDTO(){

    }
    public BookDTO(String title, String publisher, String author, int price, double discountRate) {
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.price = price;
        this.discountRate = discountRate;
    }

    public BookDTO(String title, String publisher, String author)
    {
        this.title = title;
        this.publisher = publisher;
        this.author = author;
    }

    public void printInformation(BookDTO bookDTO){
        System.out.println("책 이름 : " + bookDTO.title);
        System.out.println("책 출판사 : " + bookDTO.publisher);
        System.out.println("책 저자 : " + bookDTO.author);
        System.out.println("책 가격 : " + bookDTO.price + "원");
        System.out.println("책 할인율 : " + bookDTO.discountRate+"%");

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
