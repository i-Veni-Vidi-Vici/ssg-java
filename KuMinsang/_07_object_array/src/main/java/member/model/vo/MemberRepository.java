package member.model.vo;

public class MemberRepository {
    Silver[] silvers = new Silver[10];
    Gold[] golds = new Gold[10];
    Vip[] vips = new Vip[10];
    VVip[] vvips = new VVip[10];
    int silindex = 0;
    int golindex = 0;
    int vipindex = 0;
    int vviindex = 0;

    public void silverInsert(Silver silver) {
        if(silindex <10) {
            silvers[silindex] = silver;
            silindex++;
        }

    }

    public void goldInsert(Gold gold) {
        if(golindex <10) {
            golds[golindex] = gold;
            golindex++;
        }
    }

    public void printData() {
        String str = """
                --------------------<<회원정보>>------------------
                이름        등급         포인트         이자포인트
                -------------------------------------------------""";
        System.out.println(str);
        for(int i =0; i<silindex; i++){
            System.out.printf("%s      %s      %d      %.2f\n", silvers[i].getName(), silvers[i].getGrade(), silvers[i].getPoint(), silvers[i].getEjapoint() );
        }
        for(int i =0; i<golindex; i++){
            System.out.printf("%s      %s      %d      %.2f\n", golds[i].getName(), golds[i].getGrade(), golds[i].getPoint(), golds[i].getEjapoint() );
        }
        for(int i =0; i<vipindex; i++){
            System.out.printf("%s      %s      %d      %.2f\n", vips[i].getName(), vips[i].getGrade(), vips[i].getPoint(), vips[i].getEjapoint() );
        }
        for(int i =0; i<vviindex; i++){
            System.out.printf("%s      %s      %d      %.2f\n", vvips[i].getName(), vvips[i].getGrade(), vvips[i].getPoint(), vvips[i].getEjapoint() );
        }

    }

    public void vvipInsert(VVip vVip) {
        if(vviindex <10) {
            vvips[vviindex] = vVip;
            vviindex++;
        }
    }

    public void vipInsert(Vip vip) {
        if(vipindex <10) {
            vips[vipindex] = vip;
            vipindex++;
        }
    }
}
