package com.ssg.oop.calc.member.controller;

import com.ssg.oop.calc.member.model.vo.Gold;
import com.ssg.oop.calc.member.model.vo.Member;
import com.ssg.oop.calc.member.model.vo.Silver;
import com.ssg.oop.calc.member.model.vo.Vip;

public class MemberRepository
{
    Member[] members = new Member[40];
    int index = 0;

    public Member insertMember(Member m)
    {
        if(index < 40){
            members[index] = m;
            index++;
            return m;
        }
        else{
            System.out.println("더 이상 Silver나 Gold의 멤버들을 추가 할 수 없습니다. ");
            return null;
        }

    }


    public void printData() {

        System.out.print("""
                ------------<<회원 정보>>---------------
                이름      등급     포인트   이자포인트
                --------------------------------------
                """);
        for (Member member : members)
        {
            if (member != null)
            {
                System.out.printf("%s    %s   %.0f   %.1f\n",
                        member.getName(), member.getGrade(), member.getPoint(),member.getEjapoint());
            }
        }

    }
    public void printBuyInfo(int price){
        System.out.println("---------------------------------------------------");
        for(Member member : members){
            if(member != null) {
                System.out.println(member.getGrade() + "등급 회원 " + member.getName() + "는 " +
                        price + "원 상품을 " + member.buy(price) + "원에 구매합니다.");
            }
        }
    }
}
