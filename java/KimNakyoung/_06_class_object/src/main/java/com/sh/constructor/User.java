package com.sh.constructor;

import java.time.LocalDate;


/**
 * <pre>
 *  메소드 오버로딩 Overloading
 *  - 메소드 이름은 같고, 매개변수부(타입, 개수, 순서)는 다르게 선언하는 것
 *
 * </pre>
 *
 *
 */



// 생성자 이름 == 클래스 이름
public class User {

    //필드 (전역변수 먼저 작성 )(인스턴스 변수)

    private long id;

    private String name;

    private LocalDate createdAt;


    /**
     *
     * 기본생성자 (매개변수가 없는)
     */
    // !!리턴 타입 없는 생성자!! void int 이런거 원래 썼잖

   // 필드값 초기화는 생성자안에서 합니다~~~~~ private에서 하는거 아니예요~~
    public User() {
        System.out.println("User 기본생성자 호출!");
        //필드값 초기화(기본값 처리)
        this.id = 123;
        this.name = "홍길동";
        this.createdAt = LocalDate.now();
    }
//    public void User(){
//
//    }
    // 리턴타입 적는 순간 일반 메서드 됨 생성자 x


    // 접근자 getter
    // 설정자 setter


    /**
     * 필드 생성자
     * @param id
     */

    //매개변수를 선언해서
    public  User(long id, String name, LocalDate createdAt){
        // 이 전달 받을 것을
        System.out.println("User 필드생성자 호출!" + id + "," + name + "," + createdAt);
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;

    }

    /**
     * 복사 생성자
     *
     */

    // 새로 만들어진 객체에 other라는 이름을 받을꺼야
    public User(User other) {
        this.id = other.id;
        this.name = other.name;
        this.createdAt = other.createdAt;

    }

    /**
     * 다른 생성자를 호출하는 방법 this()
     * - 맨첫줄에 한번만 호출가능하다.
     * @param id
     * @param name
     */
    public User(long id, String name){
        this(id,name,LocalDate.now()); // 호출 한번만 하세유
//        this.id = id;
//        this.name = name;
//        this.createdAt = LocalDate.now(); // 오늘로 기본값 처리
    }





//    private long id;
    public void setId(long id){
        this.id = id;
    }

    public long getId(){
        return this.id;
    }
//
//    private String name;

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

//
//    private LocalDate createdAt;
    public void setCreatedAt(LocalDate createdAt){
        this.createdAt = createdAt;
    }

//    getter는 읽어오는 겁니다~
    public LocalDate getCreatedAt(){
        return this.createdAt;
    }

}
