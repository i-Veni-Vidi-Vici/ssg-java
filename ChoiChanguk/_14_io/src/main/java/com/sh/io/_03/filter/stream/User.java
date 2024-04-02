package com.sh.io._03.filter.stream;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 직렬화(Seriazlizable) 인터페이스 구현 필수
 *  - 필드정보를 직겨화 처리하기 위한 인터페이스
 */
public class User implements Serializable {
    //Serializable 이건 추상메소드가 없다, 계층구조를 보려고 쓰는거나
    private long id;

    private String userName;
    private String  password;// 직렬화시 해당값 제외//
    private String name;
    private char gender;
    private int point;
    private LocalDateTime createdAt;
    private boolean enabled;
    private Phone phone;
    public User() {

    }

    public User(long id, String userName, String password, String name, char gender, int point,
                LocalDateTime createdAt, boolean enabled, Phone phone) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.phone=phone;
        this.point = point;
        this.createdAt = createdAt;
        this.enabled = enabled;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +"\n"+
                ", phone="+phone+
                ", point=" + point +
                ", createdAt=" + createdAt +
                ", enabled=" + enabled +
                '}';
    }
}
