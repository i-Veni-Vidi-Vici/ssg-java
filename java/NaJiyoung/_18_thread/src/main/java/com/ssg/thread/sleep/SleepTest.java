package com.ssg.thread.sleep;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SleepTest {
    public static void main(String[] args) {
        new SleepTest().sendAphorism();
    }

    public void sendAphorism() {
        String messages[] = {
                "Pride will have a fall.",
                "Power is dangerous unless you have humility.",
                "Office changes manners.",
                "Empty vessels make the most sound.",
                "Heaven helps those who help themseleves.",
                "Things change.",
                "Forgive yorself before you die. Then forgive others.",
                "Don't let go too soon, but don't hang on too soon.",
                "Accept what you are able to do and what you are not able to do.",
                "Accept what past as past, whthout denying or discarding it."
        };

        Set<Integer> rndSet = new LinkedHashSet<>();
        while (rndSet.size() < 10)
            rndSet.add((int)(Math.random() * 10));

        Thread thread = new Thread(() -> {
            for(int rnd : rndSet) {
               try {
                   Thread.sleep(3000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(messages[rnd]);
           }
        });
        thread.start();
    }
}
