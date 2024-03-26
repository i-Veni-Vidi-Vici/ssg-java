package com.sh._02.member;

/**
 * 1. 시스템 요구사항
 * - 여러명의 회원 정보를 관리할 수 있다.
 * - 여러명의 회원 정보를 저장한다.
 * - 저장된 회원 정보를 열람할 수 있다.
 *
 * 2. 객체 도출
 * - 회원
 * - 저장소
 * - 메뉴
 * - 관리자
 *
 * 3. 객체 상호작용
 * - 사용자--> 메뉴--> 관리자--> 저장소
 *
 */
public class App {
    public static void main(String[] args) {
        MemberMenu memberMenu = new MemberMenu();
        memberMenu.menu();
    }
}
