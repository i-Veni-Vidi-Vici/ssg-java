package com.sh.polymorphism._01.casting;

public class App3 {
    public static void main(String[] args) {
        App3 app = new App3();
        Rabbit rabbit = new Rabbit();
        Tiger tiger = new Tiger();

        app.feed(rabbit);
        app.feed(tiger);
    }

    private void feed(Animal animal) {
        animal.eat();
    }
}
