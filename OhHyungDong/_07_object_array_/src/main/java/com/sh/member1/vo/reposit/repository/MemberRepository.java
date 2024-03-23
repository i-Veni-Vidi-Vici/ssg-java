package com.sh.member1.vo.reposit.repository;

import com.sh.member.model.vo.Gold;
import com.sh.member.model.vo.Silver;
import com.sh.member.model.vo.VVip;
import com.sh.member.model.vo.Vip;

public class MemberRepository {
    /**
     * 1. MemberRepository에 silver, gold 객체 생성
     * 2. 프린트
     */

    private Silver[] silvers = new Silver[10];
    private Gold[] golds = new Gold[10];
    private Vip[] vips = new Vip[10];
    private VVip[] vvips = new VVip[10];
    int index  = 0 ; //멤버 인수
    public void silverInsert(Silver silver){
        if(index < 10 ){
            silvers[index] = silver;
            index++;
        }
        else System.out.println("저장공간이 부족합니다.");
    }

    public void goldInsert(Gold gold){
        if(index < 10 ){
            golds[index] = gold;
            index++;
        }
        else System.out.println("저장공간이 부족합니다.");
    }
    public void vipInsert(Vip vip){
        if(index < 10 ){
            vips[index] = vip;
            index++;
        }
        else System.out.println("저장공간이 부족합니다.");
    }
    public void vvipInsert(VVip vvip){
        if(index < 10 ){
            vvips[index] = vvip;
            index++;
        }
        else System.out.println("저장공간이 부족합니다.");
    }

    public void printData() {

        System.out.print("""
                ------------<<회원 정보>>---------------
                이름      등급     포인트   이자포인트
                --------------------------------------
                """);
        for (Silver silver : silvers)
        {// if문 없었을 때 에러가 발생했는데 왜 에러가 발생했었나요 어처피 값이 있으면 무조건 나오는거 아닌가 ?
            if (silver != null)
            {
                System.out.printf("%s    %s   %d   %.1f\n",
                        silver.getName(), silver.getGrade(), silver.getPoint(),silver.getEjaPoint());
            }
        }
        for(Gold gold : golds){
            if(gold != null){
                System.out.printf("%s    %s   %d   %.1f \n",
                        gold.getName(), gold.getGrade(), gold.getPoint(),gold.getEjapoint());
            }
        }
        for(Vip vip : vips){
            if(vip != null){
                System.out.printf("%s    %s   %d   %.1f\n",
                        vip.getName(), vip.getGrade(), vip.getPoint(), vip.getEjaPoint());
            }
        }
        for(VVip vvip : vvips)
        {
            if(vvip != null)
            {
                System.out.printf("%s    %s   %d   %.1f\n",
                        vvip.getName(), vvip.getGrade(), vvip.getPoint(), vvip.getEjaPoint());
            }
        }
    }
}
