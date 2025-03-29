package com.sh.array;


/**
 * 배열 Array
 * - 동일한 자료형을 묶어서 관리하는 자료형
 * - 변수가 값 1개만 저장할 수 있는 한계를 극복
 * - heap 메모리 영역에서 배열객체를 할당 후 사용
 *
 * 메모리 영역
 * - stack 메소드 호출(call)영역
 *  -변수를 변수명으로 참조 가능
 *  -변수에 초기값 제공 X, 반드시 값 대입 후 사용
 *
 * - heap 객체 영역(new연상자로 생성된 객체의 저장공간)
 *  -객체를 이름이 아닌 주소값으로 참조
 *  -변수에 타입별 기본값이 초기값으로 설정(정수 0, 실수 0.0, 논리 false, 문자 null, 참조형 null)
 * - static 정적자원 저장공간(공유)
 */
public class Array1 {
    public void test1(){
        //1.선언
        int[] arr;
        //2. 배열객체할당 - 크기 지정 필수
        arr = new int[5];
        System.out.println("arr = " + arr);

        //3.인덱스별 값 대입 및 사용
        //초기화 전
        System.out.println(arr[0]);
        System.out.println(arr[1]);//모두 0으로 초기화
    }

    public void test2(){
        //1. 배열 선언(stack)
        double[] darr;
        //2. 배열객체 할당
        darr = new double[10];
        //3.값 사용
        for(int i =0; i<10;i++){
            System.out.println(darr[i]);
        }

        // 배열 길이 변수
        System.out.println(darr.length);

        //배열 객체 식별자(해시코드)
        System.out.println(darr.hashCode());

        // 생성된 뱌열의 길이를 변경할 수 없다.
        darr = new double[15]; // 기존객체 크기 변경 불가. 새로 할당한 것.
        System.out.println(darr.length);
        System.out.println(darr.hashCode());

        //배열객체 삭제는 참조변수의 주소값을 제거해서 처리할 수 있다.
        //실제로는 heap영역의 연결이 끊어진 객체들을 Garbage Collector가 일괄 삭제한다.
        darr = null; //null : 값 없음을 나타내는 자바 키워드. 참조형에만 사용.
    }

    public void test3(){
        //배열변수 선언 & 객체 할당
        int[] arr = new int[3];

        //값 쓰기
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;

        //연속된 규칙이 있다면 반복문 활용해서 값 대입
        int k =1;
        for(int i =0; i< arr.length; i++){
            arr[i] = k++;
        }
        k = 30;
        for(int i=0; i< arr.length;i++){
            arr[i] = k;
            k +=10;
        }
    }
    
    public void test4(){
        boolean[] bools = {true, false, true, false, true};
        System.out.println(bools.length);
        for(int i =0; i< bools.length; i++){
            System.out.println("bools[i] = " + bools[i]);
        }
    }

    public void test5(){
        String[] names = {"김홍현", "홍길동"};
        for(int i =0; i< names.length; i++){
            System.out.println(names[i]);
        }
        //array를 traverse 할 때 magic number 말고 변수를 사용하자.
    }
}
