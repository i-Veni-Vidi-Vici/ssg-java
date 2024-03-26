package com.sh.singletone;

public class Manager {
    private static Manager hello;
    /**
     * private 생성자를 통해 클래스 외부에서 객체 생성 방지
     */
    private String[] values = new String[3];
    private String str="abc";
    private int[] ints = new int[3];
    private Integer num;

    private Manager(){}

    public static Manager getHello(){
        //최초 1회만 실행

        if(hello == null){
            hello = new Manager();
        }
        return hello;
    }
    public String[] getValues(){
        return this.values;
    }

    public void printValues(){
        System.out.println(values);
    }

    public int[] getInts() {
        return ints;
    }

    public void setInts(int[] ints) {
        this.ints = ints;
    }

    public String getStr(){return this.str;}


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

}
