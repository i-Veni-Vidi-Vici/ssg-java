package com.sh.polymorphism._01.casting;

/**
 * <pre>
 *     다형성의 활용
 *     1. 매개변수
 * </pre>
 */

public class App3 {
    public static void main(String[] args) {
        App3 app = new App3();

        // 자식객체 Rabbit, Tiger
        Rabbit rabbit = new Rabbit();
        Tiger tiger = new Tiger();

        app.feed(rabbit);
        app.feed(tiger);

        app.feed(new Rabbit());
        app.feed(new Tiger());

        // 객체 배열
        Animal[] animals = new Animal[] {
                new Rabbit(),
                new Tiger(),
                new Rabbit(),
                new Tiger(),
                new Rabbit()
        };

        for(Animal animal : animals) {
            app.feed(animal);
        }

    }


    private void feed(Animal animal) {
        animal.eat();
    }

//    // 메소드 오버로딩
//    private void feed(Rabbit rabbit) {
//        rabbit.eat();
//    }
//    private void feed(Tiger tiger) {
//        tiger.eat();
//    }

}
