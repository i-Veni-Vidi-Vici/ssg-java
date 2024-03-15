package com.sh.branching;

public class Break {
    public void test2(){
        abc:
        for (int dan = 2; dan < 10; dan++) {
            for (int n = 1; n < 10; n++) {
                if (dan * 50 > 50) {
                    break abc;
                }
                System.out.printf("%d * %d = %d\n", dan, n, dan * n);
            }
        }
    }


}
