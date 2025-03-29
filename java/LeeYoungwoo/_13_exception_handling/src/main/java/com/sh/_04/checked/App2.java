package com.sh._04.checked;

import java.util.Scanner;

/**
 * <pre>
 * 성인용 게임을 작성해주세요
 * - 프로그램 시작시에 나이를 입력받고, 20세 미만인 경우 게임을 중단합니다.
 * - 성인인 경우만 게임을 시작하세요.
 * - 게임의 내용은 🎈🎆🎇🧨를 출력하는 것으로 대체합니다.
 * - MemberAgeChecker클래스에 checkAge메소드를 작성하세요.
 * - 적절한 커스텀 예외클래스를 생성해 사용하세요.
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        try {
            MemberAgeChecker memberAgeChecker = new MemberAgeChecker();
            memberAgeChecker.checkAge();
            // 게임 정상 시작
            System.out.println("🎈🎆🎇🧨");
        } catch (ageException e) {
            // 미성년자용 메세지
            System.out.println("미성년자는 게임을 이용할 수 없습니다 : " + e.getMessage());
        }

    }
}
