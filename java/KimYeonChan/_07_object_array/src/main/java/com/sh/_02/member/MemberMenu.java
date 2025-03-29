package com.sh._02.member;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * 객체지향 설계원칙 SOLID
 * - 단일책임원칙 Single Responsibility Principle: 객체는 하나의 책임을 가져야 한다.
 * MemberMenu 가 수신할 수 있는 메세지
 * - 메뉴를 제공하라
 *      - 사용자 선택에 따라 회원 저장 입력을 받아라
 *      - 입력된 회원정보를 저장 요청해라
 *      - 사용자 선택에 따라 회원 정보를 조회해라
 * MemberMenu 가 알고 있는 (가지고 있는) 것
 * - Scanner
 * - MemberManager
 * MemberMenu 가 할 수 잇는 것
 * - 사용자 입력값 처리하기
 * - 입력 받은 회원 객체를 MemberManager 에 저장 메세지 보내기
 * - MemberManager 에 회원 조회 메세지 보내기
 * - 전달 받은 회원 정보 출력하기
 */
public class MemberMenu {
    private Scanner sc = new Scanner(System.in);
    private MemberManager memberManager = new MemberManager();

    public void menu() {
        String menu = """
                =========================
                회원관리
                =========================
                1. 회원정보 저장
                2. 회원정보 열람
                0. 종료
                =========================
                입력: """;
        while (true) {
            System.out.print(menu);
            String choice = sc.next();

            switch (choice) {
                case "1":
                    saveMember();
                    break;
                case "2":
                    readMember();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("> 잘못 입력하셨습니다.");
            }

        }
    }

    /**
     * 1. 사용자 입력값으로 Member 객체를 생성
     * 2. MemberManager 객체 saveMember(member) 저장 요청
     */
    public void saveMember() {
        Member member = inputMember();
        boolean success = memberManager.saveMember(member);
        System.out.println(success ?
                "> 회원정보를 성공적으로 저장했습니다." :
                    "> 회원정보를 저장하는데 실패했습니다.");
    }

    public Member inputMember() {
        System.out.println("> 회원정보를 입력하세요...");
        System.out.print("회원번호 입력: ");
        long id = sc.nextLong();
        System.out.print("아이디 입력: ");
        String userName = sc.next();
        System.out.print("비밀번호 입력: ");
        String password = sc.next();
        System.out.print("이름 입력: ");
        String name = sc.next();
        return new Member(id, userName, password, name, LocalDateTime.now());
    }

    public void readMember() {
        Member[] members = memberManager.readMemeber();
        if (members != null) {
            for (Member member : members) {
                System.out.printf("%d  %s  %s  %s  %s\n",
                        member.getId(),
                        member.getUserName(),
                        member.getPassword(),
                        member.getName(),
                        member.getCreatedAt()
                );
            }
        } else {
            System.out.println("저장된 회원 정보가 없습니다.");
        }
    }
}
