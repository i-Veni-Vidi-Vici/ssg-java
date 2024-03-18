package com.sh.array;

/**
 * <pre>
 * 배열 array
 * - 동일한 자료형을 묶어서 관리하는 자료형
 * - 변수가 값 1개만 저장할 수 없는 한계를 극복했다.
 * - heap 메모리 영역에서 배열 객체를 할당 후 사용한다.
 *
 * 메모리 영역
 *  1. call stack 메소드 호출 영역 (실행 순서별로 밑에서부터 쌓인다.)
 *  - 변수를 이름으로 참조할 수 있다.
 *  - 변수에 초기 값을 제공하지 않는다. (반드시 값 대입 후 사용해야 한다.)
 *  2. heap 객체 영역 (new 연산자로 생성된 객체의 저장공간)
 *  - 객체를 이름이 아닌 주소 값으로 참조할 수 있다.
 *  - 변수에 타입 별 기본 값을 초기 값으로 설정한다.
 *  - (정수 0, 실수 0.0, 논리 false, 문자 null 문자(0), 참조형 null)
 *  3. static 정적자원 저장공간 (공유 목적)
 *  -
 * </pre>
 */

public class Array1 {
    public void test() {
        // 1. 선언
        int[] arr;
//        int arr[]; // c-family 스타일도 가능

        // 2. 배열 객체 할당 - 크기 지정 필수
        arr = new int[5];
        System.out.println(arr); // 객체식별값(hashCode)

        // 3. 인덱스 별 값 대입 및 사용
        // 값 대입 전 배열 인덱스
        System.out.println(arr[0]); //0
        System.out.println(arr[1]); //0
        System.out.println(arr[2]); //0
        System.out.println(arr[3]); //0
        System.out.println(arr[4]); //0

        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;

        System.out.println(arr[0]); //10
        System.out.println(arr[1]); //20
        System.out.println(arr[2]); //30
        System.out.println(arr[3]); //40
        System.out.println(arr[4]); //50

    }

    public void test2(){
        // 1. 배열 선언 (stack)
        double[] darr;
        // 2. 배열 객체 할당
        darr = new double[10];
        // 3. 값 사용
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

        // 배열 길이 변수(필드)
        System.out.println(darr.length); //10

        // 배열 객체 식별자 hashCode
        System.out.println(darr.hashCode()); //2055281021

        // 생성된 배열의 길이를 변경할 수 없다.
        darr = new double[15]; // 배열 객체를 새로 할당한 것. 기존 객체의 길이를 변경한 것이 아니다.
        System.out.println(darr.length); // 15
        System.out.println(darr.hashCode()); // 1554547125

        // 배열객체 삭제는 참조 변수의 주소값을 제거해서 처리할 수 있다.
        // 실제로는 heap 영역의 연결이 끊어진 객체들을 Garbage Collector가 일괄 삭제한다.

        darr = null; // 값 없음을 의미하는 자바 키워드. 참조형 변수에만 사용 가능.

        // NPE 주의 - null인 참조변수에 대해 필드/메소드를 사용할 수 없다.
        System.out.println(darr.length);
    }

    public void test3(){
        // 배열변수 선언 & 배열객체 할당
        int[] arr = new int[3];

//        System.out.println(arr[0]);
//        System.out.println(arr[1]);
//        System.out.println(arr[2]);

        // 값 쓰기
//        arr[0] = 1;
//        arr[1] = 2;
//        arr[2] = 3;
        // 만약 연속된 값의 규칙이 있다면 반복문을 통해서 값 대입할 수 있다. 규칙이 없다면 일일이 값 대입해야 함.
        int k = 30;
        for(int i = 0; i < 3; i++){
            arr[i] = k;
            k += 10;
        }

        // 값 읽기
        for(int i = 0; i < 3; i++){
            System.out.println(arr[i]);
        }

    }

    /**
     * 배열 초기화
     * - 배열변수 선언 + 배열객체 할당 + 인덱스 별 값 대입
     */

    public void test4(){
//        boolean[] bools = new boolean[] {true, false, true, false, true}; // 크기 명시 안함. 값을 통해 크기가 5라는 걸 알 수 있음.
        boolean[] bools = {true, false, true, false, true};

        System.out.println(bools.length);
        for(int i = 0; i < bools.length; i++){
            System.out.println(bools[i]);
        }
    }

    /**
     * 문자열 배열
     */
    public void test5(){
//        String[] names = new String[]{"양희윤", "김연찬", "오형동", "박정은", "정성연"};
        String[] names = {"양희윤", "김연찬", "오형동", "박정은", "정성연"};

        //반복문을 통해 출력
        for(int i = 0; i < names.length; i++){ // magic number 대신 변수 사용하자. 의도 파악 쉽고, 유지보수하기 좋다.
            System.out.println(names[i]);
        }
    }

}

