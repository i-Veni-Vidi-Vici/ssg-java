package com.sh._05.override;

import com.sun.jdi.ClassNotLoadedException;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * <pre>
 *     오버라이드 규칙
 *     1. 부모 메소드 시그니처(접근 제한자, 리턴타입, 메소드 명, 매개변수, 예외)를 동일하게 작성해야 한다.
 *     2. 접근제한자는 더 개방할 수 있다. protected -> public으로 변경가능
 *     3. 선언된 예외를 제거하거나, 자식 예외 클래스로 재작성할 수 있다.
 * </pre>
 */
public class Child extends Parent{
//    @Override
//    public void read() throws IOException {}

//    @Override
//    public void read()  {} // Ok 선언된 예외 제거 가능!

//    @Override
//    public void read() throws FileNotFoundException {} //Ok 자식 예외 클래스로 변환

//    @Override
//    public void read() throws Exception {} // No !부모 타입 또는 관계없는 예외 클래스로 변환 불가

//    @Override
//    public void read() throws IOException, ClassNotLoadedException {} // X 두개 오버라이드 불가능

}
