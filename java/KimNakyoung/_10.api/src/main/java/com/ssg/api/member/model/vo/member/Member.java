package com.ssg.api.member.model.vo.member;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Member {
    private int memberNo;
    private String memberName;
    private int height;
    private int weight;
    private LocalDate birth;

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public void initializeMember(String data) {
        String[] memberData = data.split(",");
        this.setMemberNo(Integer.parseInt(memberData[0]));
        this.setMemberName(memberData[1]);
        this.setHeight(Integer.parseInt(memberData[2]));
        this.setWeight(Integer.parseInt(memberData[3]));
        this.setBirth(LocalDate.parse(memberData[4], DateTimeFormatter.ofPattern("yyyyMMdd")));
    }




        String data1 = "1,김연아,165,47,19900905|2,양세형,167,60,19850818|3,김래원,182,80,19810319";
//        String[] arr = data1.split("\\|");


    // 분리한 회원정보 들 회원 객체에 담기
    // 회원객체배열에 추가

    public String information(){
        return "memberNo :" + memberNo +"memberName : " + memberName + "height:" + height + "weight:" + weight + "birth:" + birth;
    }



//    public void printArr() {
//        System.out.println(Arrays.toString(arr));
//    }

}
