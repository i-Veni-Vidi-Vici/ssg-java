package com.ssg.thread.alphabet;

public class AlphabetTest {
    public static void main(String[] args) {
        LargeSmall largeSmall = new LargeSmall();

        Runnable upRun = new Large(largeSmall);
        Runnable downRun = new small(largeSmall);

        Thread upTh = new Thread(upRun);
        Thread downTh = new Thread(downRun);

        upTh.setName("대문자");
        upTh.start();

        downTh.setName("소문자");
        downTh.start();

    }

    public static class LargeSmall {
        //true=large, false=small
        private boolean status = true;

        public synchronized void large(char alphabet) {
            if (!status) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.printf("%c ", alphabet);
            status = false;
            notify();
        }

        public synchronized void small(char alphabet) {
            if (status) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.printf("%c ", alphabet);
            status = true;
            notify();
        }


    }


    static class Large implements Runnable {
        private LargeSmall alpa;

        public Large(LargeSmall alpa) {
            this.alpa = alpa;
        }

        @Override
        public void run() {
            for (int i = 'A'; i <= 'Z'; i++) {
                alpa.large((char) i);
            }
        }
    }

    static class small implements Runnable {
        private LargeSmall alpa;

        public small(LargeSmall alpa) {
            this.alpa = alpa;
        }

        @Override
        public void run() {
            for (int i = 'a'; i <= 'z'; i++) {
                alpa.small((char) i);
            }

        }
    }
}



    /*Runnable 생성 쓰레드에 넣기
    public static void main(String[] args) {
        Runnable upRun = new Large();
        Runnable downRun = new small();
        Thread upTh = new Thread(upRun);
        Thread downTh2 = new Thread(downRun);

        upTh.setName("대문자");
        upTh.start();

        downTh2.setName("소문자");
        downTh2.start();
    }

    private static class Large implements Runnable {
        @Override
        public void run() {
            for (int i = 'A'; i <= 'Z'; i++)
                System.out.printf("%c ", i);
        }
    }

    private static class small implements Runnable {
        @Override
        public void run() {
            for (int i = 'a'; i <= 'z'; i++)
                System.out.printf("%c ", i);
        }
    }

}*/



    /* 직업 쓰레드를 구현만 경우
    public static void main(String[] args) {
        upThread upThread= new upThread();
        downThread downThread= new downThread();

        upThread.setName("대문자입니다");
        upThread.start();

        downThread.setName("소문자입니다");
        downThread.start();

    }

    private static class upThread extends Thread{
        @Override
        public void run() {
            for(int i='A';i<='Z';i++)
            {
                System.out.printf("%c ",i);
            }
        }
    }
    private static class downThread extends Thread{
        @Override
        public void run() {
            for(int i='a';i<='z';i++)
            {
                System.out.printf("%c ",i);
            }
        }
    }
    }
    */


