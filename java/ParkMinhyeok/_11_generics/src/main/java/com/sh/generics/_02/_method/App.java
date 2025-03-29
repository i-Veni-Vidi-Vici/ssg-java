package com.sh.generics._02._method;

import com.sh.generics._01._class.Box;

/**
 * 제네릭 메소드
 * - 타입변수를 메소드 레벨에서 선언하고 사용하는 것
 */
public class App {
    /**
     *
     * @param arg
     * @return
     * @param <T>
     */
    public <T> T process(T arg) {
        return arg;
    }

    public static void main(String[] args) {
        App app = new App();
        Integer result = app.process(123);
        System.out.println(result instanceof Integer);

        String result2 = app.process("안녕");
        System.out.println(result2 instanceof String);

        // Box.<K>of(K value)
        Box<Integer> box = Box.of(123);
        Integer value = box.getValue();
        System.out.println(value instanceof Integer);
    }
}