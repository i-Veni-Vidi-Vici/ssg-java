package com.ssg.api.member.run;

import com.ssg.api.member.model.vo.Member;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 다음과 같이 회원정보를 하나의 문자열로 존재한다.
 * "1,김연아,165,47,19900905|2,양세형,167,60,19850818|3,김래원,182,80,19810319"
 *
 * 각회원별 정보의 순서는 회원번호,이름,키,몸무게,생일(yyyyMMdd)이다.
 * 각각의 회원정보를 분리해서, 회원객체에 담고, 회원객체배열에 추가한다.
 * 출력메소드를 통해 회원정보를 출력한다.
 */

public class Run {
    public static void main(String[] args) {
        String data = "1,김연아,165,47,19900905|2,양세형,167,60,19850818|3,김래원,182,80,19810319";
        String[] memberArr = data.split("\\|");
        Member[] members = new Member[memberArr.length];

        for(int i=0;i< memberArr.length;i++){
            String[] mbValue = memberArr[i].split(",");
            members[i] = new Member(Integer.parseInt(mbValue[0]),mbValue[1],Integer.parseInt(mbValue[2]),
                    Integer.parseInt(mbValue[3]), LocalDate.parse(mbValue[4], DateTimeFormatter.ofPattern("yyyyMMdd")));
            System.out.println(members[i].information());
        }
    }
}
