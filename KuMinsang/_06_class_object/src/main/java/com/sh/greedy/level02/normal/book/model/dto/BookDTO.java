package com.sh.greedy.level02.normal.book.model.dto;

public class BookDTO {
    private String title;
    private String publisher;
    private String author;
    private int price;
    private double discountRate;

    public BookDTO(){

    }
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public void printInformation(){
        System.out.println("제목: "+ this.title+ " 저자: " +this.author+ " 출판사: " +this.publisher+ " 가격: "+this.price+" 할인율: "+this.discountRate);
    }
}
