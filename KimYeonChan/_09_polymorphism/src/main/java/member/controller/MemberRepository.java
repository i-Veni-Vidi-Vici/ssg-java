package member.controller;

import member.model.vo.Member;

public class MemberRepository {
    private Member[] members = new Member[40];
    private int index;

    public void insertMember(Member m){
        members[index++] = m;
    }

    public void printData() {
        System.out.println("""
                ---------------------------<<회원정보>>---------------------------
                이름              등급              포인트             이자포인트
                ----------------------------------------------------------------""");

        for (int i = 0; i < index; i++) {
            System.out.printf("%s            %s            %s              %d\n",
                    members[i].getName(), members[i].getGrade(), members[i].getPoint(), (int)members[i].getEjapoint());
        }
    }

    public void printBuyInfo(int price) {
        for (int i = 0; i < index; i++) {
            System.out.printf("%s등급회원 %s는 %d원 상품을 %d원에 구매합니다.\n", members[i].getGrade(), members[i].getName(), price, members[i].buy(price));
        }
    }
}
