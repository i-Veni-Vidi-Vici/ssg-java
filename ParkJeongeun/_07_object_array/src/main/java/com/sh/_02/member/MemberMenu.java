package com.sh._02.member;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <pre>
 * 객체지향 설계원칙 SOLID
 * - 단일책임원칙 Single Responsibility Priciple : 객체는 하나의 책임을 가져야 함(책임은 객체 당 하나만)
 *
 * MemberMenu가 수신할 수 있는 메세지
 * - 메뉴를 제공
 *   - 사용자 선택에 따라 회원 저장 입력 받기
 *   - 입력된 회원정보를 저장/요청
 *   - 사용자 선택에 따라 회원정보를 조회
 *
 * MemberMenu가 알고 있는/가지고 있는 것
 * - Scanner
 * - MemberManager
 *
 * MemberMenu가 할 수 있는 것
 * - 사용자 입력값 처리하기
 * - 입력받은 회원 객체를 MemberManager에 저장 메세지 보내기
 * - MemberManager에 회원조회 메세지 보내기
 * - 전달받은 회원정보 출력
 *
 * </pre>
 */

public class MemberMenu {
    private Scanner sc = new Scanner(System.in); // 필드에 선언하면 여러 메소드에서 사용 가능
    private MemberManager memberManager = new MemberManager();
    public void menu() {
        String menu = """
        ==================
        회원관리
        ==================
        1. 회원정보 저장
        2. 회원아이디로 조회
        3. 전체 회원정보 열람
        0. 종료
        ==================        
        입력 : """;
        while (true){
            System.out.print(menu);
            String choice = sc.next();

            switch (choice){
                case "1" : saveMember(); break;
                case "2" : readMemberById(); break;
                case "3" : readMember(); break;
                case "0" : return;
                default :
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    private void readMemberById() {
        System.out.print("> 조회할 아이디(번호)를 입력하세요 :  ");
        long id = sc.nextLong();
        Member member = memberManager.readMemberById(id);
        if(member != null) {
            System.out.println("------------------------");
            System.out.println("> id : " + member.getId());
            System.out.println("> username : " + member.getUsername());
            System.out.println("> name : " + member.getName());
            System.out.println("> createdAt : " + member.getCreatedAt());
            System.out.println("------------------------");
        }
        else {
            System.out.println("> 조회된 회원이 없습니다.");
        }
    }

    private void readMember() {
        Member[] members = memberManager.readMember();
        if (members != null){
            System.out.println("-------------------------------");
            for (Member member : members){
                System.out.printf("%d   %s    %s   %s   %s\n",
                        member.getId(),
                        member.getUserName(),
                        member.getPassword(),
                        member.getName(),
                        member.getCreatedAt());
            }
            System.out.println("-------------------------------");
        } else {
            System.out.println("> 저장된 회원정보가 없습니다.");
        }
    }

//    private void saveMember() {
//        // 회원정보 생성
//        Member[] members = new Member[3];
//        members[0] = new Member(1L, "honggd", "1234", "홍길동", LocalDateTime.now());
//        members[1] = new Member(2L, "sinsa", "1234", "신사임당", LocalDateTime.now());
//        members[2] = new Member(3L, "leess", "1234", "이순신", LocalDateTime.now());
//        boolean success = memberManager.saveMember(members);
//        System.out.println(success ?
//                "> 회원정보를 성공적으로 저장했습니다." :
//                "> 회원정보를 저장하는데 실패했습니다.");
//    }

    /**
     * 1. 사용자 입력값으로 Member 객체 생성
     * 2. MemberManager 객체 saveMember(member)
     */

    private void saveMember(){
        //(나)
//        Member[] members = new Member[3];
//        for (int i = 0; i < members.length; i++){
//            if (i == 0) {
//                sc.nextLine();
//            }
//            System.out.print("> userName을 입력하세요 : ");
//            String userName  = sc.nextLine();
//            System.out.print("> 패스워드를 입력하세요 : ");
//            String password  = sc.nextLine();
//            System.out.print("> 이름을 입력하세요 : ");
//            String name  = sc.nextLine();
//
//            members[i] = new Member((i + 1), userName, password, name, LocalDateTime.now());
//        }
//        System.out.println(Arrays.toString(members));

        // 회원정보 생성
        Member member = inputMember();
        boolean success = memberManager.saveMember(member);
        System.out.println(success ?
                "> 회원 정보를 성공적으로 저장" :
                "> 회원 정보를 저장하는데 실패");
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
