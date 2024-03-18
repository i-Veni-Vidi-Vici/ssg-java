package com.sh.test.array;

import java.util.Scanner;

/**
 * - 문자열을 하나 입력 받아 문자 배열에 넣고
 * - 검색할 문자를 하나 입력 받아
 * - 검색 문자가 문자열에 몇 개인지 개수를 출력하는 프로그램을 작성하세요.
 *
 * 출력예시
 * 문자열 입력 : helloworld
 * 검색문자 입력 : l
 * 출력 : 입력하신 문자열 helloworld에서 찾으시는 문자 l은 3개 입니다
 */

public class Test3 {
    public static void main(String[] args){
        Test3 t = new Test3();
        t.test();
    }
    public void test(){
        Scanner sc = new Scanner(System.in);

        System.out.print("문자열 입력 : ");
        String sentence = sc.next();
        System.out.print("검색문자 입력 : ");
        char word = sc.next().charAt(0);

        int count = 0;

        for(int i=0;i<sentence.length();i++){
            if(sentence.charAt(i)==word){
                count++;
            }
        }
        System.out.printf("출력 : 입력하신 문자열 %s에서 찾으시는 문자 %c는 %d개 입니다",sentence,word,count);
    }

}
