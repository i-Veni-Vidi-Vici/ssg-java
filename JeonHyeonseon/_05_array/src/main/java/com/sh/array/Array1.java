package com.sh.array;

/**
 * <pre>
 * 배열 array
 * - 동일한 자료형을 묶어서 관리하는 자료형
 * - 변수가 값1개만 저장할 수 없는 한계를 극복했다.
 * - heap메모리 영역에서 배열객체를 할당후 사용한다.
 *
 * 메모리영역
 * 1. call stack 메소드 호출 영역 (실행순서별로 밑에서부터 쌓인다.)
 *  - 변수를 이름으로 참조할 수 있다.
 *  - 변수에 초기값을 제공하지 않는다. 반드시 값대입후 사용해야 한다.
 *
 * 2. heap 객체 영역 (new 연산자로 생성된 객체의 저장공간)
 *  - 객체를 이름이 아닌 주소값으로 참조할 수 있다.
 *  - 변수에 타입별 기본값을 초기값으로 설정한다.
 *  - (여기서 초기값은 정수 0, 실수 0.0, 논리 false, 문자 null이라는 문자-0을 의미, 참조형에만 null 사용가능)
 *
 * 3. static 정적자원의 저장공간(공유를 목적으로 한다)
 * </pre>
 */
public class Array1 {
    public void test() {
        // 1. 선언
        int[] arr; // int 배열을 만들고 싶다는 의미 -> 여기서 int는 배열타입(참조형)이다.
//        int arr[]; // c-family스타일도 가능
//        int arr[인덱스 값];

        // 2. 배열 객체 할당 - 크기지정 필수
        arr = new int[5];
        System.out.println(arr);  // [I@7a81197d  -> @앞에 있는 것을 int[]를 의미, @뒤에는 객체식별값(hashCode)이다.

        // 3. 인덱스별 값대입 및 사용
        // 값대입전 배열 인덱스
        System.out.println(arr[0]); // 0
        System.out.println(arr[1]); // 0
        System.out.println(arr[2]); // 0
        System.out.println(arr[3]); // 0
        System.out.println(arr[4]); // 0

        // 값대입
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;

        // 사용
        System.out.println(arr[0]); // 10
        System.out.println(arr[1]); // 20
        System.out.println(arr[2]); // 30
        System.out.println(arr[3]); // 40
        System.out.println(arr[4]); // 50
    }

    public void test2(){
        // 1. 배열 선언 (stack)
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

        // 배열의 길이 변수 => 필드
        System.out.println(darr.length); // 10

        // 배열객체의 식별자 => hashCode(힙 영역 안에 다른 객체)
        System.out.println(darr.hashCode()); // 2055281021(임의의 수)

        // 생성된 배열의 길이를 변경할 수 없다.
        darr = new double[15]; // 배열객체를 새로 할당한 것. 기존 객체의 길이를 변경한 것이 아니다.
        System.out.println(darr.length);  // 15
        System.out.println(darr.hashCode()); // 1554547125(임의의 수이기에 바뀜)

        // 배열객체 삭제는 참조변수의 주소값을 제거해서 처리할 수 있다.
        // 실제로는 heap영역의 연결이 끊어진 객체들을 Garbage Collector가 일괄삭제한다.
        darr = null; // null은 값없음을 의미하는 자바키워드. 이 키워드는 참조형 변수에만 사용가능하다.

        // NPE(NullPointerException) 주의 - null인 참조변수에 대해 필드/메소드를 사용할 수 없다.
//        System.out.println(darr.length); // 현재 darr은 null이다.
//        System.out.println(darr.hashCode());
    }

    /**
     * 배열과 반복문
     */
    public void test3(){
        // 배열변수 선언과 동시에 배열객체 할당을 할 수 있다.
        int[] arr = new int[3];

//        System.out.println(arr[0]);
//        System.out.println(arr[1]);
//        System.out.println(arr[2]);

        // 값 쓰기
//        arr[0] = 1;
//        arr[1] = 2;
//        arr[2] = 3;
        // 만약 연속된 값의 규칙이 있다면 반복문을 통해서 값대입할 수 있다.
//        int k = 1; // k의 초기값
//        for(int i = 0; i < 3; i++) {
//            arr[i] = k;  //인덱스가 바뀌어야 하니까 i를 넣는다.
//            k++;
//        }
        int k = 30;
        for(int i  = 0; i < 3; i++) { // i는 인덱스가 변하는 값
            arr[i] = k;
            k += 10;  // k = k + 10
        }
//
        // 값 읽기
        for(int i = 0; i <3; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 배열 초기화
     * - 배열변수 선언 + 배열객체 할당 + 인덱스별 값대입
     */
    public void test4(){
//        boolean[] bools = new boolean[] {true, false, true, false, true}; // 크기를 명시하지 않음. 하지만 {}를 통해서 5라는 것을 알 수 있음
        boolean[] bools = {true, false, true, false, true}; // 131줄과 같은 의미
//        System.out.println(bools.length); // 5
//        for(int i = 0; i < 5; i++) { // magic number -> 5가 무슨 뜻인지에 대한 의미
                                        // magic number 대신 변수를 사용하자. 의도파악이 쉽고, 유지보수하기 좋다.
          for(int i =0; i < bools.length; i++){ // 132줄과 같은 의미
              System.out.println(bools[i]);
        }
    }

    /**
     * 문자열 배열
     */
    public void test5() {
        String[] names = new String[] {"전현선1", "전현선2", "전현선3", "전현선4", "전현선5"};
        // 반복문을 통해 출력
        for(int i = 0; i < names.length; i++) { // .length를 사용할 때는 등호(=)가 필요없다.
            System.out.println(names[i]);
        }
    }
}
