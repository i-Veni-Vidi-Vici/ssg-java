package com.greedy.level02.normal.book.run;

public class BookDTO {
    private String title;
    private String publisher;
    private String author;
    private int price;
    private double discountRate;
    public BookDTO() {}  // 기본 생성자

    public BookDTO(String title, String publisher, String author) {  // 필드생성자
        this.title = title;
        this.publisher = publisher;
        this.author = author;
    }

    public BookDTO(String title, String publisher, String author, int price, double discountRate) { // 모든 필드
        this(title, publisher, author);
//        this.title = title;  // 필드생성자에서 중복되는 title
//        this.publisher = publisher; // 필드생성자에서 중복되는 publisher
//        this.author = author; // 필드생성자에서 중복되는 author
        this.price = price;
        this.discountRate = discountRate;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
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
        System.out.println(this.title + ", " + this.publisher + ", " + this.author + ", " + this.price + ", " +
                this.discountRate);
    }
}
