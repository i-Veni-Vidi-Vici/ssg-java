package com.sh.constructor;

import java.time.LocalDate;

/**
 * 메소드 오버로딩 Overloading
 * - 메소드 이름은 같고, 매개 변수부(타입, 개수, 순서) 는 다르게 선언하는 것
 */
public class User {
    private long id;
    private String name;
    private LocalDate createAt;
    /**
     * 기본 생성자 매개변수가 없는
     */
    public User() {
        System.out.println("기본 생성자 호출!");
        // 필드값 초기화 (기본 값 처리)
        id = 123;
        name = "홍길동";
        createAt = LocalDate.now();
    }

    public User(long id, String name, LocalDate createAt) {
        System.out.println("User 필드생성자 호출! " + id + ", " + name + ", " + createAt);
        this.id = id;
        this.name = name;
        this.createAt = createAt;
    }

    public User(User other) {
        this.id = other.id;
        this.name = other.name;
        this.createAt = other.createAt;
    }

    public User(long id, String name) {
        // 다른 생성자를 호출하는 방법
        this(id, name, LocalDate.now());
        // this.id = id;
        // this.name = name;
        // createAt = LocalDate.now(); // 오늘로 기본값 처리
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
