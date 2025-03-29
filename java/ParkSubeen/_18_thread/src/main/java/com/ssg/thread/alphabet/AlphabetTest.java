package com.ssg.thread.alphabet;

public class AlphabetTest {
    public static void main(String[] args) {
        Thread upperEng = new Thread(() -> {
            for (int i = 'A'; i <= 'Z'; i++) {
                System.out.println("UpperEng : " + (char)i);
            }
        });

        Thread lowerEng = new Thread(() -> {
            for(int i = 'a'; i <= 'z'; i++) {
                System.out.println("    LowerEng : " + (char)i);
            }
        });

        upperEng.start();
        lowerEng.start();
    }
}
