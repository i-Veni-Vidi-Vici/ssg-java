package com.ssh.condition.loop._for;

public class App {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            int j = (i % 2) * 2 + 1;
            for ( ; j > 0; j--) {
                System.out.print("ㅁ");
            }
            System.out.println();
        }
    }
    }

