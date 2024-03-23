package com.sh._02.member;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * <pre>
 * 객체지향 설계원칙 SOLID
 * - 단일책임원칙 Single Responsibility Principle : 객체는 하나의 책임을 가져야 한다.
 *
 * MemberMenu가 수실할 수 있는 메세지
 *  - 메뉴를 제공하라
 *      - 사용자 선택에 따라 회원 저장 입력을 받아라
 *      - 입력된 회원정보를 저장 요청해라
 *      - 사용자 선택에 따라 회원 정보를 조회해라
 *
 * MemberMenu가 알고 있는(가지고 있는) 걸
 *  - Scanner
 *  - MemberManager
 *
 *  MemberMenu가 할 수 있는 것
 *  - 사용자 입력값 처리하기
 *  - 입력받은 회원객체를 MemberManager에 저장 메세지 보내기
 *  - MemberManager에 회원 조회 메세기 보내기
 *  - 전달받은 회원정보를 출력
 * </pre>
 */
public class MemberMenu {
    private Scanner sc = new Scanner(System.in);
    private MemberManager memberManager = new MemberManager();

    public void menu() {
        String menu = """
        ====================
        회원관리
        ====================
        1. 회원정보 저장
        2. 회원 아이디로 조회
        3. 회원정보 열람
        0. 종료
        ====================
        입력 : """;

        while(true) {
            System.out.print(menu);
            String choice = sc.next();

            switch(choice) {
                case "1":
                    saveMember();
                    break;
                case "2":
                    readMemberById();
                    break;// 회원 아이디로 조회 //과제
                case "3":
                    readMember();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("> 잘못 입력하셨습니다...");
            }
        }
    }

    private void readMemberById() {
        System.out.printf("찾으실 id를 입력하세요 : ");
        long id=sc.nextLong();
        Member member =memberManager.memberByid(id);

        if(member==null)
        {
            System.out.println("찾으시는 아이디가 없거나, 잘못된 아이디입니다");
        }
        else
        System.out.printf("ID = %d UserName = %s 암호 = %s \n이름 = %s 등록 시간 = %s\n",member.getId(),member.getUsername(),member.getPassword(),member.getName(),member.getCreatedAt());
    }

    private void readMember() {
        Member[] members = memberManager.readMember();

        if(members != null) {
            System.out.println("-----------------------------------------");
            for(Member member : members) {
                System.out.printf("%d   %s  %s  %s %s\n",
                        member.getId(),
                        member.getUsername(),
                        member.getPassword(),
                        member.getName(),
                        member.getCreatedAt());
            }
            System.out.println("-----------------------------------------");
        }
        else {
            System.out.println("> 저장된 회원정보가 없습니다.");
        }

    }

    /**
     * 1. 사용자 입력값으로 Member객체를 생성
     * 2. MemberManager객체 saveMember(member) 저장요청
     */
    private void saveMember() {
        // 회원정보 생성
        Member member = inputMember();
        boolean success = memberManager.saveMember(member);
        System.out.println(success ?
                "> 회원 정보를 성공적으로 저장했습니다. " :
                    "> 회원 정보를 저장하는데 실패했습니다.");
    }

    private Member inputMember() {
        System.out.println("> 회원정보를 입력하세요...");
        System.out.print("> 회원번호 입력 : ");
        long id = sc.nextLong();
        System.out.print("> 아이디 입력 : ");
        String username = sc.next();
        System.out.print("> 비밀번호 입력 : ");
        String password = sc.next();
        System.out.print("> 이름 입력 : ");
        String name = sc.next();
        return new Member(id, username, password, name, LocalDateTime.now());
    }


}
