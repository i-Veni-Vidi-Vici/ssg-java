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
//        Rabbit animal = app.generateAnimal();
        animal.cry();
        ((Rabbit)(animal)).jump();
    }

    private Animal generateAnimal() {
        return new Rabbit(); // Animal을 돌려준다했는데 Rabbit 객체 돌려주기 가능
//        return new Tiger(); // Animal을 돌려준다했는데 Tiger 객체 돌려주기 가능
//        return (int)(Math.random()*2) == 0 ? new Rabbit() : new Tiger();
    }
}
