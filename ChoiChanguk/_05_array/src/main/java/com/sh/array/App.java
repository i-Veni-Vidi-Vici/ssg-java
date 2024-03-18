package com.sh.array;

import java.util.NoSuchElementException;

/**
 * 배열 array
 * - 동일한 자료형을 묶어서 관리하는 자료형
 * - 변수가 값1개만 저장할 수 없는 한계를 극복했다.
 * - heap메모리 역역에서 배열객체를 할당 후 사용한다.
 *
 * 메모리영역
 * - call stack : 메소드 호출 열역(메인->메소드->실행->메소드 해제-> 메인 해제), 초기값 개념이 없다
 *   - stack은 이름으로 변수 접근 가능
 * - heap 객체 영역 ( new 연산자로 생성된 객체의 저장공간 <-객체다!! 그럼 heap에 적재됨, 주소로 접근, 타입별 기본값을 초기값으로 설정해준다
 * ex) int는 0, 실수는 0.0, 논리 false, 문자 null문자, 문자 null문자
 *   -
 * - static 정적자원 저장공간(공유목적),
 *
 */
public class App {
    public static void main(String[] args) {
        Array1 array1=new Array1();
        //array1.test();
        //array1.test2();
        //array1.test3();
        //array1.test4();
        //array1.test5();

        Array2 array2=new Array2();
        //array2.test1();
        //array2.test2();
        array2.test3();

    }
}
