package com.sh.constructor;

import java.time.LocalDate;

/**
 * <pre>
 * 메소드 오버로딩
 * - 메소드 이름은 같고, 매개변수부(타입, 개수, 순서)는 다르게 선언하는 것
 * </pre>
 */

public class User {

    private long id;
    private String name;
    private LocalDate createdAt;

    /**
     * 기본생성자 (매개변수가 없는)
     */
    public User() { //public void User() (X)
        System.out.println("User 기본생성자 호출!");
        // 필드값 초기화를 위해 생성자 사용 (기본값처리)
        this.id = 123;
        this.name = "홍길동";
        this.createdAt = LocalDate.now();
    }

    /**
     * 필드 생성자
     * @param id
     */
    public User(long id, String name, LocalDate createdAt) {
        System.out.println("User 필드생성자 호출!");
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    /**
     * 다른 생성자를 호출하는 방법 this()
     * - 맨첫줄에 한번만 호출 가능하다
     * @param id
     * @param name
     */

    public User(long id, String name) {
        this(id, name, LocalDate.now());
//        this.id =id;
//        this.name = name;
//        this.createdAt = LocalDate.now();
    }

    public User(long id) {
        this(id, "강아지");
//        this.id =id;
//        this.name = name;
//        this.createdAt = LocalDate.now();
    }

    /**
     * 복사 생성자
     */
    public User(User other) {
        this.id = other.id;
        this.name = other.name;
        this.createdAt = other.createdAt;
    }

    // 접근자 getter
    // 설정자 setter
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
