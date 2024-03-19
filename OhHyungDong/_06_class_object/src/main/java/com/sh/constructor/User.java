package com.sh.constructor;

import java.time.LocalDate;

/**
 * <pre>
 *  메소드 오버로딩
 *  - 메소드 이름은 같고, 매개변수부(타입, 개수, 순서)는 다르게 선언하는 것.
 * </pre>
 */

public class User {

    /**
     * 기본 생성자 ( 매개변수가 없는)
     */

    private long id;



    private String name;
    private LocalDate createdAt;

    /**
     * 기본 생성자
     */
    public User()
    {
        System.out.println("User 기본 생성자 호출 ");
        //필드 값 초기화(기본값 처리)
        this.id = 123;
        this.name = "홍길동";
        this.createdAt = LocalDate.now();

    }
    /**
     * 필드 생성자
     *
     */
    public User(long id, String name, LocalDate createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    /**
     * 다른 생성자를 호출 하는 방법 this() 생성자 내에서만 this()를 사용해야 한다.
     * - 맨첫줄에 한번만 호출 가능하다.
     * @param id
     * @param name
     */
    public User(long id, String name)
    {
        this(id, name, LocalDate.now());
//        this.createdAt = LocalDate.now(); //호출 할 때 매개변수로 값이 들어오지 않았기 떄문에 생성자에서 값 초기화
    }
    /**
     * 복사생성자
     */
    public User(User other)
    {
        this.id = other.id;
        this.name = other.name;
        this.createdAt = other.createdAt;
    }



    public String getName() {
        return name;
    }

    public void setAnme(String name) {
        this.name = name;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
