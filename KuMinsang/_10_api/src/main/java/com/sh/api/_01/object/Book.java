package com.sh.api._01.object;

public class Book {
    private long id;
    private String title;
    private String author;
    private int price;

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

    public Book(long id, String title, String author, int price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Book() {
    }

    @Override
    public String toString(){
        return "Book[id = " + id + ", title = " + title + ", author = " + author + ", price = "+ price+"]";
    }

    /**
     * 어떤 필드를 기준으로 동등비교할지 작성
     * @param obj
     * @return
     */

    @Override
    public boolean equals(Object obj){
        //동일 비교
        if(this == obj) //객체 주소값을 비교 동일하면 더 비교할 필요 없음
            return true;
        //null 비교
        if(obj == null)
            return false;
        //타입 비교
        if(!(obj instanceof Book))
            return false;
        //필드 비교
        Book other = (Book)obj;
        //id필드 비교
        if(this.id != other.id)
            return false;

        //title 필드 비교
        if(this.title == null){
            if(other.title != null)
                return false;
        }else{
            if(!this.title.equals(other.title))
                return false;
        }

        //author필드 비교
        if(this.author == null){
            if(other.author != null)
                return false;
        }else{
            if(!this.author.equals(other.author))
                return false;
        }

        //price 필드 비교
        if(this.price != other.price)
            return false;
        return true;
    }   //end of equals

    /**
     * 지정한 필드 기준으로 고유한 값을 만드는 연산
     * - 필드별로 특정수를 곱해 고유값 생성 (소수를 사용하는데 그 중에서 31을 관례적으로 사용)
     * @return
     */

    @Override
    public int hashCode(){
        int result = 1;
        final int PRIME = 31;
        //id필드
        result = result * PRIME + (int)id;
        //title필드
        result = result*PRIME+(title == null ? 0 : title.hashCode());
        //author필드
        result = result*PRIME+(author == null ? 0 : author.hashCode());
        //price필드
        result = result*PRIME+price;
        return result;
    }

}
