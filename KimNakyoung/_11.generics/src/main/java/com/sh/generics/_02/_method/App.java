package com.sh.generics._02._method;

import com.sh.generics._01._class.Box;

/**
 * <pre>
 * 제네릭 메소드
 * - 타입변수를 메소드레벨에서 선언하고 사용하는 것
 * </pre>
 *
 */


public class App {
    /**
     *
     *
     * @param arg
     * @return
     * @param <T> 타입변수
     */


    //타입별로 응용이 가능하다
    public <T> T process(T arg) {
        // ... 타입별 어쩌구 저쩌구
        return arg;
    }


    // 타입 호출할 때 결정됨
    public static void main(String[] args) {
        App app = new App();
        Integer result = app.process(123);
        System.out.println(result instanceof Integer); // true

        String result2 = app.process("안녕");
        System.out.println(result2 instanceof String); // true

        //Box.<K>of(K value)
        Box<Integer> box = Box.of(123);
        Integer value = box.getValue();
        System.out.println(value instanceof  Integer);
        
    }
}
