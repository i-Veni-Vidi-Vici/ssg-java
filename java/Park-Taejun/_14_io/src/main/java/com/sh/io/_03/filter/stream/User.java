package com.sh.io._03.filter.stream;

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
    private LocalDateTime createAt;
    private boolean enabled;

    public User(long l, String honggd, String number, String 홍길동, char m, Phone phone, int i, LocalDateTime now, boolean b) {
    }

    public User(long id, String username, String password, String name, char gender, int point, LocalDateTime createAt, boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.point = point;
        this.createAt = createAt;
        this.enabled = enabled;
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

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * 직렬화(Serializeable) 인터페이스 구현 필수
     * - 필드정보를 직렬화 하기위한 인터페이스
     */
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
                ", createAt=" + createAt +
                ", enabled=" + enabled +
                '}';
    }
}
