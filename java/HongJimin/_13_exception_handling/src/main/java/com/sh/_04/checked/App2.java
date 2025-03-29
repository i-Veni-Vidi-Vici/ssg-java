package com.sh._04.checked;

import java.util.Scanner;

/**
 * <pre>
 *     성인용 게임을 작성해주세요
 *     - 프로그램 시작 시에 나이를 입력 받고, 20세 미만인 경우, 게임을 중단합니다.
 *     - 성인인 경우에만 게임을 시작하세요.
 *     - 게임의 내용은 🌟✨🎉🎇를 출력하는 걸로 대체합니다.
 *     - hint : MemberAgeChecker클래스에 checkAge 메소드를 작성하세요.
 *     - 적절한 커스텀예외 클래스를 생성해 사용하세요.
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try { //정상 흐름
            //나이 검사
            MemberAgeChecker memberAgeChecker = new MemberAgeChecker();
            memberAgeChecker.checkAge();

            // 게임 정상 시작
            startGame();

        } catch (NotValidMemberAgeException e) { // 예외 흐름
            // 미성년자용 메세지
            System.out.println("미성년자는 게임을 이용할 수 없습니다😅 : " + e.getMessage());

        }
    }

    private static void startGame() {
            System.out.println("🌟✨게임 시작🎉🎇");
    }
}
