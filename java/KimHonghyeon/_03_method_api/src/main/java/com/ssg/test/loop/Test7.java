package com.ssg.test.loop;

public class Test7 {
    public static void main(String[] args) {
        String answer ="";
        for(int i = 1; i<=9; i++){
            String firstOperand = "";
            for(int j =1; j<=i; j++){
                firstOperand += String.valueOf(j);
            }
            String leftSpace = "";
            for(int j = 9; j>i; j--){
                leftSpace+=" ";
            }
            String secondOperand = "";
            for(int j = 9; j>9-i; j--){
                secondOperand+=String.valueOf(j);
            }
            String rightSpace = "";
            for(int j = 9; j>i; j--){
                rightSpace+=" ";
            }
            answer += leftSpace + firstOperand + " x 8 + "+i+" = "+secondOperand+rightSpace+"\n";
        }
        System.out.printf(answer);
    }

}
