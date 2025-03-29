package com.sh._02.member;

import java.time.LocalDateTime;
import java.util.Scanner;

public class MemberMenu {
    Scanner scanner = new Scanner(System.in);
    MemberManager manager = new MemberManager();
    String menu = """
            ================
            1. 회원정보 저장
            2. 회원정보 열람
            0. 종료
            ================
            입력: """;
    public void menu(){
        while(true){
            System.out.print(menu);
            int choice = scanner.nextInt();
            System.out.println();
            switch (choice){
                case 1:
                    saveMember();
                    break;
                case 2:
                    readMember();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    public void saveMember(){
        long id = (int)(Math.random()*10000);
        System.out.print("사용자명 입력: ");
        String username = scanner.next();
        System.out.print("비밀번호 입력: ");
        String password = scanner.next();
        System.out.print("이름 입력: ");
        String name = scanner.next();
        manager.saveMembers(new Member(id, username, password, name, LocalDateTime.now()));
        System.out.println("[저장 완료]");
    }
    public void readMember(){
        Member[] members = manager.readMember();
        if(members==null){
            System.out.println("저장된 사용자가 없습니다.");
        }
        else{
            for(int i =0; i< members.length; i++){
                members[i].printMember();
            }
        }
    }
}
