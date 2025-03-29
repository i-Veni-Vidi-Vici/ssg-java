package com.sh._04.checked;

import java.util.Scanner;

/**
 * <pre>
 *  성인용 게임을 작성해주세요.
 *  - 프로그램 시작 시에 나이를 입력 받고 , 20세 미만인 경우 게임을 시작하면 중단합니다.
 *  - 성인인 경우만 게임을 시작하세요
 *  - 게임의 내용은 🏀🥞를 출력하는 걸로 대체
 *  - MemberAgeChecker 클래스에 checkAGe 메소드를 작성하세요
 *  - 적절한 커스텀 예외 클래스를 생성해 사용하세요
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
          int age = 1;
        //게임 정상 시작

            try {
                MemberAgeCheck memberAgeCheck = new MemberAgeCheck();
                age = scanner.nextInt();
                memberAgeCheck.checkAge(age);
                System.out.println("게임을 시작합니다. ");
                System.out.println("Start : 🥞🏎");

            } catch (LimitAgeException e) {
                System.out.println("나이 오류 :" + e.getMessage());
            }
        //미성년자용 메세지



    }
}
