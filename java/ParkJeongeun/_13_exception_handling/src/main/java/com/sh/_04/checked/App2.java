package com.sh._04.checked;

import java.util.Scanner;

/**
 * <pre>
 * 성인용 게임 만들기
 * - 프로그램 시작시 나이입력 받고, 20세 미만인 경우 게임을 중단
 * - 성인인 경우만 게임 시작
 * - 게임 내용 : 🍸🍹🍺🍻를 출력하는 것으로 대체
 * - MemberAgeChecker 클래스에 checkAge 메소드 작성
 * - 적절한 커스텀예외클래스를 생성
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        try {
            // 나이 검사
            MemberAgeChecker memberAgeChecker = new MemberAgeChecker();
            memberAgeChecker.checkAge();
            // 게임 정상 시작
            startGame();
        } catch (NotValidMemberAgeException e){
            // 미성년자용 메세지
            System.out.println("미성년자는 게임을 이용할 수 없습니다. : " + e.getMessage());
        }
    }

    private static void startGame() {
        System.out.println("🍸🍹🍺🍻");
    }
}
