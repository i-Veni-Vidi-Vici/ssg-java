package com.sh._02.member;

/**
 * MemberManager가 수신하는 메세지
 * - 회원을 저장하라
 * - 회원을 읽어와라
 *
 * MemberManager가 알고 있는 것
 * - 회원저장서비스 객체
 * - 회원찾기서비스 객체
 *
 * MemberManager가 할 수 있는 것
 * - 회원저장서비스에게 회원저장 메세지 보내기
 * - 회원찾기서비스에게 회원조회 메세지 보내기
 *
 */

import java.time.LocalDateTime;

public class Member {  // DTO클래스
    private long id;
    private String username;
    private String password;
    private String name;
    private LocalDateTime createdAt;

    public Member() {  // 기본생성자
    }

    // 필드생성자
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
