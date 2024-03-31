package com.member.repository;

import com.member.model.vo.Gold;
import com.member.model.vo.Silver;
import com.member.model.vo.Vip;
import com.member.model.vo.Vvip;

public class MemberRepository {
    Silver[] silvers = new Silver[10];
    Gold[] golds = new Gold[10];
    Vip[] vips = new Vip[10];
    Vvip[] vvips = new Vvip[10];

    // 다음에 추가할 회원 인덱스/지금까지 저장한 회원수
    int silverIndex = 0;
    int goldIndex = 0;
    int vipIndex = 0;
    int vvipIndex = 0;
    public void silverInsert(Silver silver){
        if (silverIndex < 10){
            this.silvers[silverIndex++] = silver;
        }
    }
    public void goldInsert(Gold gold){
        if (goldIndex < 10){
            this.golds[goldIndex++] = gold;
        }
    }
    public void vipInsert(Vip vip){
        if (vipIndex < 10){
            this.vips[vipIndex++] = vip;
        }
    }
    public void vvipInsert(Vvip vvip){
        if (vvipIndex < 10){
            this.vvips[vvipIndex++] = vvip;
        }
    }
    public void printData(){
        System.out.println("---------------<<회원정보>>---------------\n" +
                "이름     등급    포인트     이자포인트\n" +
                "---------------------------------------");
        for (int i = 0; i <silverIndex; i++){
            System.out.printf("%s   %s   %d    %.2f\n".formatted(silvers[i].getName(), silvers[i].getGrade(), silvers[i].getPoint(), silvers[i].getEjapoint()));
        }
        for (int i = 0; i <goldIndex; i++){
            System.out.printf("%s   %s   %d    %.2f\n".formatted(golds[i].getName(), golds[i].getGrade(), golds[i].getPoint(), golds[i].getEjapoint()));
        }
        for (int i = 0; i < vipIndex; i++){
            System.out.printf("%s   %s   %d    %.2f\n".formatted(vips[i].getName(), vips[i].getGrade(), vips[i].getPoint(), vips[i].getEjapoint()));
        }
        for (int i = 0; i < vvipIndex; i++){
            System.out.printf("%s   %s   %d    %.2f\n".formatted(vvips[i].getName(), vvips[i].getGrade(), vvips[i].getPoint(), vvips[i].getEjapoint()));
        }
    }
}
