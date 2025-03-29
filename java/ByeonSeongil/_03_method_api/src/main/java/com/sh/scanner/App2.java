package com.sh.scanner;

import java.util.Scanner;

/**
 * <pre>

 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 주소 읽어오기
        System.out.println("주소 입력 : ");
        String address = sc.nextLine();

        System.out.println("> 입력한 주소는 [" + address +"]입니다.");
    }
}
