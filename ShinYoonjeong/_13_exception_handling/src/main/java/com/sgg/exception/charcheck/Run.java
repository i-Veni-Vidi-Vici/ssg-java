package com.sgg.exception.charcheck;



import java.util.Scanner;

public class Run {
    // 실행 메소드
    public void test1() {
        CharacterProcess charProcess = new CharacterProcess();
        try {
            // 사용자로부터 문자열 입력 받기
            Scanner scanner = new Scanner(System.in);
            System.out.print("문자열을 입력하세요: ");
            String input = scanner.nextLine();
            scanner.close();

            // 문자열의 영문자 개수 세기
            int alphaCount = charProcess.countAlpha(input);
            System.out.println("입력한 문자열의 영문자 개수는 " + alphaCount + "개입니다.");
        } catch (CharCheckException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Run run = new Run();
        run.test1();
    }
}