package com.sh.api._01.object;

import java.util.Objects;

public class Book
{
    private long code;
    private String title;
    private String author;
    private int price;

    @Override
    public String toString(){
        return "Book[id = " + code + ", title = " + title + ", author = " + author + ", price = " + price +"]";
    }

    /**
     * 어떤 필드로 기준으로 동등비교할 지 정해야 한다.
     *  - id title, author, price : 전부 또는 일부를 대상으로 비교할 수있다.
     *  - equalsdhk hashCode 오버라이드시에 동일한 필드를 기준으로 견뎌야 한다.
     * @param obj
     * @return
     */
//    @Override
//    public boolean equals(Object obj){
//        // 동일 비교
//        if(this == obj){
//            return true;
//        }
//        // null 비교
//        if(obj == null){
//            return false;
//        }
//        //타입 비교
//        if(!(obj instanceof  Book)) return false;
//        // 필드 비교
//        Book other = (Book) obj; // 다운 캐스팅
//        //code 필드(기본형) 비교
//        if(this.code != other.code) return false;
//
//        //title필드(참조형) 비교
//        if(this.title == null){
//            //현재 객체의 title이 null인데, other객체의 title이 null이 아닌 경우
//            if(other.title != null) return false;
//        }else{
//            //오버라이드 된 String #equals 대신 호출
//            if(!this.title.equals(other.title)) return false;
//
//        }
//        //author 필드(참조형) 비교
//        if(this.author == null){
//            if(other.author != null) return false;
//        }
//        else{
//            if(!this.author.equals(other.author)) return false;
//
//        }
//        //price(기본형) 필드 비교
//        if(this.price != other.price) return false;
//        return true;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return code == book.code && price == book.price && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, title, author, price);
    }

    /**
     * 지정한 필드 기준으로 고유한 값을 만드는 연산
     * - 필드별로 특정수를 곱해 고유값 생성 (31이란 소수를 관례적으로 많이 사용 )
     * @return
     */
//    @Override
//    public int hashCode(){
//        int result = 1; //누적곱 연산의 준비값
//        final int PRIME =31;
//        //코드 필드
//        result = result * PRIME + (int)code;
//        //제목 필드
//        if(title != null)
//            result = result * PRIME + title.hashCode();
//        //저작 필드
//        if(author != null)
//            result = result * PRIME + author.hashCode();
//        //가격 필드
//        result = result * PRIME + price;
//        return result;
//    }
    public Book(){

    }
    public Book(long code, String title, String author, int price) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
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

    public int getPrice(int price) {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
