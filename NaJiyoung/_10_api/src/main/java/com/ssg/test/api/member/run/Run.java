package com.ssg.test.api.member.run;

import com.ssg.test.api.member.model.vo.Member;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Run {
    public static void main(String[] args) {
        String str = "1,김연아,165,47,19900905|2,양세형,167,60,19850818|3,김래원,182,80,19810319";
        String[] strArr = str.split("[|,]");

        final int MAX_NUM = 3;
        Member[] members = new Member[MAX_NUM];
        LocalDate birth;

        for (int i = 0; i < members.length; i++) {
            members[i] = new Member();

            abc:
            for (int j = 5 * i; j < strArr.length; j++) {
                switch (j % 5) {
                    case 0:
                        members[i].setMemberNo(Integer.parseInt(strArr[j]));
                        break;
                    case 1:
                        members[i].setMemberName(strArr[j]);
                        break;
                    case 2:
                        members[i].setHeight(Integer.parseInt(strArr[j]));
                        break;
                    case 3:
                        members[i].setWeight(Integer.parseInt(strArr[j]));
                        break;
                    case 4:
                        birth = LocalDate.parse(strArr[j], DateTimeFormatter.ofPattern("yyyyMMdd"));
                        members[i].setBirth(birth);
                        break abc;
                }
            }
            System.out.println(members[i].information());
        }
    }
}
