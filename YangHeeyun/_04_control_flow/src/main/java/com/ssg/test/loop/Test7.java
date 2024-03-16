package com.ssg.test.loop;

public class Test7 {
    public static void main(String[] args){
        Test7 t = new Test7();
        t.test();
    }

    public void test(){
        for(int i=1;i<=9;i++){
            for(int j=1;j<=9;j++){
                if(j<=9-i){
                    System.out.print(' ');
                }else{
                    System.out.print(j-(9-i));
                }
            }
            System.out.print(" x 8 + " + i + " = ");
            for(int k=9;k>=1;k--){
                if(k>9-i){
                    System.out.print(k);
                }
            }
            System.out.println();
        }

    }
}
