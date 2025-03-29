package com.sh.array;

/**
 * <pre>
 * 배열 (array)
 * - 동일한 자료형을 묶어서 관리하는 자료형
 * - 변수가 값 1개만 저장할 수 있는 한계를 극복
 * - heap 메모리영역에서 배열객체를 할당 후 사용
 *
 * 메모리 영역
 * 1. call stack 메소드 호출영역 (실행순서별로 밑에서 쌓임)
 *   - 변수를 이름으로 참조할 수 있음
 *   - 변수에 초기값을 제공하지 않음 -> 반드시 값대입 후 사용해야 함
 * 2. heap 객체 영역 (new 연산자로 생성된 객체의 저장공간)
 *   - 객체를 이름이 아닌 주소값으로 참조할 수 있음
 *   - 변수에 타입별 기본값을 초기값으로 설정
 *   - (정수 0, 실수 0.0, 논리 false, 문자 null문자(0번), 참조 null)
 * 3. static 정적자원의 저장공간(공유 목적)
 *
 * </pre>
 */

public class Array1 {
    public void test() {
        // 1. 선언
        int[] arr;
//        int arr[]; // c-family 스타일도 가능

        // 2. 배열 객체 할당 : 크기 지정 필수
        arr = new int[5];
        System.out.println(arr); // [I@7a81197d int[] @ 객체식별값(hashCode)

        // 3. 인덱스별 값 대입 및 사용
        // 값 대입 전 배열 인덱스
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

        System.out.println(arr[0]); // 10
        System.out.println(arr[1]); // 20
        System.out.println(arr[2]); // 30
        System.out.println(arr[3]); // 40
        System.out.println(arr[4]); // 50
    }

    public void test2() {
        // 1. 배열 선언 (stack에 생성)
        double[] darr;
        // 2. 배열객체 할당
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

        // 배열길이 변수(필드)
        System.out.println(darr.length); // 10

        // 배열객체 식별자 hashCode
        System.out.println(darr.hashCode()); // 2055281021

        // 생성된 배열의 길이를 변경할 수 없음
        darr = new double[15]; // 배열객체를 새로 할당한 것 -> 기존 객체의 길이를 변경한 것이 아님
        System.out.println(darr.length);
        System.out.println(darr.hashCode()); // 1554547125

        // 배열객체 삭제는 참조변수의 주소값을 제거해서 처리 가능
        // 실제로는 heap 영역의 연결이 끊어진 객체들을 Garbage Collector가 일괄 삭제함
        darr = null; // null은 값 없음을 의미하는 자바 키워드(참조형 변수에만 사용 가능)

        // NPE 주의 : null인 참조변수에 대해 필드/메소드를 사용할 수 없음
//        System.out.println(darr.length);
    }

    public void test3(){
        // 배열변수 선언 + 배열객체 할당
        int[] arr = new int[3];

//        System.out.println(arr[0]);
//        System.out.println(arr[1]);
//        System.out.println(arr[2]);

        // 값 쓰기
//        arr[0] = 1;
//        arr[1] = 2;
//        arr[2] = 3;

        // 만약 연속된 값의 규칙이 있다면 반복문을 통해 값 대입 가능
        // 규칙없으면 위와 같이 일일이 대입
//        int k = 1;
//        for (int i = 0; i < 3; i++){
//            arr[i] = k;
//            k++;
//        }

        // 값대입 30,40,50
        int k = 30;
        for (int i = 0; i < 3; i++){
            arr[i] = k;
            k += 10;
        }

        // 값 읽기
        for (int i = 0; i < 3; i++){
            System.out.println(arr[i]);
        }
    }

    /**
     * 배열 초기화
     * - 배열변수 선언 + 배열객체 할당 + 인덱스별 값 대입
     */
    public void test4() {
//        boolean[] bools = new boolean[] {true, false, true, false, true}; // 크기 명시 안함
        boolean[] bools = {true, false, true, false, true}; // 윗줄 뿐 아니라 이렇게도 가능
        System.out.println(bools.length);

        for (int i = 0; i < bools.length; i++){
            System.out.println(bools[i]);
        }
    }

    /**
     * 문자열 배열
     */
    public void test5() {
        String[] names = {"박정은", "오형동", "김연찬", "정성연", "양희윤"};
        // i < 5라고 쓰면 왜 5인지 바로 파악이 힘들수 있음 (magic number라고 함)
        // names.length 라고 쓰면 의도파악이 쉽고, 유지보수 쉬움
        for (int i = 0; i < names.length; i++){
            System.out.println(names[i]);
        }
    }
}
