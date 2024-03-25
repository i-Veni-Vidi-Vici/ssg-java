package com.sh._02.member;

import java.time.LocalDateTime;

public class Member {
    private long id;
    private String userName;
    private String password;
    private String name;
    private LocalDateTime createdTime;

    public Member(long id, String userName, String password, String name, LocalDateTime createdTime) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.createdTime = createdTime;
    }

    public void printMember(){
        System.out.printf("ID: %d username: %s password: %s name: %s\n", this.id, this.userName, this.password, this.name);
    }
}
