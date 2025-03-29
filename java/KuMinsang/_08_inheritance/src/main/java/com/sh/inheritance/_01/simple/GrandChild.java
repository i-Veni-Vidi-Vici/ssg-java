package com.sh.inheritance._01.simple;

/**
 * Parent -> Child -> GrandChild 순으로 상속이된다
 * 점점 확장되는 구조
 */
public class GrandChild extends Child{
    @Override
    public void introduce() {
        System.out.println("손자입니다");

    }
}
