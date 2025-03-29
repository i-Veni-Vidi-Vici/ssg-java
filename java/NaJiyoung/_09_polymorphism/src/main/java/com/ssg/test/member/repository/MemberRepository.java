package com.ssg.test.member.repository;

import com.ssg.test.member.model.vo.*;

public class MemberRepository{
    private static final int MAX_MEMBER = 40;
    private Member[] members = new Member[MAX_MEMBER];   // has-a 포함관계
    private int index = 0;  // 객체 배열 인덱스

    public void insertMember(Member m) {
        this.members[index++] = m;
    }

    public void printData() {
        String inform = """
        ----------------------   정보출력   ------------------------
        이름              등급              포인트             이자포인트
        """;

        System.out.print(inform);

        for(int i=0; i<index; i++) {
            Member m = members[i];
            System.out.printf("%s%15s%15d%15.2f\n", m.getName(), m.getGrade(), m.getPoint(), m.getEjapoint());
        }
        System.out.println("-----------------------------------------------------------");
    }

    public void printBuyInfo(int price) {
        for(int i=0; i<index; i++) {
            Member m = members[i];
            System.out.printf("%s등급회원 %s는 %d원 상품을 %d원에 구매합니다.\n", m.getGrade(), m.getName(), price, m.buy(price));
        }

        System.out.println("-----------------------------------------------------------");
    }
}
