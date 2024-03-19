package com.sh.test.book.model.dto;

import com.sh.constructor.User;

public class BookDTO {
    private String title;
    private String publisher;
    private String author;
    private int price;
    private double discountRate;


    public void Constructor() {


    }

    //기본생성자
    public BookDTO(){
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.price = price;
        this.discountRate = discountRate;
    }

    public BookDTO(String title,String publisher,String author){
        this.title = title;
        this.publisher = publisher;
        this.author = author;

    }

    public BookDTO(String title,String publisher, String author, int price, double discountRate){
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.price = price;
        this.discountRate = discountRate;
    }

    // setters getters
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    public String getPublisher(){
        return  this.publisher;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getAuthor() {
        return this.author;
    }

    public void setPrice(int price){
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



    // 출력메소드
    public void printlnformation(){
        // new 할 때 마다 힙영역에 새롭게 만들어짐
        System.out.print(this.getTitle() + ",");
        System.out.print(this.getPublisher()+ ",");
        System.out.print(this.getAuthor()+ ",");
        System.out.print(this.getPrice()+ ",");
        System.out.print(this.getDiscountRate());
        System.out.println();
    }

}
