package com.sh.polymorphism._01.casting;

public class App4 {
    public static void main(String[] args) {
        App4 app = new App4();

        Animal animal = app.generateAnimal();
        animal.cry();
    }

    private Animal generateAnimal() {
        return new Rabbit();
    }
}
