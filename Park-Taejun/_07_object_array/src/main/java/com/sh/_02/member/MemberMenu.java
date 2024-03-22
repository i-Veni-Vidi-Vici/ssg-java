package com.sh._02.member;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * 객체지향 설계원칙 SOLID
 * - 단일책임원칙 Single Responsibility Principle : 한 객체는 하나의 책임을 가져야 한다. //여러개의 책임 가지면 관리하기 어려워짐
 */

public class MemberMenu {//필드로 선언하면 여러 메소드에서 동시에 이용 가능
    private Scanner sc = new Scanner(System.in);
    private MemberManager memberManager;
    private MemberRepsitory memberRepsitory; // 알고 있어야 멤버 리파지 토리 호출 등등 할 수 있음

    public void menu() {
        String menu = """
                ================
                회원관리
                ================
                1. 회원정보 저장
                2. 회원정보 열람
                0. 종료
                ================
                               
                입력 :""";

        while (true) {//무한 반복문 몇번을 할지 모르니
            System.out.println(menu);
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
                    System.out.println(">잘못 입력하셨습니다.");
            }

        }
    }

    private void readMember() {
        Member[] members = memberManager.readMember();

        if(members!= null) {
            for(Member member : members){
            System.out.printf("%d %s %s %s\n",
                    member.getId(),
                    member.getUsername(),
                    member.getPassword(),
                    member.getName(),
                    member.getCreatAT());


        }
        }
    }

    /**
     * 1. 사용자 입력값으로 Member 객체를 생성
     * 2. MemberManager 객체
     */
    private void saveMember() {
        Member[] members = new Member[3];
        members[0] = new Member(1L,"hongge", "1234", "홍길동", LocalDateTime.now());
        members[1] = new Member(2L,"sinsa", "1234", "신사임당", LocalDateTime.now());
        members[2] = new Member(3L,"leess", "1234", "이순신", LocalDateTime.now());
        boolean success = memberManager.saveMember(members);
        System.out.println( success ? " > 회원 정보를 성공적 저장 " :
                                            "> 회원 정보 저장 실패");
        // 멤버 매니저를 통해서 readMember 하고 멤버 매니저를 통해서 read 매니저 하게됨
    }
}