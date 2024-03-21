package com.sh.test.book.model.dto;

/**
 - private
 ~ default
 # protected
 + public
 밑줄은 static
 */

public class BookDTO {
    private String title;
    private String publisher;
    private String author;
    private int price;
    private double discountRate;


    // 기본 생성자
    public BookDTO(){}

    public BookDTO(String title, String publisher, String author){
        this.title = title;
        this.publisher = publisher;
        this.author = author;
    }

    public BookDTO(String title, String publisher, String author, int price, double discountRate){
        this(title,publisher,author);
        // this()쓴 이유 중복을 제거하여 코드를 간결하게 쓰기 위해서다. this()호출로 아래 호출이 생략됐다.
        // this.title = title'
        // this.publisher = publisher;
        // this.author = author;
        this.price = price;
        this.discountRate = discountRate;
    }

    // setter, getter
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getPublisher(){
        return this.publisher;

    }
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    public String getAuthor(){
        return this.author;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    public int getPrice(){
        return this.price;
    }
    public void setPrice(int price){
        this.price = price;
    }

    public double getDiscountRate(){
        return this.discountRate;
    }
    public void setDiscountRate(double discountRate){
        this.discountRate = discountRate;
    }

    public void printInformation(){
//        System.out.println(this.title + ", " +this.publisher + ", " +  this.author + ", " + this.price + ", " + this.discountRate);
        System.out.print(getTitle()+", ");
        System.out.print(getPublisher()+", ");
        System.out.print(getAuthor()+", ");
        System.out.print(getPrice()+", ");
        System.out.print(getDiscountRate()+" \n");
    }
}
