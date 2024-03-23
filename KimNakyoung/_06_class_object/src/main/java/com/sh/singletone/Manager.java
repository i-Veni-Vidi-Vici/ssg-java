package com.sh.singletone;

public class Manager {
    private static Manager instance;

    private String[] values = new String[3];

    /**
     *
     * private 생성자를 통해 클래스외부에서 객체 생성 방지
     */

//    private Manager(){}

    // manager를 반환
    public static Manager getInstance(){
        if(instance == null){
            instance = new Manager(); // 최초 1회 할당
        }
        return instance; // 두번째 부터 만들어진 객체 재사용


        /**
         *
         * private 생성자를 통해 클래스외부
         */
    }
    public String[] getValues(){
        return this.values;
    }

//    private Manager();
}
