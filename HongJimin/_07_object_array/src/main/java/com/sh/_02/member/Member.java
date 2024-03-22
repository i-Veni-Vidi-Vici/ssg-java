package com.sh._02.member;

import java.time.LocalDateTime;

public class Member {
    private long id; // 회원 고유 번호를 의미
    private String username;
    private String password;
    private String name;
    private LocalDateTime createdAt;

    public Member() {
    }

    public Member(long id, String username, String password, String name, LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.createdAt = createdAt;
    }

    /**
     * 새로 추가한 생성자!
     * @param id
     * @param username
     * @param password
     * @param name
     */
    public Member(long id, String username, String password, String name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.createdAt = LocalDateTime.now();
    }

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
