package com.sh.array;

public class Array1 {
    public void test()
    {
        //1. 선언
        int[] arr;

        //2. 배열 객체 할당 - !! 필수 크기지정 필수
        arr = new int[5];
        System.out.println(arr);//[I@7a81197d int[] @객체식별값(hashcode)

        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
        System.out.println(arr[4]);

        //3. 인덱스별 값대입 및 사용
        arr[0]=10;
        arr[1]=20;
        arr[2]=30;
        arr[3]=40;
        arr[4]=50;
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
        System.out.println(arr[4]);

    }

    public void test2() {
        //1. 배열선언 -<ㅅ스택에 만들어짐
        double[] darr;
        //2. 배열객체 할장
        darr = new double[10];
        //3. 갑상용

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
        System.out.println(darr[10]);

        //배열길이 변수(필드)
        System.out.print(darr.length);
        // 생성된 배열의 길이를 변경할 수 없다.
        darr = new double[5];// 배열객체를 새로 할당한 것, 기존 객체의 길이를 변경한 것이 아니다
        System.out.println(darr.hashCode());

        System.out.println(darr.length);
        System.out.print(darr.hashCode());

        //배열객체 삭제는 참조변수의 주소값을 제거해서 처리할 수 있다.
        // 실제로는 heap영역의 연결이 끊어진 객체들을 Garbage Collector가 일괄삭제한다.
        darr=null ;

        //NPE 주의 - null인 참조변수에 대해 필드/메소드를 사용할 수 없다.
        //System.out.print(darr.length);
        System.out.print(darr.hashCode());
    }

    public void test3() {
        //배열선억 & 배열객체 할당
        int[] arr= new int[3];
        int k=1;

        for(int i=0;i<3;i++)
        {
            arr[i]=10*(k+2); // 값 쓰기, 만약 연속된 값의 규칙이 있다면 반복문을 통해서 값대입을 할 수 있다.
            System.out.printf("%d \n",arr[i]); // 값 일기
            k++;
        }

    }

    public void test4() {
        boolean[] bools=new boolean[] {true,false,true,false};
        System.out.printf("%d",bools.length);
    }
    public void test5() {
        //String[] names = new String[] {"최창욱","홍길동","신사임당","이순신","세종대왕"};
        String[] names = {"최창욱","홍길동","신사임당","이순신","세종대왕"};

        //일반 수 = magic number, 그리고 magic number대신 names.length같은 변수를 사용하자
        for(int i=0;i<names.length;i++)
        {
            System.out.printf("%s \n",names[i]);
        }
    }

}
