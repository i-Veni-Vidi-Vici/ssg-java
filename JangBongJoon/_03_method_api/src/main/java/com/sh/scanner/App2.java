package com.sh.scanner;


import java.util.Scanner;

/*
<pre>
next메서드 (nextInt,nextDouble,nextBoolean)
공백 개행문자 전까지 읽어서 반환
nextLine
개행문자까지 읽어서 개행문자 제거후 반환

</pre>
 */
public class App2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("주소 입력: ");
        String address = sc.nextLine();

        System.out.println("> 입력한 주소는 [" + address + " ]입니다.");

    }
}
