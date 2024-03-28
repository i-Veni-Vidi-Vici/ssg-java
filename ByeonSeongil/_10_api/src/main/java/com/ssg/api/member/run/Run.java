package com.ssg.api.member.run;

import com.ssg.api.member.model.vo.Member;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Run {
    public static void main(String[] args) {

        String value = "1,김연아,165,47,19900905|2,양세형,167,60,19850818|3,김래원,182,80,19810319";

        String[] splitValue = value.split("[|]");
        Member[] members = new Member[3];
        int index = 0;
        for (String s : splitValue) {
            String[] data = s.split(",");
            members[index++] = new Member(
                    Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]),
                    Integer.parseInt(data[3]), LocalDate.parse(data[4], DateTimeFormatter.ofPattern("yyyyMMdd")));
        }

        for (Member member : members) {
            System.out.println(member.information());
        }
    }
}
