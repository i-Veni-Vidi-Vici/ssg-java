package com.sh.constructor;

import java.time.LocalDate;

public class User {
    private long id;
    private String name;
    private LocalDate createAt;

    /**
     * 기본 생성자 (매개변수가 없는)
     */
    public User() {
        System.out.println("기본 생성자 호출");
        // 필드값 초기화
        this.id = 123;
        this.name = "홍길동";
        this.createAt = LocalDate.now();
    }

    /**
     * 필드 생성자
     *
     * @param id
     */
    public User(long id, String name, LocalDate createAt) {
        System.out.println("User 필드생성자 호출" + id + ", " + name + ", " + createAt);
        this.id = id;
        this.name = name;
        this.createAt = createAt;
    }

    /**
     * 다른 생성자를 호출하는 방법 this()
     * - 맨 첫줄에 한 번만 호출 가능하다.
     * @param id
     * @param name
     */
    public User(long id, String name) {
        this(id, name, LocalDate.now());
//        this.id = id;
//        this.name = name;
//        this.createAt = LocalDate.now();
    }

    /**
     * 복사 생성자
     * @param id
     */
    public User(User other) {
        this.id = other.id;
        this.name = other.name;
        this.createAt = other.createAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }
}
