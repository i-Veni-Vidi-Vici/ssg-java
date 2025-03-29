package com.sh.constructor;

import java.time.LocalDate;

public class User {

    private long id;
    private String name;
    private LocalDate createdAt;


    /**
     * 기본생성자 (매개변수가 없는)
     */
    public User() {
        System.out.println("User 기본생성자 호출!");
        // 필드값 초기화 (기본값 처리)
        this.id = 123;
        this.name = "홍길동";
        this.createdAt = LocalDate.now();
    }

    /**
     * 필드 생성자
     * @param id
     * @param name
     * @param createdAt
     */
    public User(long id, String name, LocalDate createdAt) {
        System.out.println("User 필드 생성자 호출");
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    /**
     * 다른 생성자를 호출하는 방법 this()
     * - 반드시 맨 첫줄에 한번만 호출가능
     * @param id
     * @param name
     */
    public User(long id, String name) {
        this(id, name, LocalDate.now());
//        this.id = id;
//        this.name = name;
//        this.createdAt = LocalDate.now(); // 오늘로 기본값 처리
    }

    /**
     * 복사 생성자
     */
    public User(User user) {
        id = user.id;
        name = user.name;
        createdAt = user.createdAt;
    }

    // getter
    // setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

}
