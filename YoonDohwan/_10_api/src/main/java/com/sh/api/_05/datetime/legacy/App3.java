package com.sh.api._05.datetime.legacy;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 사용자의 생일을 입력받아서 Calendar 객체로 생성후, 다음 형식으로 출력
 *
 * -당신의 생일은 ? 년 ?월 ?일 입니다.
 *
 *
 */

public class App3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("생일을 입력하세요 : (yyyy-mm-dd)");
        String birthday = sc.nextLine();
        String[] parts = birthday.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]) - 1; // Calendar 클래스에서 월은 0부터 시작하므로 -1
        int dayOfMonth = Integer.parseInt(parts[2]);
        System.out.println("당신의 생일은 ");
        System.out.println(year+"년"+(month+1)+"월"+dayOfMonth+"일 입니다.");


        }

    }

