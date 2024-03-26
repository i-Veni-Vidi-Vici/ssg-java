package com.ssg.member.controller;

import com.ssg.member.model.vo.*;

public class MemberRepository {
    int MAX_INDEX = 40; // (자동으로 public static final)
    Member[] members = new Member[MAX_INDEX];
    int index = 0;
    public void insertMember(Member m) {
        members[index++] = m;
    }

    public void printData() {
        if (index < MAX_INDEX) {
            for (int i = 0; i < index; i++) {
                System.out.println(members[i].getName() + " " + members[i].getGrade() + " " + members[i].getPoint() + " " + members[i].EjaPoint());
            }
        }
    }

    public void printBuyInfo(int price) {
        for (int i = 0; i < index; i++) {
            int discount = members[i].buy(price);
            System.out.printf("%s등급회원 %s은(는) %d원 상품을 %d원에 구매합니다.\n",members[i].getGrade(), members[i].getName(), price, price-discount);
        }
    }
}