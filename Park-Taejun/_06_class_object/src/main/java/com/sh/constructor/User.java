package com.sh.constructor;

import java.time.LocalDate;

/**
 * ㅁ=
 */
public class User {
    private long id;
    private  String name;
    private LocalDate createdAt;

    /**
     * 기본생성자(매개변수가 없는)
     */

      public User(){
          System.out.println("User 기본생성자 호출 !");
          //필드값 초기화 (기본값처리)
          this.id = 123;
          this.name = "홍길동";
          this.createdAt = LocalDate.now();
      }

    /**
     *
     * @param id
     */
    public User(long id, String name, LocalDate createdAt){
        System.out.println("User 필드생성자 호출!" + id + ", " + name + ", " + createdAt);
        this.id = id;
        this.name = name;
        this.createdAt=createdAt;
    }
    // 접근자 getter
      // 설정자 setter
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

      public void setCreatedAt(){
          this.createdAt = createdAt;
      }

      public LocalDate getCreatedAt(){
          return this.createdAt;
      }

    /**
     * 복사 생성자
     *
     */
    public User(User other){
        this.id = other.id;
        this. name = other. name;
        this. createdAt = other.createdAt;


    }

    /**
     * 다른 생성자를 호출하는 방법 this()
     * 맨첫줄에 한번만 호출가능하다.
     * @param id
     * @param name
     */
    public User(long id, String name){
        this(id, name, LocalDate.now()); // 바로 아래에다가 써야한대요[

    }
}
