package com.sh.generics._01._class;

/**
 * <pre>
 * 타입변수
 * - T(type), K(key), V(value), E(elemnet) 말그대로 변수다 임의로 해도된다
 * - 객체생성시 지정한 타입(클래스)가 타입변수에 바인딩된다
 * - new Box<Inteager> -> T = Inteager
 * - !!컴파일타임!!에 해당타입으로 바인딩된다
 * </pre>
 * @param <T>
 */
public class Box<T> {
    private T value;

    public void setValue(T value) {
        this.value=value;
    }

    public T getValue() {
        return this.value;
    }
//이 제네릭 클래스는 단독으로 사용이 가능하다
    public static <k> Box<k> of(k value){
        Box<k> box=new Box<>();
        box.setValue(value);
        return box;
    }
}
