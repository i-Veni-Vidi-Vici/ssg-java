package com.member.repository;

import com.member.model.vo.Member;

public class MemberRepository {

    private Member[] members = new Member[40];
    private int index;

    public void insertMember(Member member) {
        this.members[index++] = member;
    }


    public void printData() {
        System.out.println("---------------------------<<회원정보>>---------------------------");
        System.out.println("이름              등급             포인트         이자포인트");
        System.out.println("-----------------------------------------------------------------");

        for (Member member : members) {
            if (member == null) {
                break;
            }
            System.out.printf("%-14s %-16s %-13d %.2f\n", member.getName(), member.getGrade(), member.getPoint(),
                    member.getEjapoint());
        }
    }

    public void printBuyInfo(int price) {
        for (Member member : members) {
            if (member == null) {
                break;
            }
            System.out.println(
                    member.getGrade() + "등급 회원" + member.getName() + "는" + price + "원 상품을" + member.buy(price)
                            + "원에 구매합니다.");
        }
    }

}
