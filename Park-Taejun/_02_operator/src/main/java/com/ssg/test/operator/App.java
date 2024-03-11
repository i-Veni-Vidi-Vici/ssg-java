package operator;

public class App {
    public static void main(String[] args) {

        int n = 55;

        System.out.println("정수 n이 1~ 100 사이 수인가?:" + (n>=1 && n<=100));
        System.out.println("n:" +n);
        System.out.println();
    // 문자 ch1이 영어 대문자인지 검사

    char ch1 = 'G';

        System.out.println("문자 ch1이 영어 대문자인가?:" + (ch1>= 65 && ch1 <=90));
        System.out.println("ch1:" + ch1);

    // 문자 yn이 대소문자 관계없이 y 인지 검사
    char yn = 'Y';
        System.out.println("문자 yn이 대소문자 관계없이 y인가?:" + (yn == 89 || yn == 121));
        System.out.println("yn : " +yn);
        System.out.println();
    // 문자 k가 영문자인지 검사
    char k = 'z';
        System.out.println("문자 k가 영문자인가?:" + ((k>= 65 && k <= 90) || (k >= 97 && k <= 122)));
        System.out.println("k:" + k);
 }
}



