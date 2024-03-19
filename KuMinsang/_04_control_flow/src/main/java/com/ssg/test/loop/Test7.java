package com.ssg.test.loop;


    public class Test7 {
        public static void main(String[] args) {
            int num=0;
            for(int i= 0; i<9; i++){
                num = num * 10 +i+1;
                for(int j=8; j>i; j--){
                    System.out.print(" ");
                }
                System.out.println(num +" x 8 + 1 = "+ (num*8+i+1));
            }
        }
    }
