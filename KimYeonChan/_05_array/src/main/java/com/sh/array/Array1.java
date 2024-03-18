package com.sh.array;

/**
 * 배열
 * - 동일한 자료형을 묶어서 관리하는 자료형
 * - 변수가 값 1개만 저장할 수 없는 한계를 극복 했다.
 * - heap 메모리 영역에 배열객체를 할당후 사용한다.
 * 메모리 영역
 * - call stack: 메소드 호출 영역(실행 순서별로 밑에서 부터 쌓인다.)
 *     - 변수 이름으로 참조할 수 있다.
 *     - 변수에 초기값을 제공하지않는다. 반드시 값 대입후 사용해야 한다.
 * - heap: 객체 영역 (new 연산자로 생성된 객체의 저장공간)
 *     - 객체를 이름이 아닌 주소값으로 참조 할 수 있다.
 *     - 변수에 타입별 기본값이 초기값으로 설정한다. (정수 0, 실수 0.0, 논리 false, 문자 null, 참조형 null
 * - static: 정적 자원의 저장공간 (공유 목적)
 */
public class Array1 {
    public void test1() {
        // 1. 선언
        int[] arr;
//        int arr[]; // c-family 스타일도 가능

        // 2. 배열 객체 할당
        arr = new int[5];
        System.out.println(arr); // [I@251a69d7
        // int[]: [I
        // @: 객체 식별 값

        // 3. 인덱스별 값대입 및 사용
        // 값대입전 배열 인덱스
        System.out.println(arr[0]); // 0
        System.out.println(arr[1]); // 0
        System.out.println(arr[2]); // 0
        System.out.println(arr[3]); // 0
        System.out.println(arr[4]); // 0

        // 값 대입
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;
    }

    public void test2() {
        // 1. 배열 선언 (Stack)
        double[] darr;
        // 2. 배열 객체
        darr = new double[10];
        // 3. 값 사용
        System.out.println(darr[0]);
        System.out.println(darr[1]);
        System.out.println(darr[2]);
        System.out.println(darr[3]);
        System.out.println(darr[4]);
        System.out.println(darr[5]);
        System.out.println(darr[6]);
        System.out.println(darr[8]);
        System.out.println(darr[9]);

        // 배열길이 변수 (필드)
        System.out.println(darr.length); // 10

        // 배열 객체 식별자 hashCode
        System.out.println(darr.hashCode());

        // 생성된 배열의 길이를 변경할 수 없다.
        darr = new double[15]; // 배열 객체를 새로 할당한것. 기존 객체 의 길이를변경한 것이 아니다.
        System.out.println(darr.length); // 15
        System.out.println(darr.hashCode());

        // 배열개겣 삭제는 참조변수의 주소값을 제거해서 처리할 수 있다.
        // 실제로는 heap 영역의 연결이 끊어진 객체들은 Garbage Collector 가 일괄삭제한다.
        darr = null; // 값 없음을 의미하는 자바키워드. 참조형변수에만 사용가능

        // NPE 주의: null 인 참조변수에 대해 필드/메소드를 사용할 수 없다.
        // System.out.println(darr.length);
    }

    public void test3() {
        int[] arr = new int[3];

        int k = 1;
        for (int i = 0; i < arr.length; i++) {
            // 만약 연속된 값의 규칙이 있다면 반복문을 통해서 값대입할 수 있다.
            arr[i] = k;
            k++;
        }

        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i]);
        }
    }

    public void test4() {
        // boolean[] bools = new boolean[] {true, true, true, true}; // 크기 명시 안함.
        boolean[] bools = {true, true, true, true}; // 크기 명시 안함.

        System.out.println(bools.length);
        for (int i = 0; i < bools.length; i++) {
            System.out.println(bools[i]);
        }
    }

    /**
     * 문자열 배열 초기화
     */
    public void test5() {
        String[] members = {"김연찬", "오형동", "정성연", "박정은", "양희윤"};

        for (int i = 0; i < members.length; i++) { // magic number 대신 변수를 사용하자. 의도 파악이 쉽고 유지보수하기 좋다.
            System.out.println(members[i]);
        }
    }
}
