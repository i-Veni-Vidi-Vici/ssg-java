package com.ohgiraffers.hw3.member.repository;

import com.ohgiraffers.hw3.member.model.vo.Gold;
import com.ohgiraffers.hw3.member.model.vo.Silver;
import com.ohgiraffers.hw3.member.model.vo.VVip;
import com.ohgiraffers.hw3.member.model.vo.Vip;

public class MemberRepository {
    Silver[] silver = new Silver[];
    Gold[] gold = new Gold[];
    Vip[] vip = new Vip[];
    VVip[] vvip = new VVip[];

    int silverIndex = 0;
    int goldIndex = 0;
    int vipIndex = 0;
    int vvipIndex = 0;

    public void silverInsert(Silver silver){
        if(silverIndex < 10)
            this.silver[silverIndex++] = silver;
    }

    public void goldInsert(Gold gold){
        if(goldIndex < 10)
            this.gold[goldIndex++] = gold;
    }

    public void vipInsert(Vip vip) {
        if(vipIndex < 10)
            this.vip[vipIndex++] = vip;
    }

    public void vvipInsert(VVip vvip) {
        if(vvipIndex < 10)
            this.vvip[vvipIndex++] = vvip;
    }

    public void printData(){
        System.out.println("---------------------------<<회원정보>>---------------------------");
        System.out.println("이름              등급             포인트         이자포인트");
        System.out.println("-----------------------------------------------------------------");

        for(int i=0;i<silverIndex;i++){
            System.out.printf("%-15s %-15s %-15d %-15.2f\n", silver[i].getName(),silver[i].getGrade(), silver[i].getPoint(), silver[i].getEjapoint());
        }
        for(int i=0;i<goldIndex;i++){
            System.out.printf("%-15s %-15s %-15d %-15.2f\n", gold[i].getName(),gold[i].getGrade(), gold[i].getPoint(), gold[i].getEjapoint());
        }
        for(int i=0;i<vipIndex;i++){
            System.out.printf("%-15s %-15s %-15d %-15.2f\n", vip[i].getName(),vip[i].getGrade(), vip[i].getPoint(), vip[i].getEjapoint());
        }
        for(int i=0;i<vvipIndex;i++){
            System.out.printf("%-15s %-15s %-15d %-15.2f\n", vvip[i].getName(),vvip[i].getGrade(), vvip[i].getPoint(), vvip[i].getEjapoint());
        }
    }
}
