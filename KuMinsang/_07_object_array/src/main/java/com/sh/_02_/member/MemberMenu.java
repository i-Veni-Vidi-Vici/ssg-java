package com.sh._02_.member;

import javax.sound.midi.Soundbank;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * <pre>
 *     MemberMenu가 수신할수 있는 메시지
 *     - 메뉴를 제공하라
 *     - 사용자 선택에 따라 회원 저장 입력을 받아라
 *     - 입력된 회원정보를 저장 요청하라
 *     - 사용자 선택에 따라 회원 정보를 조회하라
 *
 *     MemberMenu가 알고 있는것
 *     - Scanner
 *     - MemberManager
 *
 *     MemberMenu가 할수 있는 것
 *     - 사용자 입력값 처리하기
 *     - 입력받은 회원 객체를 MemberManager에 저장메시지 보내기
 *     - MemberManager에 회원 조회 메시지 보내기
 *     - 전달 받은 회원 정보를 출력하기
 *
 * </pre>
 * 객체지향 설계 원칙 SOLD
 * - S : 단일 책임 원칙 Single Responsibility Principle : 객체는 하나의 책임을 가져야한다
 * -
 */
public class MemberMenu {
    private Scanner sc = new Scanner(System.in);
    private MemberManager memberManager = new MemberManager();

    public void menu() {
        String menu = """
                =====================
                회원관리
                =====================
                1. 회원정보 저장
                2. 회원 아이디로 조회
                3. 전체 회원정보 열람
                0. 종료
                =====================
                """;

        while (true) {
            System.out.println(menu);
            String choice = sc.next();

            switch (choice) {
                case "1":
                    saveManager();
                    break;
                case "2":
                    readMemberByID();
                    break;
                case "3":
                    readMember();
                    break;
                case "0":
                    return;
                default:
                    System.out.println(">잘못 입력하셨습니다...");

            }
        }
    }


    private void readMember() {
        Member[] members = memberManager.readMember();
        if (members == null)
            System.out.println("저장된 회원 정보가 없습니다");
        for (Member member : members) {
            System.out.printf("%d %s %s %s %s\n",
                    member.getId(),
                    member.getUsername(),
                    member.getPassword(),
                    member.getName(),
                    member.getCreateAt());
        }
    }

    private void saveManager() {
/*        Member[] members = new Member[3];
        members[0] = new Member(1L, "abc","123", "홍길동", LocalDateTime.now());
        members[1] = new Member(2L, "def","456", "박춘배", LocalDateTime.now());
        members[2] = new Member(3L, "hij","789", "엄준식", LocalDateTime.now());

 */
        System.out.println("회원 정보를 입력하세요.\n id, 회원아이디, 비밀번호, 이름");
        Member member = new Member(
                sc.nextLong(),
                sc.next(),
                sc.next(),
                sc.next(),
                LocalDateTime.now());

        boolean success = memberManager.saveMember(member);


        System.out.println(success ?
                ">회원 정보를 성공적으로 저장했습니다" :
                ">회원정보를 저장하는데 실패했습니다");

    }

    private void readMemberByID() {
        System.out.println("조회할 ID를 입력하세요");
        long id = sc.nextLong();
        Member member = memberManager.readMember(id);
        if (member == null)
            System.out.println("해당 ID와 일치하는 회원 정보가 없습니다");
        else {
            System.out.printf("%d %s %s %s %s\n",
                    member.getId(),
                    member.getUsername(),
                    member.getPassword(),
                    member.getName(),
                    member.getCreateAt());
        }

    }

}
