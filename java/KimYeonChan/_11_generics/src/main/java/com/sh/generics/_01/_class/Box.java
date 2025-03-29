package com.sh.generics._01._class;

/**
 * 타입변수
 * - T(type), K(key), V(value), E(element) ...
 * - 객체생성시 지정한 타입(클래스)가 타입변수에 바인딩 된다.
 * - new Box<Integer> -> T = Integer
 * - **컴파일타임**에 해당타입으로 바인딩된다.
 *
 * @param <T>
 */
public class Box<T> {
    private T value;

    public void setValue(T value){
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }
}
