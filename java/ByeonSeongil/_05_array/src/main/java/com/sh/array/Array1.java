package com.sh.array;

/**
 * stack
 * - 변수를 이름으로 참조
 * - 변수에 초기값을 제공x
 * heap
 * - 객체를 이름이 아닌 주소값으로 참조
 * - 변수에 타입별 기본값으로 초기화 됨
 */
public class Array1 {
    public void test() {
        // 1. 선언
        int[] arr;
//        int arr[]; // c-family 스타일도 가능

        // 2. 배열 객체 할당 = 크기지정 필수
        arr = new int[5];
        System.out.println(arr); // [I@7a81197d  int[] @ 객체식별값(hashcode)

        // 값대입
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 10 + 10 * i;
        }

        // 3. 인덱스별 값대입 및 사용
        // 값대입전 배열 인덱스
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
        System.out.println(arr[4]);
    }

    public void test2() {
        double[] darr = new double[10];

        // 배열길이 필수(필드)
        System.out.println(darr.length);

        // 생성된 배열의 길이를 변경x
        darr= new double[15]; // 배열 객체 새로 할당
        System.out.println(darr.length);
        System.out.println(darr.hashCode());

        // 배열객체 삭제는 참조변수의 주소값을 제거해서 처리할 수 있음
            // 실제로는 heap영역의 연결이 끊어진 객체들을 garbage collector가 일괄 삭제
        darr = null; // 값 없음을 의미하는 자바 키ㅜ어드, 참조형변수에만 가능

        // NPE 주의 - null인 참조변수에 대해 필드/메서드를 사용할 수 없다.
//        System.out.println(darr.length);
//        System.out.println(darr.hashCode());

    }

    /**
     * 배열과 반복문
     */
    public void test3() {
        // 배열변수 선언 & 배열객체 할당
        int[] arr = new int[3];

        // 값 쓰기
        // 연속된 값의 규칙이 있다면 반복문을 통해서 값대입할 수 있다.
        for (int i = 0; i < 3; i++) {
            arr[i] = 10 + i*10;
        }

        // 값 읽기
        for (int i = 0; i <3; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 배열 초기화
     * - 배열변수 선언 + 배열객체 할당 + 인덱스별 값대입
     */

    public void test4() {
//        boolean[] booleans = new boolean[] {true, false, true, false, true}; // 크기명시 안함.

        boolean[] booleans = {true, false, true, false, true};
        for (int i = 0; i < booleans.length; i++) {
            System.out.println(booleans[i]);
        }
    }

    /**
     * 문자열 배열 초기화
     */

    public void test5() {
        String[] names = {"홍길동", "신사임당", "d이순신", "장영실", "s녹개"};
        for (int i = 0; i < names.length; i++) { // magic number 대신 변수를 사용하자. 의도파악이 쉽고, 유지보수하기 좋다.
            System.out.println(names[i]);
        }
    }
}
