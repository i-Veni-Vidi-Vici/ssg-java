package com.sh.constructor;

import java.time.LocalDate;

/**
 * <pre>
 * 메소드 오버로딩 Overloading (load 짐을 쌓음 -> 메소드를 여러개 쌓음)
 * - 메소드 이름은 같고, 매개변수부(타입, 개수, 순서)는 다르게 선언
 * </pre>
 */

public class User {
    private long id = 123;
    private String name = "홍길동";
    private LocalDate createAt = LocalDate.now();

    /**
     * 기본생성자 (매개변수가 없는 생성자)
     */
    public User(){
        System.out.println("User 기본생성자 호출!");

        // 필드값 초기화 (기본값 처리)
        this.id = 123;
        this.name = "홍길동";
        this.createAt = LocalDate.now();
    }

    /**
     * 필드 생성자
     * @param id
     */
    public User(long id, String name, LocalDate createAt){
        System.out.println("User 필드생성자 호출!" + id + ", " + name + ", " + createAt);
        this.id = id;
        this.name = name;
        this.createAt = createAt;
    }

    // 다른 생성자를 호출하는 방법 this()
    // 아래처럼 작성할 수 있지만 반복되는걸 줄이기 위해
    // 맨 첫줄에 한번만 호출 가능
    public User(long id, String name){
        this(id, name, LocalDate.now());
//        this.id = id;
//        this.name = name;
//        this.createAt = LocalDate.now(); // 오늘로 기본값 처리
    }

    /**
     * 복사 생성자 : 객체 다름(주소값 다름)
     */
    public User(User other){
        this.id = other.id;
        this.name = other.name;
        this.createAt = other.createAt;
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

    public void setCreatAt(LocalDate createAt){
        this.createAt = createAt;
    }
    public LocalDate getCreatAt(){
        return this.createAt;
    }
}