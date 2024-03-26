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
    public String toString(){
        return "Book[id = " + id + ", title = " + title +
                ", author = " + author + ", price" + price + "]";
    }
    @Override
    public boolean equals(Object obj){
        // 동일
        if(this == obj)
            return true;
        // null 비교
        if(obj == null)
            return false;
        // 타입 비교
        if(!(obj instanceof Book))
            return false;
        // 필드 비교
        Book other = (Book) obj; // 다운캐스팅
        // id 필드 비교
        if(this.id != other.id){
            return false;
        }

        // title 필드 비교
        if(this.title == null){
            if(other.title != null) {
                return false;
            }
            else{
                // 오버라이드 된 String#equals 대신 호출
                if(!this.title.equals(other.title))
                    return false;
            }
        }
        // author 필드 비교
        if(this.author == null){
            if(other.author != null){
                return false;
            }
            else{
                if(this.author.equals(other.author));
                return false;
            }
        }
        // price 필드(기본형) 비교
       if(this.price != other.price)
           return false;

       return true;
    }

    /**
     * 지정한 필드 기준으로 고유한 값을 만드는 연산
     * - 필드별로 특정수를 곱해 고유 값 생성 (31이란 소수를 관례적으로 사용)
     * @return
     */
    @Override
    public int hashCode(){
        int result = 1; // 누적 곱 연산의 준비 값
        final int PRIME = 31;
        // id필드
        result = result * PRIME + (int) id;
        // title필드
        if(title != null)
        {
            result = result * PRIME + title.hashCode();
        }
        // author필드
        if(author != null){
            result = result * PRIME + author.hashCode();
        }

        // price필드
        result = result * PRIME + price;
        return result;
    }

}
