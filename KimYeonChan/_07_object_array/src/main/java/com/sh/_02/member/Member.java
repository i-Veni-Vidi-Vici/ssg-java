package com.sh._02.member;

import java.time.LocalDateTime;

public class Member {
    private long id;
    private String userName;
    private String password;
    private String name;
    private LocalDateTime createdAt;

    public Member() {}

    public Member(long id, String userName, String password, String name, LocalDateTime createdAt) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
