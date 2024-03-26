package com.sh._02.member;

/**
 * 1. 시스템 요구사항
 *  - 여러명의 회원정보 관리
 *  - 여러명의 회원정보 저장
 *  - 저장된 회원정보 열람
 *
 * 2. 객체 도출
 *  - 회원
 *  - 저장소
 *  - 메뉴
 *  - 관리자
 */
public class App {
    public static void main(String[] args) {
        MemberMenu menu = new MemberMenu();
        menu.menu();
    }
}
