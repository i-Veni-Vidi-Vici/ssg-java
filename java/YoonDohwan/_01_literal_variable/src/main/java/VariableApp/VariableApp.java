package VariableApp;

public class VariableApp {




    public static void main(String[]args){
        // 값에 의미를 부여한다.
        System.out.println("보너스를 포함한 급여는"+(100000+10000)+"원 입니다.");
        int salary = 100000;
        double bonus = salary * 0.01;
        System.out.println("보너스를 포함한 급여는"+(salary+bonus)+"원 입니다.");

        //2. 값을 재사용할 수 있다.
        System.out.println("1번 고객에게" + 100 +"포인트를 지급합니다.");
        System.out.println("2번 고객에게" + 100 +"포인트를 지급합니다.");
        System.out.println("3번 고객에게" + 100 +"포인트를 지급합니다.");

        int point = 100;
        System.out.println("1번 고객에게" + point + "포인트를 지급합니다.");
        System.out.println("2번 고객에게" + point + "포인트를 지급합니다.");
        System.out.println("3번 고객에게" + point + "포인트를 지급합니다.");

        //3. 시간에 따라 변하는 값을 처리할 수 있다.
        int price = 0;
        System.out.println("총액은" + price + "원 입니다.");
        price = price + 10000; //장바구니에 상품추가
        // = 대입연산자 : 우항의 값을 좌항의 공간에 대입하라! 연산자 우선순위 낮다.
        System.out.println("총액은" + price + "원 입니다.");
        price = price + 10000; //장바구니에 상품추가
        System.out.println("총액은" + price + "원 입니다.");
        price = price + 20000; //장바구니에 상품추가
        System.out.println("총액은" + price + "원 입니다.");









    }

}
