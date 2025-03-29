package com.sh.generics._02._method;

import com.sh.generics._01._class.Box;

public class App {
    /**
     *
     * @param arg
     * @return
     * @param <T> 타입변수
     */
    public <T> T process(T arg) {
        // ... 타입별 어쩌구 저쩌구
        return arg;
    }

    public static void main(String[] args) {
        App app = new App();
        Integer result = app.process(1233);
        System.out.println(result instanceof Integer);

        String result2 = app.process("안녕");
        System.out.println(result2 instanceof String);

        // Box.<K>of(K value)
        Box<Integer> box = Box.of(123);
        Integer value = box.getValue();
        System.out.println(value instanceof Integer);
    }
}
