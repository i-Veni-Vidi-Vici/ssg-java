package com.ssg.test.array;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        String inputString;
        Scanner scanner = new Scanner(System.in);
        System.out.print("문자열 입력: ");
        inputString = scanner.nextLine();
        System.out.print("찾을 문자 입력: ");
        char target = scanner.next().charAt(0);
        int count=0;
        for(int i =0; i<inputString.length(); i++){
            if(inputString.charAt(i)==target)count++;
        }
        System.out.println("입력한 문자열에 문자 "+target+"는 "+count+"개 있습니다.");
    }
}
