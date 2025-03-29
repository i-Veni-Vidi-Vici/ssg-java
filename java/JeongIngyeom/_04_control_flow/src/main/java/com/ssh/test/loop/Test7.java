package com.ssh.test.loop;

public class Test7  {

    public static void main(String[] args) {
        int n = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 8 - i; j >= 0; j--) {
                System.out.print(' ');
            }

            n = n * 10 + i;
            System.out.printf("%d x 8 + %d = %d\n", n, i, n * 8 + i);
        }
    }
}
