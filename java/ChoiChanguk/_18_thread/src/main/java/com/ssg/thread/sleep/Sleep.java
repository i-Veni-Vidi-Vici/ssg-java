package com.ssg.thread.sleep;

import java.time.LocalTime;

public class Sleep {
    public static void main(String[] args) {

        //Runnable을 만들어서 쓰레드에 넣는다 방법2
        //Runnable runnable=new myRunnable();
        //Thread th1=new Thread(runnable);
        //th1.start();

        //쓰레드를 만들어서 쓴다 방법1
        //myThread th1=new myThread();
        //th1.start();

        sendAphorism();
    }

    private static void sendAphorism ()
    {
        String[] str=new String[]{"빨리 일어나는 새가 힘들다","가는 말이 고우면 오는 말은 더럽다","늦었다고 생각할 떄가 제일 늦다","시작은 단지 시작일 뿐이다",
                "겨울은 춥고, 여름은 덥다","봄, 가을엔 미세먼지가 많다","석촌호수에는 벚꽃보다 사람이 많다","애벌레는 당연히 꿈틀거린다","아이스크림은 칼로리가 없으면 좋겟다","먹어도 먹어도 살이 안찌면 좋겟다"
        };
        for(int i=0;i<10;i++) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LocalTime.now().getSecond() + "초입니다, 속담 : " + str[(int) (Math.random() * 10)]);
        }
    }

    private static class myThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    myThread.sleep(3000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sendAphorism();
            }
        }
    }

    private static class myRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    sendAphorism();
                    myThread.sleep(3000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
