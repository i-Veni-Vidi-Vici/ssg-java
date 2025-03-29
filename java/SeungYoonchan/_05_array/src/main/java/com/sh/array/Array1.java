package com.sh.array;


/**
 * <pre>
 *     배열
 *     - 동일한 자료형을 묶어서 관리하는 자료형
 *     - 변수가 값 1개만 저장할 수 없는 한계 극복
 *     - heap 메모리 영역에서 배열 객체를 할당 후 사용한다.
 *
 *     메모리 영역
 *     - call stack 메소드 호출 영역 (실행 순서별로 밑에서 부터 쌓인다.)
 *     - 변수를 이름으로 참조할 수 있다.
 *     - 변수별 초기값을 제공하지 않는다. 반드시 값 대입 후 사용해야 한다.
 *
 *     - heap 객체 영역 ( new 연산자로 생성된 객체의 저장공간 )
 *     - 객체를 이름이 아닌 주소값으로 참조할 수 있다.
 *     - 변수에 타입별 기본값이 초기값으로 설정한다.
 *     - (정수 0, 실수 0.0, 논리 false, 문자 null, 참조형 null)
 *
 *     - static 정적자원 저장공간 (공유 목적)
 *
 * </pre>
 */
public class Array1 {
    public void test1(){
        // 1. 선언
        int[] arr;
        // 2. 값 할당
        arr = new int[5];
        // 3. 인덱스별 값 대입
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
        System.out.println(arr[4]);

    }

    public void test2(){
        // 1. 배열 선언 (stack)
        double[] darr;
        // 2. 배열 객체 할당
        darr = new double[10];
        // 3. 값 사용
        for(int i=0; i<10; i++){
            System.out.println(darr[i]);
        }

        // 배열길이 변수(필드)
        System.out.println(darr.length); //10

        // 배열 객체 식별자 hashCode()
        System.out.println(darr.hashCode());

        // 생성된 배열의 길이를 변경할 수 없다.

        // 배열 객체 삭제는 참조변수의 주소값을 제거해서 처리할 수 있다.
        // 실제로는 heap 영역의 연결이 끊어진 객체들을 Garbage Collector가 일괄삭제한다.
        darr = null; // 참조형 변수에만 사용 가능

        // NPE( Null Pointer Exception ) 주의 - null인 참조변수에 대해 필드/메소드를 사용할 수 없다.
        // Ex)
        // System.out.println(darr.length); // darr이 null이기 때문에 오류가 발생한다.


    }

    public void test3(){
        int[] arr = new int[3];

        int k = 30;
        for (int i = 0; i < 3; i++) {
            arr[i] = k;
            System.out.println(arr[i]);
            k += 10;
        }

    }

    /**
     * <pre>
     *     배열 초기화
     *     - 배열 변수 선언 + 배열 객체 할당 + 인덱스별 값 대입
     * </pre>
     */
    public void test4(){
//        boolean[] bools = new boolean[]{true, false, true, false, true}; // 크기 명시 안함
        boolean[] bools = {true, false, true, false, true};
        System.out.println(bools.length);

        for (int i = 0; i < bools.length; i++) {
            System.out.println(bools[i]);
        }


    }

    public void test5(){
        String[] names = {"홍길동", "신사임당", "이순신"};

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }


}
