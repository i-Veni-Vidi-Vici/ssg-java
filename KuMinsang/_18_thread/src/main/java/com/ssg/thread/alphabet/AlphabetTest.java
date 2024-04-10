package com.ssg.thread.alphabet;

public class AlphabetTest {
    public static void main(String[] args) {
        UpperCase upper = new UpperCase();
        LowerCase lower = new LowerCase();

        upper.start();
        lower.start();
    }

    static class UpperCase extends Thread{
        public void run(){
            for(int i = 'A'; i<(int)'Z'; i++){
                System.out.print((char)i);
            }
        }
    }

    static class LowerCase extends Thread{
        public void run(){
            for(int i = 'a'; i<(int)'z'; i++){
                System.out.print((char)i);
            }
        }
    }

}
