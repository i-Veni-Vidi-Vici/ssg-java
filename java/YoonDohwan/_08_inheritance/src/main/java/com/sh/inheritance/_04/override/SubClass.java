package com.sh.inheritance._04.override;

public class SubClass extends SuperClass{
    @Override
    public void method(int num){
        System.out.println("SubClass#method");
    }
    @Override
    //public final void finalMethod(){}

    public  void protectedMethod(){}


}
