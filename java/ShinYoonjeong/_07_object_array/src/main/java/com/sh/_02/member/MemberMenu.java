package com.sh._02.member;

import java.time.LocalDateTime;
import java.util.Scanner;

import static java.time.LocalTime.now;

/**
 * 객체지향 설계원친 SOLID
 * - 단일책임원칙 Single Respomsibility Principle : 객체는 하나의 책임을 가져야 한다.
 *
 * MemberMenu가 수신할 수 있는 메세지
 * - 메뉴를 제공하라
 *  - 사용자 선택에 따라 회원 저장 입력을 받아라
 *  - 입력된 회원 정보를 저장 요청해라
 *  - 사용자 선택에 따라 회원 정보를 조회해라
 * MemberMenu가 알고 있는(가지고 있는) 것
 * - Scanner
 * - MemberManager
 *
 * MemberMenu가 할 수 있는 것
 * - 사용자 입력 값 처리하기
 * - 입력 받은 회원 객체를 MemberManager에 저장 메세지 보내기
 * - MemberManager에 회원 조회 메세지 보내기
 * - 전달 받은 회원 정보를 출력하기
 */
public class MemberMenu {
    private Scanner sc = new Scanner(System.in);
    private MemberManager memberManager = new MemberManager();
    public void menu(){
        String menu = """
                ===============
                회원 관리
                ===============
                1. 회원정보 저장
                2. 회원 아이디로 조회
                3. 전체 회원정보 열람
                0. 종료
                ===============
                입력 : 
                """;
        while(true){
            System.out.print(menu);
            String choice= sc.next();
            switch (choice){
                case "1": saveMember(); break;
                case "2": searchMember(); break;
                case "3": readMember(); break;
                case "0": return;
                default:
                    System.out.println("> 잘못 입력하셨습니다.");

            }
        }
    }

    private void searchMember() {
        Member[] members = memberManager.searchMember();
        System.out.println("조회하실 아이디를 입력해주세요.");

    }

    private void readMember(){
        Member[] members = memberManager.readMember();
        if(members != null){
            for(Member member : members){
                System.out.printf("%d  %s  %s  %s  %s\n",
                        member.getId(),
                        member.getUsername(),
                        member.getPassword(),
                        member.getName(),
                        member.getCreatedAt());
            }

        }
        else {
            System.out.println("회원 정보가 없습니다.");
        }
    }

    /**
     * 1. 사용자 입력 값으로 Member 객체를 생성
     * 2. MemberManager 객체 saveMember(member) 저장 요청
     */
    private void saveMember(){
        // 회원 정보 생성
        //Member[] members = new Member[3];
        Member member = inputMember();
        boolean success = memberManager.saveMember(member);
        System.out.println(success ?
                "> 회원 정보를 성공적으로 저장했습니다. " :
                "> 회원 정보를 저장하는데 실패했습니다.");
    }
    private Member inputMember(){
        System.out.println("회원 정보를 입력하세요");
        System.out.println("회원 번호 입력 : ");
        long id = sc.nextLong();
        System.out.println("아이디 입력 : ");
        String username = sc.next();
        System.out.println("비밀번호 입력 : ");
        String password = sc.next();
        System.out.println("이름 입력 : ");
        String name = sc.next();
        return new Member(id, username, password, name,LocalDateTime.now());
    }
}
