package com.sh._static;

import javax.swing.*;
import java.util.concurrent.CountedCompleter;

/**
 * <pre>
 * static 필드 / static 메소드 -> static 자원이라고도 한다
 * - JVM이 사용하는 메모리영역중 정적영역에서 관리되는 자원
 * - 프로그램 실행 시 메모리에 적재되서, 프로그램 종료 시 까지중이 가능함
 * - 인스턴스간의 데이터 공유 목적으로 사용한다.
 * - 무분별한 static 자원 사용은 금물이다
 * - static 자원을 활용하는 대표적으로 예가 클래스 상수 또는 singletone등이 있다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        Counter counter1=new Counter();
        Counter counter2=new Counter();
        //non-static변수 count를 객체별로 각각 증가
        counter1.increaseCount();
        counter2.increaseCount();
       System.out.println(counter1.getCount());
       System.out.println(counter2.getCount());

        //static별로 scount를 각객체에서 한번 증가
        counter1.increaseCount();
        counter2.increaseCount();
        //System.out.println(counter1.getCount());
        //System.out.println(counter2.getCount());

        //App.abc(); non-static이라 -> static하면 가능함

    }

    public void abc() {

    }
}
