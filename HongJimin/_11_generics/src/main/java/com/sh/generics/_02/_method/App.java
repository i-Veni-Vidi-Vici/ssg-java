package com.sh.generics._02._method;

import com.sh.generics._01._class.Box;

/**
 * <pre>
 *
 * </pre>
 */
public class App {
    /**
     *
     * @param arg
     * @param <T> : 타입 변수
     */
    public <T> T process(T arg) {
        // ... 타입별 어쩌구 저쩌구
        return arg;
    }
    public static void main(String[] args) {
        App app = new App();
        Integer result = app.process(123); //호출했을 때, T가 int 타입으로 결정됨
        System.out.println(result instanceof Integer); //true

        String result2 = app.process("안녕");
        System.out.println(result2 instanceof String); //true

        //Box.<K>of (K value)
        Box<Integer> box = Box.of(123); //호출했을 때, K가 int타입으로 결정됨
        Integer value = box.getValue();
        System.out.println(value instanceof Integer);//true
    }

}
