package com.ssg.random.coin;

import java.util.Scanner;

public class Game {

    public void flipCoin() {
        printStartMessage();
        int input = inputOneOrTwo();
        int correct = (int) (Math.random() * 2) + 1;
        printResult(input, correct);
    }

    private void printStartMessage() {
        System.out.println("=== 동전 앞 뒤 맞추기 ===");
        System.out.print("숫자를 입력해주세요 (1.앞면 / 2.뒷면) : ");
    }

    private int inputOneOrTwo() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private void printResult(int input, int correct) {
        System.out.println("\n" + (input == correct ? "맞췄습니다^^" : "땡! 틀렸습니다!") + "\n");
    }

    public void printRestartMessage() {
        System.out.println("-------------------------------->restart");
    }
}
