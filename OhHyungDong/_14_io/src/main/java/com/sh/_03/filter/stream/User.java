package com.sh._03.filter.stream;

import java.io.Serializable;
import java.time.LocalDateTime;

public class User implements Serializable {

    private long id;
    private String username;
    private String password;
    private String name;
    private char gender;
    private Phone phone;
    private int point;
    private LocalDateTime createdAt;

    private boolean enabled;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", phone=" + phone +
                ", point=" + point +
                ", createdAt=" + createdAt +
                ", enabled=" + enabled +
                '}';
    }

    public User(long id, String username, String password, String name, char gender,Phone phone,int point, LocalDateTime createdAt, boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.point = point;
        this.createdAt = createdAt;
        this.enabled = enabled;
    }
}
