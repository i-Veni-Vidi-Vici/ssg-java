package com.sh.api._01.object;

public class Book {
    private long id;
    private String title;
    private String Author;
    private int price;

    public Book() {
    }

    public Book(long id, String title, String author, int price) {
        this.id = id;
        this.title = title;
        Author = author;
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
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String toString(){
        return "Book[id = "+id+", title "+title + ", author = "+ Author+",price "+ price;

    }

    /**
     * 어떤 필드로 기준으로 동등비교할지
     * @param obj
     * @return
     */
    public boolean equals(Object obj){
        if(this==obj)
            return true;
        //null 비교
        if(!(obj instanceof Book))
            return false;
        //필드 비교
        Book other = (Book)obj;//다운캐스팅
        //id 필드(기본형) 비교
        if(this.id !=other.id)
            return false;
        //title 필드(참조형) 비교
        if(this.title == null){
            if(other.title !=null)
                return false;
        }
        else{
            if(!this.title.equals(other.title))
                return false;

        }
        //author 필드(참조형) 비교
        if(this.Author!=null)   {
            if(other.Author!=null)
                return false;      }
        else{
            if(!this.Author.equals(other.Author))
                return false;
            }

        //price 필드(기본형) 비교
        if(this.price !=other.price)
            return false;
        return true;
    }

    /**
     * 지정한 필드 기준으로 고유한 값을 만드는 연산
     * -필드별로 특정수를 곱해 고유값을 생성 (31이란 소수를 관례적으로 사용)
     * @return
     */
    public int hashCode(){
        int result =1 ;
        final int PRIME =31;
        //id 필드
        result = result * PRIME +(int)id;
        //title 필드
        if(title!=null)
        result = result + PRIME + title.hashCode();
        //author필드
        if(Author!=null)
        result = result * PRIME + Author.hashCode();
        //price필드
        result=result*PRIME+price;
        return result;
    }
}
