package com.sh._02.member;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * <pre>
 * 객체지향 설계 원칙 SOLID
 * - 단일 책임 원칙 Single Responsibility Principle : 객체는 하나의 책임을 가져야 한다.
 *
 * MemberMenu가 수신할 수 있는 메세지
 * - 메뉴를 제공하라
 *      - 사용자 선택에 따라 회원 저장 입력을 받아라
 *      - 입력된 회원 정보를 저장 요청해라
 *      - 사용자 선택에 따라 회원 정보를 조회해라
 *
 * MemberMenu가 알고 있는(가지고 있는) 것
 * - Scanner
 * - MemberManager
 *
 * MemberMenu가 할 수 있는 것
 * - 사용자 입력값 처리하기
 * - 입력받은 회원 객체를 MemberManager에 저장 메세지 보내기
 * - MemberManager에 회원 조회 메세지 보내기
 * - 전달받은 회원 정보를 출력하기
 *
 * </pre>
 */
public class MemberMenu {
    private Scanner sc = new Scanner(System.in);
    private MemberManager memberManager = new MemberManager();

    public void menu() {
        String menu = """
                =========================
                       회원 관리
                =========================
                1. 회원 정보 저장
                2. 회원 아이디로 조회
                3. 전체 회원 정보 연람
                0. 종료
                =========================
                입력 : 
                """;

        while (true) {
            System.out.print(menu);
            String choice = sc.next();

            switch (choice) {
                case "1":
                    saveMember();
                    break;
                case "2" :
                    //아이디로 조회하는 기능 만들어보기
                case "3":
                    readMember();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("> 잘못 입력하셨네요😂");
            }
        }
    }

    private void readMember() {
        Member[] members = memberManager.readMember();

        if (members != null) {
            System.out.println("========================");
            for (Member member : members) {
                System.out.printf("%d  %s  %s %s %s\n",
                        member.getId(),
                        member.getUsername(),
                        member.getPassword(),
                        member.getName(),
                        member.getCreatedAt());
            }
            System.out.println("========================");
        }
        else {
            System.out.println("> 저장된 회원정보가 없습니다.");
        }
    }

    /**
     * 1. 사용자 입력값으로 Member객체를 생성
     * 2. MemberManager 객체 saveMember(member) 저장 요청
     */
    private void saveMember() {
        //회원 정보 생성,
        Member member = inputMember();
        boolean success = memberManager.saveMember(member);
        System.out.println(success ?
                "> 회원 정보를 성공적으로 저장했습니다. " :
                "> 회원 정보를 저장하는데 실패했습니다");

//        Member[] members = new Member[3];



//        for (int i = 0; i< members.length; i++) {
//            System.out.println("id 입력 : ");
//            int id = sc.nextInt();
//            System.out.println("username 입력 : ");
//            String username  = sc.next();
//            System.out.println("password 입력 : ");
//            String password = sc.next();
//            System.out.println("name 입력 : ");
//            String name = sc.next();
//
//            members[i] = new Member(id, username, password, name);
//            boolean success = memberManager.saveMember(members[i]);
//            System.out.println(success ?
//                            "> 회원 정보를 성공적으로 저장했습니다. " :
//                "> 회원 정보를 저장하는데 실패했습니다"););

        }

    private Member inputMember() { //밑의 주석 처리된 인덱스들을 사용자가 입력한 값으로 넣는 방법
        System.out.println(" === 회원 정보 입력=== ");
        System.out.print(" > 회원 번호 입력 : ");
        long id = sc.nextLong();
        System.out.print(" > 아이디 입력 : ");
        String username = sc.next();
        System.out.print(" > 비밀번호 입력 : ");
        String password = sc.next();
        System.out.print(" > 이름 입력 : ");
        String name = sc.next();
        return new Member(id, username, password, name, LocalDateTime.now());
    }

//        members[0] = new Member(1L, "hong", "1234", "홍길동", LocalDateTime.now());
//        members[1] = new Member(2L, "sinsa", "1234", "신사임당", LocalDateTime.now());
//        members[2] = new Member(3L, "leess", "1234", "이순신", LocalDateTime.now());

////        boolean success = memberManager.saveMember(members);
//        System.out.println(success ?
//                "> 회원 정보를 성공적으로 저장했습니다. " :
//                "> 회원 정보를 저장하는데 실패했습니다");
    }

