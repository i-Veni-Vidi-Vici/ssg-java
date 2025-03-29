package com.sh.polymorphism._01.casting;

/**
 * <pre>
 * 다형성이 적용된 객체 배열
 * - 다양한 자식 객체를 부모타입의 객체배열로 제어
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[5];
        animals[0] = new Rabbit();
        animals[1] = new Tiger();
        animals[2] = new Rabbit();
        animals[3] = new Tiger();
        animals[4] = new Rabbit();

        for (int i = 0; i < animals.length; i++){
//            System.out.println(animals[i]);
            animals[i].eat(); // v
        }
    }
}
