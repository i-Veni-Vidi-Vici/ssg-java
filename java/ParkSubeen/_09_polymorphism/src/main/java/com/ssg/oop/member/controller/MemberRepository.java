package com.ssg.oop.member.controller;


import com.ssg.oop.member.model.vo.Member;
import com.ssg.oop.member.model.vo.Silver;

public class MemberRepository {
    private final int MAX_NUM = 40;
    Member[] members = new Member[MAX_NUM];
    int index;
    public void insertMember(Member m) {
            members[index++] = m;
    }

    public void printData() {
        System.out.println("----------------------  정보출력  ------------------------");
        System.out.println("이름            등급            포인트           이자포인트");
        for(int i = 0; i < index; i++) {
            Member member = members[i];
            System.out.printf("%s         %s           %d             %.2f\n", member.getName(), member.getGrade(), member.getPoint(), member.getEjaPoint());
        }
    }

    public void printBuyInfo(int price) {
        for(int i = 0; i < index; i++) {
            Member member = members[i];
            System.out.println(member.getGrade() + "등급회원 " + member.getName() + "는 " + price + "원 상품을 " + member.buy(price) + "원에 구매합니다.");
        }
    }
}
