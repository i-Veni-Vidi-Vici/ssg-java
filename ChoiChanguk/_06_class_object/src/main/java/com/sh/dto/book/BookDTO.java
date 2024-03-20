package com.sh.dto.book;

public class BookDTO {
    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    private String title;

    private String publisher;
    private String author;
    private int price;
    private double discountRate;
    public BookDTO()//클래스 생성자 = 초기화 담당을 한다
    {

    }

    public BookDTO(String title, String publisher, String author)
    {
        this.title=title;
        this.publisher=publisher;
        this.author=author;
    }
    public BookDTO(String title, String publisher, String author, int price, double discountRate)
    {
        this.title=title;
        this.publisher=publisher;
        this.author=author;
        this.price=price;
        this.discountRate=discountRate;
    }

    public void printInformation() {
        System.out.print(getTitle()+" ");
        System.out.print(getPublisher()+" ");
        System.out.print(getAuthor()+" ");
        System.out.print(getPrice()+" ");
        System.out.print(getDiscountRate()+" \n");
    }
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
