package com.sh.generics._02.method;

import com.sh.generics._01._class.Box;

/**
 * <pre>
 * 제네릭 메서드
 * - 타입변수를 메서드레벨에서 선언하고 사용하는 것
 *
 * </pre>
 */
public class App {
    /**
     *
     * @param arg
     * @return
     * @param <T> 타입변수
     */
    public <T> T process(T arg) {
        // ... 타입별
        return arg;
    }
    public static void main(String[] args) {
        App app = new App();
        Integer result = app.process(123);
        System.out.println(result instanceof Integer); // true

        String result2 = app.process("안녕");
        System.out.println(result2 instanceof String); // true

        // Box.<K>of(K value)
        Box<Integer> box = Box.of(123);
        Integer value = box.getValue();
        System.out.println(value instanceof Integer);
    }
}
