package com.sh._04.checked;

import java.util.Scanner;

/**
 * <pre>
 * 성인용 게임을 작성해주세요
 * - 프로그램 시작시에 나이를 입력받고, 20세 미만인 경우 게임을 중단합니다
 * - 성인인 경우만 게임을 시작하세요
 * - 게임의 내용은 🧟‍♂️🧟‍♂️🧝‍♀️🖖🤞👃를 출력하는 걸로 대체합니다
 * - MemberAgeChecker클래스 CheckAge메소드를 작성하세요
 * - 적절한 커스텀 예외클래스를 생성해 사용하세요
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        MemberAgeChecker memberAgeChecker=new MemberAgeChecker();
        Scanner sc = new Scanner(System.in);
        int age;

        try {
            age=sc.nextInt();
            memberAgeChecker.checkAge(age);
            //게임 정상시작
            System.out.println("\u200D♂\uFE0F\uD83E\uDDDF\u200D♂\uFE0F\uD83E\uDDDD\u200D♀\uFE0F\uD83D\uDD96\uD83E\uDD1E\uD83D\uDC43");

        }catch (NotValidMemberAgeException e)
        {
            //미성년자용 메세지
            System.out.println("에러 코드 : "+e.getMessage());
        }


    }
}
