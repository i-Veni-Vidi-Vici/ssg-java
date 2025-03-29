package com.sh.api._04.wrapper;

/**
 * <pre>
 * Wrapper 클래스가 제공하는 상수/메소드
 * - 기본형의 값범위 MIN_VALUE, MAX_VALUE
 * - 문자열 값을 해당타입 값으로 변환하는 parsing메소드 제공
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        //상수
        System.out.println(Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
        System.out.println(Double.MIN_VALUE + " ~ " + Double.MAX_VALUE);
        System.out.println((int) Character.MIN_VALUE + " ~ " + (int)Character.MAX_VALUE);
        System.out.println(Boolean.TRUE + " ~ " + Boolean.FALSE);

        //파싱메소드
        int i=Integer.parseInt("123"); // "123" 문자열-> 123 숫자로 변환
        int i2=Integer.parseInt("37321");
        double d= Double.parseDouble("123.321");
        boolean bool=Boolean.parseBoolean("trueeeeee");// 오타 + "false"(대소문자 상관없이) = false
        System.out.println(bool);

//        char ch=Character.parseCharacter(); //이런건 없음 평소처럼 charAt(0) 이렇게 써야 한다

        //해당타입의 값을 문자열로 변환
        String inum=Integer.valueOf(123).toString();// 숫자123을 문자열 123으로 변환
        String dnum=Double.valueOf(123.468).toString();//
        String boolstr=Boolean.valueOf(true).toString();
        String chstr=Character.valueOf('k').toString();
        System.out.printf("inum = %s, dnum = %s\n",inum,dnum);
        System.out.printf("boolstr = %s, chstr = %s\n",boolstr,chstr);
        System.out.printf("inum = %s, dnum = %s\n",inum,dnum);


    }
}
