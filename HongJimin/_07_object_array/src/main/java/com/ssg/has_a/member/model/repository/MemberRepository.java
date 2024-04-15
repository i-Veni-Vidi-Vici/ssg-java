package com.ssg.has_a.member.model.repository;

import com.ssg.has_a.member.model.vo.*;



public class MemberRepository{
    Silver[] silvers = new Silver[10];
    Gold[] golds = new Gold[10];
    Vip[] vips = new Vip[10];
    VVip[] vVips = new VVip[10];
    Ruby[] rubies = new Ruby[10];
    Member[] members = new Member[40];

    int silverCount = 0;
    int goldCount = 0;
    int vipCount = 0;
    int vvipCount = 0;
    int rubyCount = 0;
    int memberCount = 0;
    public void silverInsert(Silver silver) {
        silvers[silverCount] = silver;
        silverCount++;
    }

    public void goldInsert(Gold gold) {
        golds[goldCount] = gold;
        goldCount++;
    }


    //vip, vvip 추가
    public void vipInsert(Vip vip) {
        vips[vipCount] = vip;
        vipCount++;
    }

    public void vvipInsert(VVip vVip) {
        vVips[vvipCount] = vVip;
        vvipCount++;
    }

    public void insertMember(Member m) {
        members[memberCount] = m;
        memberCount++;
    }

    public void printData() {
        System.out.print("""
               ---------------------------<<회원정보>>---------------------------
                이름             등급            포인트          이자포인트
               -----------------------------------------------------------------
                """);
        for (int i = 0; i < memberCount; i++) {
            if(members[i] == null) break;
            System.out.println(
                    members[i].getName() +"\t\t\t"
                            + members[i].getGrade() +"\t\t\t"
                            + members[i].getPoint() +"\t\t\t"
                            + members[i].getEjapoint());

        }
    }

    public void printBuyInfo(int price){

        for(int i = 0; i < memberCount; i++){
            if(members[i] == null) break;

            System.out.println(
                    members[i].getGrade() + "등급회원 " +
                    members[i].getName() + "는 10000원 상품을" +
                     " 원에 구매합니다."
            );
        }
    }

}
