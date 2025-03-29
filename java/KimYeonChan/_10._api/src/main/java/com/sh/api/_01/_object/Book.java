package com.sh.api._01._object;

import java.util.Objects;

public class Book {
    private long id;
    private String title;
    private String author;
    private int price;

    public Book() {}

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
     * 어떤 필드로 기준으로 동등비교 할 지 정해야 한다.
     * - id, title, author, price 전부 또는 일부를 대상으로 비교 할 수 있다.
     * - equals 와 hashCode 오버라이드시에 동일한 필드 기준으로 작성되어야 한다.
     */
//    @Override
//    public boolean equals(Object obj) {
//        // 동일 비교
//        if (this == obj)
//            return true;
//
//        // null 비교
//        if (obj == null)
//            return false;
//
//        // 필드 비교
//        if (!(obj instanceof Book))
//            return false;
//        else {
//            Book other = (Book) obj; // 다운캐스팅
//
//            if(this.id != other.id)
//                return false;
//
//            if (this.title == null) {
//                if (other.title != null)
//                    return false;
//            }
//            else {
//                if (!this.title.equals(other.title))
//                    return false;
//            }
//
//            if (this.author == null) {
//                if (other.author != null)
//                    return false;
//            }
//            else {
//                if (!this.author.equals(other.author))
//                    return false;
//            }
//
//            if (this.price != other.price)
//                return false;
//
//            return true;
//        }
//    }

    /**
     * 지정한 필드 기준으로 고유한 값을 만드는 연산
     * - 필드별로 특정수를 곱해 고유값 생성 (31이란 소수를 관례적으로 사용)
     */
//    @Override
//    public int hashCode() {
//        int result = 1; // 누적곱 연산의 준비값
//        final int PRIME = 31;
//        // id 필드
//        result *= PRIME + (int) id;
//        // title 필드
//        if (title != null)
//            result *= PRIME + title.hashCode();
//        // author 필드
//        if (author != null)
//            result *= PRIME + author.hashCode();
//        // price 필드
//        result *= PRIME + price;
//
//        return result;
//    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Book book = (Book) o;
//        return id == book.id && price == book.price && Objects.equals(title, book.title) && Objects.equals(author, book.author);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, title, author, price);
//    }
}
