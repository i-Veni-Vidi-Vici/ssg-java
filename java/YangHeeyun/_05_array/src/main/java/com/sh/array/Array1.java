package com.sh.array;

/**
 * <pre>
 * 배열 array
 * - 동일한 자료형을 묶어서 관리하는 자료형
 * - 변수가 값 1개만 저장할 수 없는 한계를 극복했다.
 * - heap메모리 영역에서 배열객체를 할당 후 사용한다.
 *
 * 메모리영역
 * 1. call stack 메소드 호출 영역 (실행순서별로 밑에서 부터 쌓인다)
 * - 변수를 이름으로 참조할 수 있다.
 * - 변수에 초기값을 제공하지 않는다. 반드시 값대입 후 사용해야 한다.
 * 2. heap 객체 영역 (new 연산자로 생성된 객체의 저장공간)
 * - 객체를 이름이 아닌 주소값으로 참조할 수 있다.
 * - 변수에 타입별 기본값이 초기값으로 설정한다.
 * - (정수0,실수 0.0,논리 false, 문자 null문자(0),참조형 null)
 * 3. static 정적자원 저장공간(공유목적)
 * </pre>
 */
public class Array1 {
    public void test(){
        // 1. 선언
        int[] arr; // int는 기본형 int[]은 참조형
        // int arr[]; //c가 배열선언하는 것처럼 쓸 수 있지만 보통 위에 것을 많이 쓴다

        // 2. 배열 객체 할당 - 크기지정 필수
        arr = new int[5];
        System.out.println(arr); // [I@7a81197d int[] @ 객체식별값 (hashCode)

        // 3. 인덱스별 값대입 및 사용
        // 값 대입전 배열 인덱스
        System.out.println(arr[0]); //0
        System.out.println(arr[1]); //0

        // 값 대입
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;

        System.out.println(arr[2]); //30
        System.out.println(arr[3]); //40
        System.out.println(arr[4]); //50
    }
    public void test2() {
        // 1. 배열선언 (stack)
        double[] darr;
        //2.배열객체 할당
        darr = new double[10];
        //3.값사용
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

        // 배열길이 변수(팔드)
        System.out.println(darr.length); //10

        // 배열객체 식별자 hashCode
        System.out.println(darr.hashCode()); //2055281021

        // 생성된 배열의 길이를 변경할 수 없다.
        darr = new double[15]; // 배열객체를 새로 할당한 것.기존 객체의 길이를 변경한 것이 아니다,
        System.out.println(darr.length); //15
        System.out.println(darr.hashCode()); //1554547125

        // 배열객체 삭제는 참조변수의 주소값을 제거해서 처리할 수 있다.
        // 실제로는 heap영역의 연결이 끊어진 객체들을 Garbage Collector가 일괄삭제한다.
        darr = null; // 값없음을 의미하는 자바키워드. 참조형변수에만 사용가능

        //NPE 주의 - null인 참조변수에 대해 필드/메소드르 사용할 수 없다.
        //System.out.println(darr.length);
        // System.out.println(darr.hashCode());
    }

        /**
         * 배열과 반복문
         */
    public void test3(){
        // 배열변수 선언 & 배열객체 할당
        int[] arr = new int[3];

//      System.out.println(arr[0]);
//      System.out.println(arr[1]);
//      System.out.println(arr[2]);

        // 값 쓰기
//      arr[0] = 1;
//      arr[1] = 2;
//      arr[2] = 3;
        // 만약 연속된 값의 규칙이 있다면 반복문을 통해서 값대입 할 수 있다.
        int k=1;
        for(int i=0;i<3;i++){
            arr[i] = k;
            k += 10;
        }

        // 값 읽기
        for(int i=0;i<3;i++){
            System.out.println(arr[i]);
        }
    }

    /**
     * 배열 초기화 (한번에 하는법)
     * - 배열변수 선언 + 배열객체 할당 + 인덱스별 값대입
     */
    public void test4(){
        boolean[] bools = new boolean[] {true,false,true,false,true}; // 크기명시를 안했지만 값을 통해서 크기가 5라는 것을 알 수 있다.
        boolean[] bools2 = {true,false,true,false,true};
        // 위 2가지는 같은 의미이다. 아래것이 더 간단해서 자주 사용

        System.out.println(bools.length);
        for(int i=0;i<bools.length;i++){
            System.out.println(bools[i]);
        }
    }

    /**
     * 문자열 배열
     */
    public void test5(){
        String[] names = {"김","이","박","최","정"};

        // 반복문을 통해 출력
        for(int i=0;i<names.length;i++){ // magic number(여기선 5) 대신 변수를 사용하자. 의도파악이 쉽고, 유지보수하기 좋다.
            System.out.println(names[i]);
        }
    }
}

