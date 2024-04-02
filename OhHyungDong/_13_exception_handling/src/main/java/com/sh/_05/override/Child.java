package com.sh._05.override;

import com.sun.jdi.ClassNotLoadedException;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * <pre>
 *
 *  오버라이드 규칙
 *  1. 부모 메소드 시그니쳐(접근 제한자, 리턴타입, 메소드며으 매개변수부, 예외)를 동일하게 작성해야한다.
 *  2. 접근제한자는 더 개방할 수 있다. protected -> public
 *  3. 선언된 예외를 제거하거나, 자식 예외 클래스로 재작성할 수 있다.
 *
 *  2번 3번 -> 둘다 사용하기 편하게 하기 위해서 변경 가능함. 더 개방하거나 선언된 것을 제거하는 것은 가능하지만 ,
 *  더 좁게 만들거나 예외를 추가하면 상속하는데 불편함이 생기면 안됨.
 * </pre>
 */
public class Child extends Parent{

//    @Override
//    public void read() throws IOException{}

//    @Override
//    public void read() {} //선언된 예외 제거 가능

//    @Override
//    public void read() throws FileNotFoundException {} // OK 자식 예외 클래스로 변환

//    @Override
//    public void read() throws Exception{} //부모타입 또는 관계없는 예외클래스로 변환 불가

//    @Override
//    public void read() throws IOException, ClassNotLoadedException{} //관계없는 예외 추가 불가
}
