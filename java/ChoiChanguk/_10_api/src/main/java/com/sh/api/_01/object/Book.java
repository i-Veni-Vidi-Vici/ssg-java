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
    @Override
    public String toString()
    {
        return "Book[id  "+id+", title : "+title+", author : "+author+" price = "+price+"]";
    }

    /**
     * 어떤 필드로 기준으로 동등비교할 지 정해야 한다.
     * - id, title, author, price 전부 또는 일부를 대상으로 비교할 수 있다
     * - equals와 hashCode 오버라이드시에 동일한 필드 기준으로 작성되어야 한다
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj)
    {
        // 동일 비교
        if(this==obj)
            return true;

        // null 비교
        if(obj==null)
            return false;

        //타입 비교
        if(!(obj instanceof Book))
        {
            return false;
        }
        Book other=(Book) obj;// 다운캐스팅

        // 필드 비교
        //id(기본형) 필드 비교
        if(this.id!=other.id)
            return false;

        //title(참조형) 필드 비교
        if(this.title==null)
        {
            // 현재 객체 title =null, other 객체의 title !=null
            // 주소값이 null걸 보는게 아니라, 내용물을 비교하는거다
            // 만약 둘다 null이면 어?? null값이라고 같네?? 그럼 true가는거다
            if(other.title!=null)
                return false;
        }
        else {
            if (this.title.equals(other.title))
                return false;
        }

        //author(참조형) 필드 비교
        if(this.author==null)
        {
            if(other.author!=null)
                return false;
        }
        else
        {
            if (!this.author.equals(other.author)) {
                return false;
            }
        }

        //price필드(기본형) 비교
        if(this.price!=other.price)
        {
            return false;
        }

            // 메소드 이유는 = 모든 필드가 같으면 this와 obj가 같다고 반환한다
            return true;
    }

    /**
     * 지정한 필드 기준으로 고유한 값을 만드는 엿나
     * - 필드별로 특정수를 곱해 고유값 생성 (31이란 소수를 관례적으로 사용)
     * @return
     */
    @Override
    public int hashCode()
    {
        int result = 1; // 누적곱 연산의 준비값
        final int PRIME_NUMBER = 31;
        //id 필드
        result=result*PRIME_NUMBER+(int)id;

        // title 필드
        if(title!=null)
            result = result * PRIME_NUMBER + title.hashCode();

        // author 필드
        if (author!=null)
            result = result * PRIME_NUMBER + author.hashCode();

        // price 필드
        result=result*PRIME_NUMBER+price;

        return result;
    }

}
