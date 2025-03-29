package com.sh.singletone;
public class Manager {
    private static Manager instance;
    /**
     * private 생성자를 통해 클래스외부에서 객체 생성 방지
     */
    private String[] value=new String[3];
    public static Manager getInstance()
    {
        if (instance == null) {
            instance =new Manager();
        }
        return instance;
    }
    public String[] getValues()
    {
        return this.value;
    }
}
