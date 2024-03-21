package com.sh._02.member;

/**
 * <pre>
 * 1. 시스템 요구사항
 * - 여러명의 회원정보를 관리할 수 있다.
 * - 여러명의 회원정보를 저장한다. (in-memory)
 * - 저장된 회원정보를 열람할 수 있다.
 *
 * 2. 객체 도출
 * - 회원
 * - 저장소
 * - 메뉴
 * - 관리자
 * 
 * 3. 객체 상호작용
 * - 사용자 ----> 메뉴 ----> 관리자 ----> 저장소
 * -         회원정보저장 --> 회원정보 ---> 회원정보저장
 * -         열람요청  ----->  열람요청 --->
 *                <------ 회원정보 -------
 * 
 * 4. 객체별 수신메세지(책임)
 * - 회원 :
 *      회원정보(아이디, 비밀번호, 회원명, 생성일)를 담을 공간을 제공하라
 * - 메뉴 :
 *      메뉴를 제공하라
 *      사용자선택에 따라 관리자에 회원정보를 저장요청하라
 *      사용자선택에 따라 관리자에 회원정보를 읽기요청하라
 * - 관리자 :
 *      회원정보를 저장하라
 *      회원정보를 가져와라
 * - 저장소
 *      회원정보를 저장하라
 *      회원정보를 가져와라
 *
 * 5. 클래스 설계/구현
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        MemberManager memberManager = new MemberManager();
        MemberMenu memberMenu = new MemberMenu(memberManager);
        memberMenu.menu();
        System.out.println(memberManager);
    }
}
