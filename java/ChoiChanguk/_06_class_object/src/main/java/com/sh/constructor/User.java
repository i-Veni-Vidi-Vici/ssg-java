package com.sh.constructor;

import java.time.LocalDate;

/**
 * <pre>
 * 메소드 오버로딩
 * - 메소드 이름은 같고, 매개변수 부분은 다르게 선언
 * </pre>
 */

public class User {
    /**
     * 기본생성자 (매개변수가 없는)
     */
    private long id;
    private String name;
    private LocalDate createdAt;

    //필드값 초기화(기본값)
    public User() {
        this.id=123;
        this.name = "최창욱";
        this.createdAt=LocalDate.now();
        System.out.println("User 기본생성자 호출");
    }
    //필드생성자
    public User(long id, String name, LocalDate createdAt)
    {
        System.out.println("User 필드생성자 호출"+id+","+name+","+createdAt);
        this.id=id;
        this.name=name;
        this.createdAt=createdAt;
    }

    /**
     * 복사 생성자
     * @return
     */
    public User(User other)
    {
        this.id=other.id;
        this.name=other.name;
        this.createdAt=other.createdAt;
    }
    //생성자는 꼭!! 필드값을 다 쓸 필요는 없다
    public User(long id,String name)
    {
        //생성자에서 중복되는 경우가 많으면 이렇게도 한다
        //1번 생성자를 했으면 그 아래 생성자는 하면 안된다
        //2,3,4번은 안쓴다
        this(id,name,LocalDate.now());//1
        this.id=id;//2
        this.name=name;//3
        this.createdAt=LocalDate.now();//4
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
