package com.sh.generics._01._method;

import com.sh.generics._01._class.Box;

/**
 * <pre>
 * 타입변수를 메소드레벨에서 선언하고 사용하지 않는 것
 *
 * <T></>
 * </pre>
 */
public class App {
    public <T> T process(T arg)
    {
        return arg;
    }

    public static void main(String[] args) {
        App app=new App();
        Integer result=app.process(123);
        System.out.println(result instanceof Integer);

        String str=app.process("안녕");
        System.out.println(str instanceof String);

        //Box.<k>of(k value)
        Box<Integer> box=Box.of(123);
        Integer value=box.getValue();
        System.out.println(value instanceof Integer);
    }
}
