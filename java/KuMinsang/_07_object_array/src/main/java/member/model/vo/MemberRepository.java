package member.model.vo;

public class MemberRepository{
    Member[] members = new Member[40];
    int memberIndex = 0;
    int price = 0;


    public void printData() {
        String str = """
                --------------------<<회원정보>>------------------
                이름        등급         포인트         이자포인트
                -------------------------------------------------""";
        System.out.println(str);
        for(int i =0; i<memberIndex; i++){
            System.out.printf("%s      %s      %d      %.2f\n", members[i].getName(), members[i].getGrade(), members[i].getPoint(), members[i].getEjapoint() );
        }

    }

    public void insertMember(Member m){
        if(memberIndex <10) {
            members[memberIndex] = m;
            memberIndex++;
        }
    }


    public void printBuyInfo(int price){
        System.out.println("--------------------------------------");
        for(int i =0; i<memberIndex; i++){
            System.out.printf("%s 등급회원 %s는 %d원 상품을 %d원에 구매합니다.\n", members[i].getGrade(), members[i].getName(), price, members[i].buy(price));
        }
        System.out.println("--------------------------------------");
    }


}
