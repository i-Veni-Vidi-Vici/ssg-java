package com.sh.io._03.filter.stream;

import java.io.Serializable;
import java.time.LocalDateTime;

public class User implements Serializable {
    private long id;
    private String username;
    private String password;
    private String name;
    private char gender;
    private int point;
    private LocalDateTime createdAt;
    private boolean enabled;

    public User(long id, String username, String password, String name, char gender, int point, LocalDateTime createdAt, boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.point = point;
        this.createdAt = createdAt;
        this.enabled = enabled;
    }

    public User() {
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
