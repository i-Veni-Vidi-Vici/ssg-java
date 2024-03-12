package com.sh.constant;
/*<pre>
변경되어서는 안되는 값을 위해 사용한다. 수정불가
파이와 같은 수학적 값들은 상수로 관리하고 있다.
숫자

</pre>

*/


import java.sql.SQLOutput;

public class ConstantApp {

    public static void main(String[] args){
   //선언 final
        final int AGE;
        AGE = 20; // 값을 다시 대입할 수 없다.
        System.out.println(AGE);
        //초기화
        final int VALUE = 123;
        final double HUMAN_AVG_HEIGHT = 170.33;

        System.out.println(Math.PI);
        System.out.println("byte : " + Byte.MIN_VALUE + "~" + Byte.MAX_VALUE);
        System.out.println("short : " + Short.MIN_VALUE + "~" + Short.MAX_VALUE);
        System.out.println("short : " + Integer.MIN_VALUE + "~" + Integer.MAX_VALUE);
        System.out.println("short : " + Long.MIN_VALUE + "~" + Long.MAX_VALUE);

    }


}
