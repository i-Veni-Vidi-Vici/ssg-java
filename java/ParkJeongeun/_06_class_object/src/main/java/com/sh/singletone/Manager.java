package com.sh.singletone;

public class Manager {
    private static Manager instance;

    // 객체 여러개면 관리 어려움 -> getValues로만 호출할 수 있게 함
    private String[] values = new String[3];

    /**
     * private 생성자를 통해 클래스 외부에서 객체 생성 방지
     */

    private Manager(){}

    public static Manager getInstance(){
        // 최초 1회만 실행
        if (instance == null){
            instance = new Manager();
        }
        return instance; // instance가 null이 아니면 만들어둔 instance를 return
    }

    public String[] getValues(){
        return this.values;
    }
}
