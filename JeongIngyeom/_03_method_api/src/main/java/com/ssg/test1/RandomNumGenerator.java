package com.ssg.test1;

public class RandomNumGenerator {

    public void generate() {
        int randomNum = (int) (Math.random() * 1000) + 1;
        boolean isBetween300And600 = isBetween300And600(randomNum);
        printResult(randomNum, isBetween300And600);
    }

    private boolean isBetween300And600(int num) {
        return (num >= 300 && num <= 600);
    }

    private void printResult(int num, boolean isBetween300And600) {
        System.out.println("난수 " + num + "가 300 ~ 600의 수인가? : " + (isBetween300And600 ? "Yes" : "No"));
    }
}
