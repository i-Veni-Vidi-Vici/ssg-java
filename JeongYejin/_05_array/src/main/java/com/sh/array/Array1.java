package com.sh.array;

import java.util.Arrays;

/**
 * <pre>
 * 배열 array
 * - 동일한 자료형을 묶어서 관리하는 자료형
 * - 변수가 값 1개만 저장할 수 없는 한계를 극복했다.
 * - heap 메모리 영역에서 배열객체를 할당 후 사용한다.
 *
 * 메모리영역
 * 1. call stack 메소드 호출 영역 (실행순서별로 밑에서부터 쌓인다)
 *  - 변수를 이름으로 참조할 수 있다.
 *  - 변수에 초기값을 제공하지 않는다. 반드시 값대입후 사용해야 한다.
 * 2. heap 객체 영역 (new 연산자로 생성된 객체의 저장공간)
 *  - 객체를 이름이 아닌 주소값으로 참조할 수 있다.
 *  - 변수에 타입별 기본값을 초기값으로 설정한다. (즉시 참조 가능)
 *  - (정수 0, 실수 0.0, 논리 false, 문자 null문자(0), 참조형 null)
 * 3. static 정적자원 저장공간(공유목적)
 * </pre>
 */
public class Array1 {
    public void test() {
        // 1. 선언
        int[] arr; // int != int[]
//        int arr[]; // C언어 family 스타일도 가능

        // 2. 값할당 - 크기지정 필수
        arr = new int[5];
        System.out.println(arr); // [I@7a81197d [I -> int[] @ 객체식별값(hashCode)

        // 3. 인덱스별 값대입 및 사용
        // 값대입전 배열 인덱스
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
        System.out.println(arr[4]);

        // 값대입
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;

        // 값사용
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
        System.out.println(arr[4]);
    }

    public void test2() {
        // 1. 배열선언 (stack)
        double[] darr;
        // 2. 배열객체 할당
        darr = new double[10];
        // 3. 값사용
        System.out.println(darr[0]);
        System.out.println(darr[1]);
        System.out.println(darr[2]);
        System.out.println(darr[3]);
        System.out.println(darr[4]);
        System.out.println(darr[5]);
        System.out.println(darr[6]);
        System.out.println(darr[7]);
        System.out.println(darr[8]);
        System.out.println(darr[9]);

        // 배열객체 식별자 hashCode
        System.out.println(darr.hashCode()); // 1554547125

        // 배열길이 변수(필드)
        System.out.println(darr.length); // 10

        // 생성된 배열의 길이를 변경할 수 없다.
        darr = new double[15]; // 배열 객체를 새로 할당한 것. 기존 객체의 길이를 변경한 것이 아니다.
        System.out.println(darr.length); // 15
        System.out.println(darr.hashCode()); // 617901222

        // 배열 객체 삭제는 참조변수의 주솟값을 제거해서 처리할 수 있다.
        // 실제로는 heap영역의 연결이 끊어진(stack에서 참조하지 않는) 객체들을 Garbage Collector가 일괄 삭제한다.
        darr = null; // 값없음을 의미하는 자바 키워드. 참조형 변수에만 사용가능

        // NPE(NullPointerException) 주의 - null인 참조변수에 대해 필드/메소드를 사용할 수 없다.
//        System.out.println(darr.length);
        // java.lang.NullPointerException: Cannot read the array length because "darr" is null
        System.out.println(darr.hashCode());
        // Cannot invoke "Object.hashCode()" because "darr" is null
    }

    public void test3() {
        int[] arr = new int[3];

        // 값쓰기
//        arr[0] = 1;
//        arr[1] = 2;
//        arr[2] = 3;

        // 값읽기
//        System.out.println(arr[0]);
//        System.out.println(arr[1]);
//        System.out.println(arr[2]);

        int k = 30;
        for (int i = 0; i < 3; i++) {
            // 값쓰기
            // 만약 연속된 값의 규칙이 있다면 반복문을 통해 값대입할 수 있다.
            arr [i] = k;
            k += 10;
            // 값읽기
            System.out.println(arr[i]);
        }
    }

    /**
     * 배열 초기화
     * - 배열 변수 선언 + 배열 객체 할당 + 인덱스별 값대입
     */

    public void test4() {
        boolean[] bools = new boolean[] {true, false, true, false, true}; // 크기 명시 안함
        boolean[] bools_ = {true, false, true, false, true}; // 크기 명시 안함
        System.out.println(bools.length);
        for (int i = 0; i < bools.length; i++) {
            System.out.println(bools[i]);
        }
    }

    /**
     * 문자열 배열
     */
    public void test5() {
        String[] potato_java = {"나지영", "박수빈", "정인겸", "정예진"};

        // 반복문을 통해 출력
        for (int i = 0; i < potato_java.length; i++) { //magic number 대신 변수를 사용하자. 의도파악과 유지보수에 편리.
            System.out.println(potato_java[i]);
        }
    }
}