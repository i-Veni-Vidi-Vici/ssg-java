package com.ssg.member.repository;

import com.ssg.member.model.Gold;
import com.ssg.member.model.Silver;

public class MemberRepository {
    public static final int MAX_INDEX = 10;
    Silver[] silvers = new Silver[MAX_INDEX];
    Gold[] golds = new Gold[MAX_INDEX];

    int silverIndex = 0;
    int goldIndex = 0;

    public void silverInsert(Silver silver) {
        if (silverIndex < MAX_INDEX) {
            this.silvers[silverIndex] = silver;
            silverIndex++;
        } else {
            System.out.println("더이상 추가할 수 없습니다!");
        }
    }


    public void goldInsert(Gold gold) {
        if (goldIndex < MAX_INDEX) {
            this.golds[goldIndex] = gold;
            goldIndex++;
        } else {
            System.out.println("더이상 추가할 수 없습니다!");
        }
    }


    public void printData() {
        System.out.println("""
                ---------------------------<<회원정보>>---------------------------
                이름              등급             포인트         이자포인트
                -----------------------------------------------------------------
                """);
        for (int i = 0; i < silverIndex; i++) {
            if (silvers[i] != null) {
                System.out.printf("%s            %s           %d          %.2f", silvers[i].getName(), silvers[i].getGrade(), silvers[i].getPoint(), silvers[i].getEjapoint());
                System.out.println();
            }
        }
        for (int i = 0; i < goldIndex; i++) {
            if (golds[i] != null) {
                System.out.printf("%s             %s            %d          %.2f", golds[i].getName(), golds[i].getGrade(), golds[i].getPoint(), golds[i].getEjapoint());
                System.out.println();
            }
        }
    }
}


