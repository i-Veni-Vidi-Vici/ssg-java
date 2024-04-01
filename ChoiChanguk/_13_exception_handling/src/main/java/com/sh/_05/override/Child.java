package com.sh._05.override;

import com.sun.jdi.ClassNotLoadedException;

import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * <pre>
 * 오버라이드 규칙 <= 더 편하게 해줄려고
 * 1. 부모메소드 시그니쳐(접근제한자, 반환형, 이름, 매개변수부, 예외)를 동일하게 작성해야 한다.
 * 2. 접근제한자는 더 개방할 수 있다. protected -> public
 * 3. 선언된 예외를 제거하거나, 자식예외클래스로 재작성할 수 있다.
 * </pre>
 */
public class Child extends Parent{
//    @Override
//    public void read() throws IOException {
//    }

//    @Override
//    public void read() {}// OK 선언된 예외 제거


//    @Override
//    public void read() throws FileNotFoundException {} // OK 자식 예외 클래스로 변환


//    @Override
//    public void read() throws Exception {} // 부모타입 또는 예외 클래스로 변환은 불가능 하다


    @Override
    public void read() throws IOException , ClassNotLoadedException {}// 전혀 관계없는
}
