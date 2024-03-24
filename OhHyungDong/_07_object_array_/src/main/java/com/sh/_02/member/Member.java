package com.sh._02.member;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Member {
    private long id;
    private String username; //입력하는 회원 아이디
    private String password;
    private String name;
    private LocalDateTime createdAt;

    public void memberInput()
    {
        Scanner scanner = new Scanner(System.in);
        //아이디, 이름, 패스워드, 닉네임 생성날짜
        this.id = scanner.nextInt();
        this.username = scanner.next();
        this.password = scanner.next();
        this.name = scanner.next();
        this.createdAt = LocalDateTime.now();
    }

    public Member() {
    }


    public Member(long id, String username, String password, String name, LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
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
