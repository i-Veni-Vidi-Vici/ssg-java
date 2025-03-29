package com.sh.generics._02._method;

/**
 * 제네릭 메소드
 * - 타입변수를 메소드 레벨에서 선언하고 사용하는 것
 */
public class App {
    /**
     *
     * @param arg
     * @return
     * @param <T> 타입 변수
     */
    public <T> T process(T arg) {
        // 타입별 어쩌구 저쩌구
        return arg;
    }

    public static void main(String[] args) {
        App app = new App();
        Integer result = app.process(123);
        System.out.println(result instanceof Integer);

        String result2 = app.process("Zzz");
        System.out.println(result2 instanceof String);
    }
}
