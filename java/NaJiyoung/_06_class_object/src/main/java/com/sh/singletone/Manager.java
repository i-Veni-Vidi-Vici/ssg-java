package com.sh.singletone;

public class Manager {
    private static Manager instance;    // 해당 타입의 변수 선언
    private String[] values = new String[3];

    /**
     * private 생성자를 통해 클래스 외부에서 객체 생성 방지
     */
    private Manager() {}

    public static Manager getInstance() {
        // 최초 1회만 실행
        if(instance == null) {
            instance = new Manager();
        }
        return instance;
    }

    public String[] getValues() {
        return this.values;
    }
}
