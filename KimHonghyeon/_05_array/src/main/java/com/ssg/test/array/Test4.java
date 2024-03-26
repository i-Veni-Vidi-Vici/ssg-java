package com.ssg.test.array;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("전화번호 입력: ");
        String inputNumber = scanner.nextLine();
        String modifiedNumber="";
        for(int i=0; i<11;i++){
            if(i>=3 && i<=6){
                modifiedNumber+="*";
            }
            else{
                modifiedNumber+=inputNumber.charAt(i);
            }
        }
        System.out.println("출력: "+modifiedNumber);

    }
}
