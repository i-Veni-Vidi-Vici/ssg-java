package com.sh.operator.logical;

/**
 * <pre>
 * 논리연산자
 * - && (and) =>(둘다) 좌우항이 모두 ture인 경우 ture를 반환
 * - || (or) =>(또는) 좌항 또는 우항이 true인 경우 true
 *
 * 논리부정연산자
 * - ! 논리값을 반전해서 반환
 * </pre>
 */

public class LogicalOperatorApp {
    public static void main(String[] args)
    {
        //논리연산자
        System.out.println(true && true);//T
        System.out.println(false && false);//F
        System.out.println(true && false);//F
        System.out.println(false && true);//F
        System.out.println("-------------------------");

        //논리연산자
        System.out.println(true || true);//T
        System.out.println(false || false);//F
        System.out.println(true || false);//T
        System.out.println(false || true);//T
        System.out.println("-------------------------");

        //논리 연산자 적용 && and + 그리고 + ~하면서
        int a=10;
        int b = 20;
        int c = 30;
        int d = 40;
        System.out.println(c < b && c > d);
        System.out.println(a == b && c > d);
        System.out.println((a + b) == c && d > 100);
        System.out.println(a < b && b * c > d * d);
        System.out.println("-------------------------");

        //논리연산자 적용 || or + 또는 + 혹은
        System.out.println(a > b || c < d);
        System.out.println(a < b + 100 || c == d);
        System.out.println(a != b || c > d * 2);
        System.out.println(a + b + c < d || d < 0);
        System.out.println("-------------------------");

        //범위에 포함되는지 여부
        int x=55;
        System.out.println(1 <= x && x <= 100);//실행은 됨 근데 개발자들의 암묵적룰이 깨짐
        System.out.println(x>=1 && x <= 100);
    }

}
