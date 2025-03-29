package com.sh.literal;

public class LiteralApp2 {
    /**
     * 간단한 연산 - 오칙연산(+ - * / %)
     * @param args
     */
    public static void main(String[] args){
        //1. 정수와 정수 연산 - 정수 사이의 연산 결과는 정수
        System.out.println(123+456); //579
        System.out.println(123-456); //-333
        System.out.println(123*10);//1230
        System.out.println(123/10); // 12
        System.out.println(123%10); // 3

        //2. 실수와 실수 연산 - 실수 사이의 연산 결과는 실수
        System.out.println(1.23+1.23); //2.46
        System.out.println(1.23-1.23); //0.0
        System.out.println(1.23*10.0); //12.3
        System.out.println(1.23/10.0); //0.123
        System.out.println(1.23%10.0); // 1.23
        System.out.println();

        //3. 정수와 실수 연산 - 정수/실수 사이의 연산 결과는 실수
        System.out.println(123+0.5); //123.5
        System.out.println(123-0.5); //122.5
        System.out.println(123*0.5); //61.5
        System.out.println(123/0.5); //246.0
        System.out.println(123%0.5); //0.0 나머지가 없다
        System.out.println();

        //4. 문자와 문자 연산 - 문자는 정수로 변환 후 연산 가능
        // ASCII CODE에 기준해서 a -> 97, b-> 98로 변환 후 연산
        System.out.println('a'+'b'); //195
        System.out.println('a'+'b'); //-1
        System.out.println('a'+'b'); //9506
        System.out.println('a'+'b'); //0
        System.out.println('a'+'b'); //97
        System.out.println();

        //5. 문자와 정수 연산 - 문자는 정수(아스키)로 변환 후 연산 가능
        System.out.println('a'+1); //98
        System.out.println('a'-1); //96
        System.out.println('a'*1); //97
        System.out.println('a'/1); //97
        System.out.println('a'%1); //0
        System.out.println();

        //6. 문자와 실수 연산 - 문자는 실수로 변환 후 연산 가능
        System.out.println('a'+1.0); //98.0
        System.out.println('a'-1.0); //96.0
        System.out.println('a'*1.0); //97.0
        System.out.println('a'/1.0); //97.0
        System.out.println('a'%1.0); //0.0
        System.out.println();

        //7. 문자열 연산 - 문자열은 더하기연산만(붙여쓰기) 지원
        System.out.println("hello" +"world"); //helloworld

        //8. 문자열과 다른 값의 연산 - 모두 문자열로써 더하기 연산 처리된다.
        System.out.println("hello" + 123); // "hello123"
        System.out.println("hello" + 123.456); // |hello123.456"
        System.out.println("hello" + 'a'); // "helloa"
        System.out.println("hello" + true); // "hellotrue"

        //9. 논리값과 오칙연산은 불가능
        //System.out.println(true+true); 컴파일 오류
        //System.out.println(true-123);

        //10. 문자열과 다른 타입의 값 더하기 심화
        // 프로그램은 기본적으로 위에서 아래로, 왼쪽에서 오른쪽으로 코드를 처리한다.
        System.out.println("기차" + 10 + 20); // "기차1020"
        System.out.println("기차" + (10 + 20)); // "기차30"
        System.out.println("김밥"+'a'+'b'); // "김밥ab"
        System.out.println('a'+'b'+"김밥"); // "195김밥" (97+98+김밥)
        System.out.println();

        //문자열이 하나라도 들어가면 결과가 문자열
        System.out.println(9+9+"9"); // "189" 18+"9" 숫자+문자라서 "18"
        System.out.println(9+"9"+9); // "999"
        System.out.println("9"+9+9); // "999"


    }
}



