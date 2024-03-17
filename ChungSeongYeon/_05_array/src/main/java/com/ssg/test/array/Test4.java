package com.ssg.test.array;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        // 사용자로부터 전화번호 입력받기
        Scanner sc = new Scanner(System.in);
        System.out.print("번호 입력: ");
        String phoneNum = sc.nextLine();

        // 가운데 번호 4자리를 '*'로 대체해서 출력
        System.out.print("출력: ");
        for (int i = 0; i < phoneNum.length(); i++) {
            if (i >= 3 && i <= 6) {
                System.out.print("*");
            } else {
                System.out.print(phoneNum.charAt(i));
            }
        }
    }
}
