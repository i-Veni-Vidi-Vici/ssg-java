package com.sh.singletone;

public class Manager {
    private static Manager instance;
    private String[] values = new String[3]; // 값 3개 보관

    /**
     * private 생성자를 통해 클래스 외부에서 객체 생성 방지
     */
    private Manager(){} // 외부에서 호출하지 못하도록 막음

    public static Manager getInstance(){
        // 최초 1회만 실행
        if(instance == null) {
            instance = new Manager();
        }
        return instance;
    }

    public String[] getValues(){
        return this.values;
    }
}
