package com.sh.multi.dimention;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
       package com.ssg.thread.sleep;

import java.util.Random;

        public class SleepTest {
            private static final String[] aphorisms = {
                    "시작이 반이다.",
                    "노력은 배신하지 않는다.",
                    "오늘의 선택은 내일의 나를 결정한다.",
                    "기회는 새로운 노는 날개를 가진다.",
                    "한 걸음씩 나아가다 보면 산도 오르겠지.",
                    "물러나서는 안 되지만, 때로는 쉬어야 한다.",
                    "실패는 재도전의 기회이다.",
                    "어려운 길일수록 그 아름다움이 크다.",
                    "열정은 모든 것을 이긴다.",
                    "작은 변화가 큰 성공을 만든다."
            };

            public static void main(String[] args) {
                sendAphorism();
            }

            public static void sendAphorism() {
                Random random = new Random();
                int[] indexes = new int[10]; // 10개의 인덱스를 기억하기 위한 배열
                int count = 0;

                while (count < 10) {
                    int index = random.nextInt(aphorisms.length);
                    boolean alreadyPrinted = false;

                    // 중복 체크
                    for (int i = 0; i < count; i++) {
                        if (indexes[i] == index) {
                            alreadyPrinted = true;
                            break;
                        }
                    }

                    // 중복되지 않은 경우 출력
                    if (!alreadyPrinted) {
                        System.out.println(aphorisms[index]);
                        indexes[count] = index;
                        count++;
                    }

                    try {
                        Thread.sleep(3000); // 3초 대기
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    }
}
