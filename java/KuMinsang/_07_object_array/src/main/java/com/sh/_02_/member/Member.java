package com.sh._02_.member;

import java.time.LocalDateTime;

public class Member {
    private static long id;
    private String username;
    private String password;
    private String name;
    private LocalDateTime createAt;

    public Member() {    }

    public Member(long id, String username, String password, String name, LocalDateTime createAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.createAt = createAt;
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

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }


}
