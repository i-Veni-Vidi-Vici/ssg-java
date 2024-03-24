package com.sh.singleton;

public class Manager {
    private static Manager instance;
    //값을 관리하기가 편함. App클래스에서 여러개의 객체를 생성한다 해도 똑같은 객체를 가르킴
    //
    private String[] values = new String[3];

    /**
     * private 생성자를 통해 클래스 외부에서 객체 생성 방지
     */

    private Manager(){}

    public static Manager getInstance(){
        //최초 1행 실행 후 객체 할당
        if(instance == null){
            instance = new Manager();
        }
        return instance;
    }

    public String[] getValues()
    {
        return this.values;
    }
}
