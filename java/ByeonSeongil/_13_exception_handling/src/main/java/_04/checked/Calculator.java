package _04.checked;

import java.util.Scanner;

public class Calculator {
    public static int plus(int m, int n) {
        return m + n;
    }

    // 다른 클래스 static메서드
    public static int minus(int m, int n) {
        return m - n;
    }

    public static int multiply(int m, int n) {
        return m * n;
    }

    public static int devide(int m, int n) {
        return m / n;
    }

    public static int mod(int m, int n) {
        return m/n;
    }

    public void sum() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("숫자1:");
                int num1 = sc.nextInt();
                System.out.print("숫자2:");
                int num2 = sc.nextInt();
                System.out.println(num1+ num2);
                break;
            } catch (Exception e) {
                System.out.println("\""+sc.next()+"\"");
                System.out.println("유효한 정수를 입력해주세요.");
            }
        }
    }
}
