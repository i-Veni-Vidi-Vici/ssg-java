package com.ssg.thread.sleep;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SleepTest {
    public static void main(String[] args) {
        SleepTest sleepTest = new SleepTest();
        sleepTest.sendAphorism();
    }
    public void sendAphorism(){
        String[] strs = {
                "사랑은 오래 참으며",
                "사랑은 교만하지 아니하며",
                "사랑은 무례히 행하지 아니하며",
                "무례히 행하지 아니하며",
                "자기의 유익을 구하지 아니며",
                "성내지 아니하며",
                "악한 것을 생각하지 아니하며",
                "불의를 기뻐하지 아니하며",
                "진리와 함께 기뻐하고",
                "모든 것을 참으며 모든 것을 믿으며",
                "모든 것을 바라며 모든것을 견디느니라"
        };
        boolean[] numchk = new boolean[strs.length];
        Arrays.fill(numchk, false);
        int cnt = 0;
        while(cnt< strs.length){
            int tmp = (int)(Math.random() * strs.length);
            if(!numchk[tmp]){
                System.out.println(strs[tmp]);
                numchk[tmp]=true;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                cnt++;
            }
        }
    }
}
