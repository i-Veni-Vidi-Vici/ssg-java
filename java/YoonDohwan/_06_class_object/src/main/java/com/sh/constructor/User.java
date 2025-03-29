package com.sh.constructor;

import java.time.LocalDate;

public class User {
    private long id=123;
    private String name="홍길동";
    private LocalDate createdAt;
    /**
     *
     * 기본생성자(매개변수가 없는)
     */
    public User(){
        System.out.println("User 기본생성자 호출!");
//필드값 초기화
    }
    public User(long id, String name, LocalDate createdAt){
        System.out.println("user 필드생성자 호출!"+id+","+name+","+createdAt);
        this.id=id;
        this.name=name;
        this.createdAt=createdAt;

    }
    //접근자 getter
    //설정자 setter
    public void getId(long id){
        this.id = id;
    }
    public long setId(){
        return this.id;
    }
    public void getName(String name){
        this.name=name;
    }
    public String setName(){
        return this.name;
    }
    public void setCreatedAt(LocalDate createdAt){
        this.createdAt=createdAt;
    }
    public LocalDate getCreatedAt() {
        return createdAt;
    }
    public User(User other){
        this.id = other.id;
        this.name=other.name;
        this.createdAt = other.createdAt;
    }

    /**
     * 다른 생성자를 호출하는 방법 this() this(id,name,LocalDate.now());
     * -> 맨첫줄에 한번만 호출 가능하다.
     * @param id
     * @param name
     */
    public User(long id,String name){

    }
}
