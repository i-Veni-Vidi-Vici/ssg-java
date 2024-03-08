package com.sh.constant;

/**
 * <pre>
 *  상수
 *  - 변하지 않는 값을 보관하는 변수
 *  - 변경되어서는 안되는 값을 위해서 사용한다.(수정을 불가능하게 만드는 것)
 *  - 파이와 같은 수학적 값들은 상수로 관리하고 있다.
 *  - 숫자 기본형의 범위 역시 상수로 관리하고 있다.
 *
 *  - 선언 - 값대입 - 사용 동일하지만, 다시 값대입 할 수 없다.
 *  - 관례적으로 모두 상수명은 대문자로 작성한다. 합성어인 경우는 _로 연결한다.
 *
 * </pre>
 */
public class constantApp
{
    public static void main(String[] args) {
        //선언
        final int Age;
        Age = 20;
        //피연산자로는 사용할 수 있다.
        int age = Age + 20;
        System.out.println(age);
        
        //초기화
        final int VALUE = 123;
        System.out.println("VALUE = " + VALUE);

        //합성어인 상수
        final double Human_Height =  153.2;

        //jdk가 제공하는 상수
        System.out.println(Math.PI);
        System.out.println("byte : " + Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE); //Byte의 최소값
        System.out.println("short : " + Short.MIN_VALUE + " ~ "  + Short.MAX_VALUE);
        System.out.println("int : " + Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
        System.out.println("long : " + Long.MIN_VALUE + " ~ " + Long.MAX_VALUE);

    }
}
