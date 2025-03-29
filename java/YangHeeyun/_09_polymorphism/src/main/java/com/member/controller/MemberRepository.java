package com.member.controller;

import com.member.model.vo.Buyable;
import com.member.model.vo.Member;

public class MemberRepository  {
    private Member[] member = new Member[40];
    private int index = 0;

    public void insertMember(Member m){
        this.member[index++] = m;
    }

    public void printData(){
        System.out.println("---------------------------<<회원정보>>---------------------------");
        System.out.printf("%-15s %-15s %-15s %-15s\n", "이름", "등급", "포인트", "이자포인트");
        System.out.println("-----------------------------------------------------------------");

        for(int i=0;i<index;i++){
            Member m = member[i];
            System.out.printf("%-15s %-15s %-15d %-15.2f\n",
                    m.getName(),m.getGrade(),
                    m.getPoint(), m.getEjapoint());
        }
    }

    public void printBuyInfo(int price){
        System.out.println("-----------------------------------------------------------");
        for(int i=0;i<index;i++) {
            Member m = member[i];
            System.out.printf("%s등급회원 %s은 %d원 상품을 %d원에 구매합니다.\n",
                  m.getGrade(), m.getName(), price, m.buy(price));
        }
    }
}

