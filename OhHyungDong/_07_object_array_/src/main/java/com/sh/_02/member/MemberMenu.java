package com.sh._02.member;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.concurrent.atomic.LongAccumulator;

/**
 * <pre>
 * 객체 지향 설계 원칙 SOLID
 * - 단일책임 원칙 Single Responsibility Principal : 객체는 하나의 책임을 가져야한다.
 *
 * Menu가 수신 할 수 있는 메세지
 * - 메뉴를 제공하라
 *      - 사용자 선택에 따라 회원 저장 입력
 *      - 입력된 회원정보를 요청해라
 *      - 사용자 선택에 따라 회원 정보를 조회해라
 *
 * MemberMenu가 알고 있는 (가지고 있는 것)
 * - Scanner : 정보 입력 해야되서
 * - MemberManager 객체를 알고 있음
 *
 * MemberMenu가 할 수 있는 것
 * - 사용자 입력값 처리하기
 * - 입력 받은 회원객체를 MemberManager에 저장 메세지 보내기
 * - MemberrManager에 조회 메세지 보내기
 * - 전달받은 회원정보를 출력하기
 * </pre>
 */
public class MemberMenu {
    Scanner sc = new Scanner(System.in);
    private MemberManager memberManager = new MemberManager();
    public void menu()
    {
        String menu = """
         =============
         회원관리
         =============
         1. 회원정보 저장
         2. 회원 아이디로 조회
         3. 회원정보 열람 
         0. 종료 
         =============
         입력 : """;

        while(true){
            System.out.println(menu);
            String choice = sc.next();

            switch (choice){
                case "1": saveMember(); break;
                case "2": readfindByID(); break;
                case "3": readMember(); break;
                case "0": return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
                    break;

            }
        }
    }

    /**
     * 1. 사용자 입력값으로 Member객체를 생성
     * 2. MemberManager 객체 saveMember(member) 저장 요청
     */


    public void saveMember() {
        //회원정보 생성
//        Member member = new Member();
//        member.memberInput();

        Member[] members = new Member[5];
        members[0] = new Member(1L,"honggd","1234","홍길동", LocalDateTime.now());
        members[1] = new Member(2L,"sinsa","1234","신사임당", LocalDateTime.now());
        members[2] = new Member(3L,"lee","1234","이순신", LocalDateTime.now());

        boolean success = memberManager.saveMember(members);
        System.out.println(success ?
                "회원정보 저장 성공" :
                    "회원정보 저장 실패" );
    }

    public void readfindByID(){
        //저장된 멤버값들 가져오기
        Member[] members = memberManager.readMember();
        /**
         * 1. 일단 찾을 아이디 입력하고, 똑같은 값 가져와야지
         */
        System.out.print("찾을 정보의 아이디를 입력해주세요 : ");
        int findID = sc.nextInt();
        boolean findByID = false;
        if(members != null){
            for(Member member : members){
                if(findID == member.getId()){
                    findByID = true;
                    System.out.println("찾으시는 아이디와 일치하는 정보를 가져왔습니다.");
                    System.out.printf("%d  %s  %s  %s  %s\n",
                            member.getId(),
                            member.getUsername(),
                            member.getPassword(),
                            member.getName(),
                            member.getCreatedAt());
                    break;
                }
            }
            if(!findByID) System.out.println("찾으시는 ID와 일치하는 정보가 없습니다. ");

        }




    }
    public void readMember(){
        Member[] members = memberManager.readMember();
        if(members != null) {
            for (Member member : members) {
                System.out.printf("%d  %s  %s  %s  %s\n",
                        member.getId(),
                        member.getUsername(),
                        member.getPassword(),
                        member.getName(),
                        member.getCreatedAt());

            }
        }else{
            System.out.println("저장된 정보가 없습니다.");
        }
    }
}
