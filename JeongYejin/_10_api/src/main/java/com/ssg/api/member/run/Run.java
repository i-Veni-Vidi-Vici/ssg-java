package com.ssg.api.member.run;

import com.ssg.api.member.model.vo.Member;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Run {
    public static void main(String[] args) {
        String str = "1,김연아,165,47,19900905|2,양세형,167,60,19850818|3,김래원,182,80,19810319";
        String[] arr = str.split("\\|");
        Member[] members = new Member[arr.length];
        for (int i = 0; i < arr.length; i++) {
            String[] variable = arr[i].split(",");
            members[i] = new Member(Integer.parseInt(variable[0]), variable[1], Integer.parseInt(variable[2]), Integer.parseInt(variable[3]), LocalDate.parse(variable[4], DateTimeFormatter.ofPattern("yyyyMMdd")));
            System.out.println(members[i].information());
        }
    }
}