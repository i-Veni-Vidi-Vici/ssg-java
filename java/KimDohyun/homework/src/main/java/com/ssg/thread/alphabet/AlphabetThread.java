package com.ssg.thread.alphabet;

public class AlphabetThread extends Thread {
    private boolean upperCase;

    public AlphabetThread(boolean upperCase) {
        this.upperCase = upperCase;
    }

    @Override
    public void run() {
        char startChar = upperCase ? 'A' : 'a';
        char endChar = upperCase ? 'Z' : 'z';

        for (char c = startChar; c <= endChar; c++) {
            System.out.print(c + " ");
            try {
                // 스레드를 잠시 멈춰 다른 스레드가 실행될 수 있도록 합니다.
                Thread.sleep(100); // 0.1초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
