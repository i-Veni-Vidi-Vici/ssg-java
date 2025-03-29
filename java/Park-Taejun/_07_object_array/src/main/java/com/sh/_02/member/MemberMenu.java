package com.sh._02.member;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * 객체지향 설계원칙 SOLID
 * - 단일책임원칙 Single Responsibility Principle : 한 객체는 하나의 책임을 가져야 한다. //여러개의 책임 가지면 관리하기 어려워짐
 */

public class MemberMenu {//필드로 선언하면 여러 메소드에서 동시에 이용 가능
    private Scanner sc = new Scanner(System.in);

    //회원 정보를 저장하고 열람하려면 멤버레포지토리를 알고 있어야 할 것임.

    private MemberRepository memberRepository;

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
                case "1": saveMembxer();break;
                case "2": readMember(); break;
                case "0":
                    return;
                default:
                    System.out.println(">잘못 입력하셨습니다.");
            }

        }
    }

    private void readMember() {
    }

    private void saveMembxer() {
        
    }
}

