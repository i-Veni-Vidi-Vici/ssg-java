package com.ssg.thread.sleep;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SleepTest {
    public static void main(String[] args) {
        SleepTest sleepTest = new SleepTest();
        sleepTest.sendAphorism();
    }

    public void sendAphorism() {
        String[] wiseSaying = {"계란으로 바위치기",
                        "고기도 먹어본 사람이 많이 먹는다",
                        "고래 싸움에 새우 등 터진다",
                        "고양이한테 생선 맡겼다",
                        "고인 물은 썩는다",
                        "공든 탑이 무너지랴",
                        "구관이 명관이다",
                        "구슬이 서말이라도 꿰어야 보배",
                        "귀신이 곡할 노릇이다",
                        "길고 짧은 것은 대어 봐야 안다"
                        };

        Random rnd = new Random();
        Set<String> strSet = new HashSet<>();
        while(strSet.size() < 10) {
            int random = rnd.nextInt(10);
            strSet.add(wiseSaying[random]);
        }


        try {
            for(String str : strSet) {
                System.out.println(str);
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    public void sendAphorism() {
//        String messages[] = {
//                "Pride will have a fall.",
//                "Power is dangerous unless you have humility.",
//                "Office changes manners.",
//                "Empty vessels make the most sound.",
//                "Heaven helps those who help themseleves.",
//                "Things change.",
//                "Forgive yorself before you die. Then forgive others.",
//                "Don't let go too soon, but don't hang on too soon.",
//                "Accept what you are able to do and what you are not able to do.",
//                "Accept what past as past, whthout denying or discarding it."
//        };
//
//
//        //0.String[] => List<String>
//        List<String> temp = Arrays.asList(messages);
//
//        //1.순서섞기
//        Collections.shuffle(temp);
////		System.out.println(temp);
//
//
//        //2.Queue생성
//        Queue<String> queue = new LinkedList<>(temp);
//
//        // 추가 offer(E), 제거 poll():E
//        while(queue.size() > 0) {
//            System.out.println(queue.poll());
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}



