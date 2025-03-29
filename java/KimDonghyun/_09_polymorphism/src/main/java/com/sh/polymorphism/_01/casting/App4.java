package com.sh.polymorphism._01.casting;

/**
 * <pre>
 * 다형성 활용2 - 리턴값
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        App4 app = new App4();
        
        Animal animal = app.generateAnimal();
        animal.cry();
    }

    private Animal generateAnimal() {
        return (int)(Math.random() * 2) == 0 ? new Rabbit() : new Tiger();
    }
}
