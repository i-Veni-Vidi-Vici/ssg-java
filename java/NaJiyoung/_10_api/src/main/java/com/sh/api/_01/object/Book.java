package com.sh.api._01.object;

import java.util.Objects;

public class Book {
    private long id;
    private String title;
    private String author;
    private int price;

    public Book() {
    }

    public Book(long id, String title, String author, int price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book[id = " + id + ", title = " + title + ", author = " + author + ", price = " + price + "]";
    }

    /**
     * 어떤 필드를 기준으로 동등비교할 지 정해야 한다.
     * - id, title, author, price 전부 또는 일부를 대상으로 비교할 수 있다.
     * - equals와 hashCode 오버라이드시에 동일한 필드 기준으로 작성되어야 한다.
     * @param obj
     * @return
     */
//    @Override
//    public boolean equals(Object obj) {
//        // 동일 비교
//        if(this == obj)
//            return true;
//        // null 비교
//        if(obj == null)
//            return false;
//        // 타입 비교
//        if(!(obj instanceof Book))  // Book 객체가 아니라면
//            return false;
//        // 필드 비교
//        Book other = (Book) obj;    // 다운캐스팅
//        // id필드(기본형) 비교
//        if(this.id != other.id)
//            return false;
//
//        // title필드(참조형) 비교
//        if(this.title == null) {
//            // 현재 객체의 title이 null인데, other객체의 title이 null이 아닌 경우
//            if(other.title != null)
//                return false;
//        } else {
//            // 오버라이드된 String#equals 대신 호출
//            if(!this.title.equals(other.title))
//                return false;
//        }
//
//        // author필드(참조형) 비교
//        if(this.author == null) {
//            if(other.author != null)
//                return false;
//        } else {
//            if(!this.author.equals(other.author))
//                return false;
//        }
//
//        // price필드(기본형) 비교
//        if(this.price != other.price)
//            return false;
//
//        return true;
//    }

    /**
     * 지정한 필드 기준으로 고유한 값을 만드는 연산
     * - 필드별로 특정 수를 곱해 고유값 생성 (31이란 소수(1과 자신만 약수인 수)를 관례적으로 사용)
     * @return
     */
//    @Override
//    public int hashCode() {
//        int result = 1; // 누적곱 연산의 준비값
//        final int PRIME = 31;
//        // id필드
//        result = result * PRIME + (int)id;
//        // title필드
//        result = result * PRIME + (title == null ? 0 : title.hashCode());
//        // author필드
//        result = result * PRIME + (author == null ? 0 : author.hashCode());
//        // price필드
//        result = result * PRIME + price;
//
//        return result;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && price == book.price && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, price);
    }
}
