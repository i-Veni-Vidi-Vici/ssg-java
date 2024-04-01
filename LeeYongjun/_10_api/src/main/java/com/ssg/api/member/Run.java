package com.ssg.api.member;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Run {
    public static void main(String[] args) {
        String memberInfo = "1,김연아,165,47,19900905|2,양세형,167,60,19850818|3,김래원,182,80,19810319";

        String[] member = memberInfo.split("\\|");

        // 회원 객체 배열 생성
        Member[] memberArray = new Member[member.length];


        for(int i = 0; i < member.length; i++) {
            String[] memberData = member[i].split(",");

            int memberNo = Integer.parseInt(memberData[0]);
            String memberName = memberData[1];
            int height = Integer.parseInt(memberData[2]);
            int weight = Integer.parseInt(memberData[3]);
            LocalDate birth = LocalDate.parse(memberData[4], DateTimeFormatter.ofPattern("yyyyMMdd"));

            Member member2 = new Member(memberNo, memberName, height, weight, birth);
            memberArray[i] = member2;
        }

        for (Member member2 : memberArray) {
            System.out.println(member2.information());
        }
    }
}

