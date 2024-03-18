package com.sh.multi.dimention;

/**
 * 다차원배열
 * - 2차원 이상의 배열을 의미
 * - 배열 인덱스마다 다른 배열의 주소를 가지고 있다.
 * - 1차원 배열을 묶어서 관리하는 것.
 * - 3차원이상도 가능은 하지만 자주 사용되지 않는다.
 *
 * 다차원배열 사용법
 * 1. 배열변수 선언
 * 2. 1차원 배열을 n개 관리하는 배열 객체를 할당
 * 3. 첫번째 배열의 인덱스별로 두번째 배열을 할당
 */

public class App {
    public static void main(String[] args) {

        MultiDimentionalArray mda=new MultiDimentionalArray();
        //mda.test1();
        //mda.test2();
        //mda.test3();
        //mda.test4();
        //mda.test5();

        JaggedArray jaggedArray=new JaggedArray();
        //jaggedArray.test1();
        jaggedArray.test2();
    }
}
