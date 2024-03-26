package com.sh.polymorphism._01.casting;

/**
 * 다형성이 적용된 객체배열
 *  - 다양한 자식객체를 부모타입의 객체배열로 제어
 */
public class App2 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[5];
        animals[0] = new Rabbit();
        animals[1] = new Tiger();
        animals[2] = new Tiger();
        animals[3] = new Rabbit();
        animals[4] = new Tiger();

        for(int i =0; i< animals.length; i++){
            System.out.println("animals[i] = " + animals[i]);
            animals[i].eat();
            animals[i].run();
            animals[i].cry();
            if(animals[i] instanceof Rabbit){
                ((Rabbit)animals[i]).jump();
            }
            if(animals[i] instanceof Tiger){
                ((Tiger)animals[i]).bite();
            }

            System.out.println();
        }
    }
}
