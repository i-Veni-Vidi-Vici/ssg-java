package com.sh.polymorphism._01.casting;

/**
 * <pre>
 * 다형성 활용2 - 리턴값
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        App4 app = new App4();

        Animal animal = app.generaeteAnimal();
        animal.cry();
    }

    public Animal generaeteAnimal(){
        return (int)(Math.random()*2) == 0? new Rabbit() : new Tiger(); // 0,1중 랜덤
    }
}
