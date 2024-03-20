package com.sh.constructor;
import java.time.LocalDate;

public class User {
    private String name;
    private LocalDate creaatedAt;
    private long id;

    public User(){
        this.name = "홍길동";
        this.id = 123;
        this.creaatedAt = LocalDate.now();
    }
    //접근자 getter
    //설정자 setter
    public void setId(long id){
        this.id = id;
    }
    public long getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setLocalDate(LocalDate createdAt){
        this.creaatedAt = createdAt;
    }
    public LocalDate getLocalDate(){
        return this.creaatedAt;
    }

    public void userInfo(){
        System.out.println(this.name);
        System.out.println(this.id);
        System.out.println(this.creaatedAt);
    }

    public User(long id, String name, LocalDate createdAt){
        System.out.println("User 필드 생성자 호출!"+ id + ", "+ name + ", "+ createdAt);
        this.id = id;
        this.name = name;
        this.creaatedAt = createdAt;
    }

    /**
     * 복사 생성자
     */
    public User(User other){
        this.id = other.id;
        this.name = other.name;
        this.creaatedAt = other.creaatedAt;
    }

    /**
     * 필드 생성자
     */
    public User(long id , String name){
        this.id = id;
        this.name = name;
        this.creaatedAt = LocalDate.now();
    }

}
