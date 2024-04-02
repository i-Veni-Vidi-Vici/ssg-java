package com.sh._05.override;

import com.sun.jdi.ClassNotLoadedException;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 오버라이드 규칙
 * 1. 부모메소드 시그니쳐(접근제한자, 리턴타입, 메소드명, 매개변수부, 예외)를 동일하게 작성해야 한다
 * 2. 접근제한자는 더 개방할 수 있다. protected -> public
 * 3. 선언된 예외를 제거하거나, 자식예외 클래스로 재작성할 수 있다.
 */
public class Child extends Parent{

//    @Override
//    public void read() throws IOException {}

//    @Override
//    public void read() {} // OK 선언된 예외 제거 가능


//    @Override
//    public void read() throws FileNotFoundException {} // OK 자식 예외 클래스로 변환 가능

//    @Override
//    public void read() throws Exception {} // 부모타입 또는 관계없는 예외클래스로 변환은 할 수 없다,


//    @Override
//    public void read() throws IOException, ClassNotLoadedException {} //  X 관계 없는 예외 추가하는 것도 안됩니다
}

