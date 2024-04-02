package com.sh.polymorphism._01.casting;

/**
 * <pre>
 * 다형성 활용 2 - 리턴값
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        App4 app = new App4();

        Animal animal = app.generateAnimal();
        animal.cry();

    }

    private Animal generateAnimal() { //왜 Animal 객체가 아니라 Rabit 객체를 준다는데 왜 될까 반대로 tiger됨 자식객체이기 때문에
        return (int)(Math.random() * 2) == 0? new Rabbit() : new Tiger();
    }
}
