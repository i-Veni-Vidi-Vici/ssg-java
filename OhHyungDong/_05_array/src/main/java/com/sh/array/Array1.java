package com.sh.array;

import java.util.Scanner;

/**
 * <pre>
 *  배열 array
 *  - 동일한 자료형을 묶어서 관리하는 자료형
 *  - 변수가 값 1개만 저장할 수 없는 한계를 극복한다.
 *  - heap 메모리 영역에서 배열 객체를 할당 후 사용한다.
 *
 *  메모리 영역
 *  - call stack 메소드 호출 영역 (실행 순서별로 밑에서 부터 쌓인다.)
 *      -> 변수를 이름으로 참조할 수 있다.
 *      -> 변수별 초기값을 제공하지 않는다.(반드시 값 대입 후 사용해야한다.)
 *  - heap 객체 영역(new 연산자로 생성된 객체의 저장공간)
 *      -> 변수를 이름이 아닌 객체의 주소값으로 참조할 수 있다.
 *      -> 변수에 타입별 기본값이 초기값으로 설정한다.
 *  - static 정적자원의 저장 공간 (공유 목적)
 *
 * </pre>
 */
public class Array1 {

    public void test1()
    {
        // 1. 선언
        int[] arr; //int arr[] c - family타입으로도 사용 가능
        // 2. 값 할당, 배열 객체 할당
        arr = new int[5]; // 크기 지정 필수 !
        System.out.println(arr); //[I@251a69d7 int[] @ 객체식별값(HashCode)

        // 3. 인덱스별 값대입 및 사용
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
        System.out.println(arr[4]);

        //값 대입
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

    public void test2()
    {
        double[] darr; //1. 배열선언(stack)

        //2. 배열 객체 할당
        darr = new double[10];

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

        //배열길이 변수(필드)
        System.out.println(darr.length);

        //배열 객체 식별자 hashCode
        System.out.println(darr.hashCode());
        //생성된 배열의 길이를 변환시킬 수 없다.
        darr = new double[15]; //배열 객체를 새로 할당한 것. 기존 객체의 길이를 변경한 것이 아니다.
        System.out.println(darr.length);
        //System.out.println(darr.hashCode());

        //배열객체 삭제는 참조변수의 주소값을 제거해서 처리 할 수 있다.
        // 실제로는 heap영역에 연결이끊어지면 객체들은 Garbage Collector가 일괄 삭제하게된다.
        darr = null ; //값 없음을 의미하는 자바 키워드, 참조변수에만 사용 가능

        //NPE 주의 = null인 참조변수에 대해 필드 / 메소드를 사용할 수 없다.
       // System.out.println(darr.length);
    }

    public void test3()
    {
        int[] arr = new int[3];

//        for(int i = 0; i<3; i++)
//        {
//            System.out.println(arr[i]);;
//        }
        //값 쓰기
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        //만약 연속된 값의 규칙이 있다면 반복문을 통해서 값을 대입할 수 있다.
        int k = 1;
        for(int i = 0; i<3; i++)
        {
            arr[i] = (i + 2) * 10;
        }
    }

    /**
     * 배열 초기화
     * - 배열 변수 선언 + 배열 객체 할당 + 인덱스별 값 대입
     */
    public void test4()
    {
        boolean[] bools = new boolean[] {true, false, true, false};
        boolean[] bool = {true, false, true, false};
        System.out.println(bools.length);

        for(int i = 0; i<bools.length; i++)
        {
            System.out.println(bools[i]);
        }
    }

    /**
     * 문자열 배열
     */
    public void test5()
    {
        Scanner scanner = new Scanner(System.in);
        String name ;
        String[] teamStudy = new String[5];

        for(int i = 0; i < teamStudy.length; i++) //magic number : 의도를 모르는 숫자. 매직넘버 대신 변수를 사용하자. 의도파악이 쉽고, 유지보수하기 쉽다.
        {
            name = scanner.next();
            teamStudy[i] = name;

        }
    }

}
