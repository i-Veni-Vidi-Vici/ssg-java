package com.ssg.test.classObject.problem1;

public class BookDto {
    String title, publisher, author;
    int price;
    double discountRate;
    public BookDto(){

    }
    public BookDto(String title, String publisher, String author){
        this.title = title;
        this.publisher = publisher;
        this.author =author;
    }
    public BookDto(String title, String publisher, String author, int price, double discountRate) {
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
        System.out.printf("제목: %s 출판사: %s 저자: %s 가격: %d 할인율: %f\n",
                this.title, this.publisher, this.author, this.price, this.discountRate);

    }
}
