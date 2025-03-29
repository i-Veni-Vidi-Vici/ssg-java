package com.sh._02.member;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * 객체지향 설계원칙 SOLID
 * - 단일 책임 원칙 Single Resposibility Principle : 객체는 하나의 책임을 가져야 한다.
 *
 * MemberMenu가 수신할 수 있는 메시지
 * - 메뉴를 제공하라 (사용자 선택에 따라 회원 저장 입력을 받아라)
 *      - 사용자 선택에 따라 회원 저장 입력을 받아라
 *      - 입력된 회원정보를 요청해라
 *      - 사용자 선택에 따라 회원 정보를 조회해라
 *
 * MemberMenu가 알고 있는(가지고 있는) 것
 * - Scanner
 * - MemberManager
 *
 * MemberMenu가 할 수 있는 것
 * - 사용자 입력값 처리하기
 * - 입력받은 회원객체를 MemberManager에 저장메시지 보내기
 * - MemberManager에 회원 조회 메시지 보내기
 * - 전달받은 회원정보를 출력하기
 *
 */
public class MemberMenu {
    private Scanner sc = new Scanner(System.in);
    private MemberManager memberManager = new MemberManager();

    public void menu() {
        String menu = """
                ===================
                회원관리
                ===================
                1. 회원정보 저장
                2. 회원정보 아이디로 조회
                3. 회원정보 열람
                0. 종료
                ===================
                """;
        while (true) {
            System.out.print(menu);
            String choice = sc.next();

            switch(choice) {
                // int로 받지 않았을시 오류가 나니까 String으로 받기
                case "1": saveMember(); break;
                case "2" : readMemberById(); break;
                case "3": readMember(); break;
                case "0": return;
                default:
                    System.out.println("잘못 입력하셨습니다...");
            }
        }
    }

    /**
     * 1. 사용자 입력값으로 Member 객체를 생성
     * 2. MemberManger 객체 saveMember(member)를 전달해서 저장요청
     */
    private void saveMember() {
        int index = MemberRepository.getIndex();

        // 회원정보 생성
        Member member = inputMember(index);
//        members[0] = new Member(1L, "honggd", "1234", "홍길동", LocalDateTime.now());
//        members[1] = new Member(2L, "sinsa", "1234", "신사임당", LocalDateTime.now());
//        members[2] = new Member(3L, "leess", "1234", "이순신", LocalDateTime.now());
//        boolean success = memberManager.saveMember(members);
        boolean success = memberManager.saveMember(member);
        System.out.println(success ?
                "> 회원 정보를 성공적으로 저장했습니다." :
                "> 회원 정보를 저장하는데 실패했습니다.");
    }

    private void readMemberById() {
        System.out.print("> 조회할 아이디를 입력하세요. : ");
        long id = sc.nextLong();
        Member member = memberManager.readMemberById(id);
        if (member != null) {
            System.out.println("---------------------");
            System.out.println("> id : " + member.getId());
            System.out.println("> username : " + member.getUsername());
            System.out.println("> name : " + member.getName());
            System.out.println("---------------------");
        } else {
            System.out.println("조회된 회원이 없습니다.");
        }
    }

    private void readMember() {
        Member[] members = memberManager.readMember();
        if (members != null) {
            for (Member member : members) {
                System.out.printf("%d %s %s %s %s\n",
                        member.getId(),
                        member.getUsername(),
                        member.getPassword(),
                        member.getName(),
                        member.getCreatedAt());
            }
        }
    }

    private Member inputMember(int index) {
        System.out.println("> 회원정보를 입력하세요...");
//        System.out.print("> 회원번호 입력 : ");
//        long id = sc.nextLong();
        System.out.println("> 아이디 입력 :");
        String username = sc.next();
        System.out.println("> 비밀번호 입력 : ");
        String password = sc.next();
        System.out.println("> 이름 입력 : ");
        String name = sc.next();
        return new Member(index+1, username, password, name, LocalDateTime.now());
    }
}
