package com.sh._02.member;

import java.time.LocalDateTime;

public class Member {
    private long id;
    private String username;            // 아아디
    private String password;
    private String name;
    private LocalDateTime createdAt;

    // 생성자
    // 기본생성자, select none
    public Member() {
    }
    // 필드 생성자, 쉬프트로 모든 필드 선택
    public Member(long id, String username, String password, String name, LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.createdAt = createdAt;
    }
    // getter/setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
