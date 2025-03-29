package com.ssg.test.array;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        String[] arr = new String[1];
        Scanner sc = new Scanner(System.in);
        System.out.print("> 문자열 입력 : ");
        String str = sc.nextLine();
        arr[0] = str;
        System.out.print("> 검색문자 입력 : ");
        char ch = sc.next().charAt(0);

        // str 문자열 길이 charAt으로 따로 구하기
        // if charAt이 ch랑 같으면 sum+=1
        int sum = 0;
        for (int i = 0; i < str.length(); i++){
            char strCh = str.charAt(i);
            if (strCh == ch){
                sum += 1;
            }
        }
        System.out.printf("입력하신 문자열 %s에서 찾으시는 문자 %s는 %d개 입니다.\n", str, ch, sum);
    }
}
