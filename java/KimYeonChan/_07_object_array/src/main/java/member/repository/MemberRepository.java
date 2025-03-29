package member.repository;

import member.model.vo.Gold;
import member.model.vo.Silver;
import member.model.vo.Vip;
import member.model.vo.VVip;

public class MemberRepository {
    private static final int MAX_INDEX = 10;
    private final Silver[] silverMembers = new Silver[MAX_INDEX];
    private final Gold[] goldMembers = new Gold[MAX_INDEX];
    private final Vip[] vipMembers = new Vip[MAX_INDEX];
    private final VVip[] vvipMembers = new VVip[MAX_INDEX];
    private int silverIndex;
    private int goldIndex;
    private int vipIndex;
    private int vvipIndex;

    public void silverInsert(Silver silver) {
        if (silverIndex < 10) {
            silverMembers[silverIndex] = silver;
            silverIndex++;
        }
        else {
            System.out.println("용량을 초과했습니다.");
        }
    }

    public void goldInsert(Gold gold) {
        if (goldIndex < 10) {
            goldMembers[goldIndex] = gold;
            goldIndex++;
        }
        else {
            System.out.println("용량을 초과했습니다.");
        }
    }

    public void vipInsert(Vip vip) {
        if (vipIndex < 10) {
            vipMembers[vipIndex] = vip;
            vipIndex++;
        }
        else {
            System.out.println("용량을 초과했습니다.");
        }
    }

    public void vvipInsert(VVip vvip) {
        if (vvipIndex < 10) {
            vvipMembers[vvipIndex] = vvip;
            vvipIndex++;
        }
        else {
            System.out.println("용량을 초과했습니다.");
        }
    }

    public void printData() {
        System.out.println("""
                ---------------------------<<회원정보>>---------------------------
                이름              등급              포인트             이자포인트
                ----------------------------------------------------------------""");

        for (int i = 0; i < silverIndex; i++) {
            System.out.printf("%s            %s            %s              %d\n",
                    silverMembers[i].getName(), silverMembers[i].getGrade(), silverMembers[i].getPoint(), silverMembers[i].getEjapoint());
        }

        for (int i = 0; i < goldIndex; i++) {
            System.out.printf("%s            %s              %s              %d\n",
                    goldMembers[i].getName(), goldMembers[i].getGrade(), goldMembers[i].getPoint(), goldMembers[i].getEjapoint());
        }

        for (int i = 0; i < vipIndex; i++) {
            System.out.printf("%s            %s               %s             %d\n",
                    vipMembers[i].getName(), vipMembers[i].getGrade(), vipMembers[i].getPoint(), vipMembers[i].getEjapoint());
        }

        for (int i = 0; i < vvipIndex; i++) {
            System.out.printf("%s            %s              %s            %d\n",
                    vvipMembers[i].getName(), vvipMembers[i].getGrade(), vvipMembers[i].getPoint(), vvipMembers[i].getEjapoint());
        }
    }
}
