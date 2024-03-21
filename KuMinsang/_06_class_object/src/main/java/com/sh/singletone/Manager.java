package com.sh.singletone;

public class Manager {
    private static Manager instance;
    /**
     * private 생성자를 통해 클래스 외부에서 객체 생성 방지
     */
    private String[] values = new String[3];
    private String str="abc";
    private Integer[] ints = new Integer[3];
    private Integer num;

    private Manager(){}

    public static Manager getInstance(){
        //최초 1회만 실행
        if(instance == null){
            instance = new Manager();
        }
        return instance;
    }
    public String[] getValues(){
        return this.values;
    }

    public void printValues(){
        System.out.println(values);
    }

    public Integer[] getInts() {
        return ints;
    }

    public void setInts(Integer[] ints) {
        this.ints = ints;
    }

    public String getStr(){return this.str;}


    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
