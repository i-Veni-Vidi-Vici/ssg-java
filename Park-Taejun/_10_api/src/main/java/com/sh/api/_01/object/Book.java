package com.sh.api._01.object;

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
        return "Book[id = " + id + ", title = ";
    }

    /**
     * 어떤 필드 기준으로
     */

    public boolean equals(Object obj) {
        //동일 비교
        if(this == obj)
            return true; //같은 값이라면 비교를 할 필요가 없음
        //null 비교
        if(obj == null)
            return false; // null 여도의미가 없음
        // 타입 비교
        if(!(obj instanceof Book))
            return false;

        // 필드 비교
        Book other = (Book) obj; // 다운캐스팅 진행

        //id 필드(기본형) 비교'
        if(this.id != other.id)
            return false;

        // title 필드(참조형) 비교
        if(this.title == null){
            //현재객체의 title이 null인데, other 객체의 title이 null이 아닌 경우
            if(other.title !=null)
                return false;
        }
        else {
            //오버라이드된 String#equals 대신 호출

            if(this.title.equals(other.title))
                return false;
        }

        // author 필드(참조형) 비교
        if(this.author == null){
            if(other.author !=null)
                return false;
        } else {
            if ( this.author.equals(other.title))
                return false;
        }

        // price 필드 (기본형) 비교
        if(this.price != other.price)
            return false;
        return true;
    }

    /**
     * 해시코드는 객체에 대한 식별값
     * 지정한 필드 기준으로 고유한 값을 만드는 연산을 함
     * - 필드별로 특정수를 곱해 고유값을 생성함(31이란 소수를 관례적으로 사용함)
     *
     * @return
     */
    @Override
    public int hashCode(){
        int result = 1; //누적곱 연산의 준비값
        final int PRIME = 31;
        // id필드
        result = result * PRIME + (int) id;
        // title 필드
        if(title != null)
        result = result * PRIME + title.hashCode();

        //author 필드
        result = result * PRIME + author.hashCode();
        if(author != null)
        //price 필드
        result = result * PRIME + price;

        return result;
    }
}
