package com.sh.array;

/**
 * <pre>
 *     배열
 *     - 동일한 자료형을 묶어서 관리하는 자료형
 *     - 변수가 값1개만 저장할 수 없는 한계를 극복했다
 *     - heap 메모리 영역에서 배열 객체를 할당 후 사용한다.
 *     -
 *     메모리 영역
 *     - call stack 메소드 호출 영역 (실행 순서별로 밑에서부터 쌓인다)
 *      - 변수를 이름으로 참조할 수 있다.
 *      - 변수에 초기 값을 java에서 제공하지 않는다. 반드시 값 대입 후 사용해야 한다.
 *     - heap 객체 영역 (new 연산자로 생성된 객체의 저장공간)
 *      -
 *     - static 정적 자원의 저장공간 (공유목적)
 * </pre>
 */


public class Array1 {
    public void test() {
        //1. int 선언
        int[] arr;  //java style
        //int arr[]; // C-Familly style

        //2. 배열 객체 할당 - 크기 지정 필수
        arr = new int[5];
        System.out.println(arr);    // I@7a81197d 개체식별값(hashCode)

        //3. 인덱스별 값 대입 및 사용
        //값 대입 전 배열 인덱스
        for (int i = 0; i < 5; i++) {
            System.out.println(arr[i]);
        }
        //값 대입
        for (int i = 0; i < 5; i++) {
            System.out.println(arr[i] = (i + 1) * 10);
        }

    }

    public void test2() {
        //1. 배열 선언 (stack)
        double[] darr;
        //2. 배열객체 할당
        darr = new double[10];
        //3. 값 사용
        for (int i = 0; i < 10; i++) {
            System.out.println(darr[i]);
        }

        //배열 길이 변수(필드)
        System.out.println(darr.length);

        //생성된 배열의 길이를 변경할 수 없다.
        System.out.println(darr.hashCode());    //2055281021
        darr = new double[15];  //배열 객체를 새로 할당한 것
        System.out.println(darr.hashCode());    //1554547125

        //배열객체의 삭제는 참조변수의 주소값을 제거해서 처리할 수 있다.
        //실제로는 heap 영역의 연결이 끊어진  객체들을 Garbage Collector가 일괄 삭제
        darr = null;    //값 없음을 의미하는 자바키워드, 참조변수에만 사용가능

        //NPE 주의 - null이 참조변수에 대해 필드 /메소드를 사용할 수 없음.
        //System.out.println(darr.length);
        //System.out.println(darr.hashCode());
    }

    public void test3() {

        int[] arr = new int[3];
        //반복문을 통해 배정하기
        int k = 3;
        for (int i = 0; i < 3; i++) {
            arr[i] = k * 10;
            k++;
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(arr[i]);
        }

    }

    /**
     * 배열 초기화
     * - 배열변수 선언 + 배열객체 할당 + 인데스별 값 대입
     *
     */

    public void test4(){
        // boolean [] bools = new boolean[] {true, false ...., true};
        boolean[] bools = new boolean[] {true, false, true, false, true};
        System.out.println(bools.length);
        for(int i =0; i<bools.length; i++){
            System.out.println(bools[i]);
        }
    }

    /**
     * 문자열 배열
     */
    public void test5(){
        String[] names = {"홍길동", "임꺽정", "철수", "영희"};
        int i =0;

        //반복문을 통해 출력
        while(i < names.length){
            System.out.println(names[i]);
            i++;
        }
    }




}
