package operator;

public class App2 {
    public static void main(String[] args){
        //홍길동

        String name1 = " 홍길동 ";
        String phoneNumber1 = " 01012341234 ";
        String gender1 = "M";
        String adress1 = " 서울시 서초구 방배동";

        String result1 = (gender1 == "M"? "남": "여");

        // 신사임당

        String name2 = " 신사임당 ";
        String phoneNumber2 = " 01044443333 ";
        String gender2 = "F";
        String adress2 = " 경기도 남양주시 별내면 ";

        String result2 = (gender1 == "M"? "남": "여");

        System.out.println( " 이름 " + " 전화번호 " + " 성별 " + " 주소 " );
        System.out.println("--------------------------");
        System.out.println(name1 + phoneNumber1 + gender1 + adress1);
        System.out.println(name2 + phoneNumber2 + gender2 + adress2);





    }
}
