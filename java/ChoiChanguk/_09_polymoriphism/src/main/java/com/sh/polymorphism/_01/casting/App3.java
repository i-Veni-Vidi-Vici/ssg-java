package com.sh.polymorphism._01.casting;

/**
 * 다형성의 활용1 - 매개변수
 */
public class App3 {
    public static void main(String[] args) {
        App3 app=new App3();

        //자식객체 Rabbit, Tiger
        Rabbit rabbit=new Rabbit();
        Tiger tiger=new Tiger();

//        app.feed(rabbit);
//        app.feed(tiger);
//        app.feed(new Rabbit());
//        app.feed(new Tiger());

        Animal[] animals=new Animal[]{new Rabbit(), new Tiger()};

        for(Animal animal:animals)
        {
            app.feed(animal);
        }

    }

    private void feed(Animal tiger) {
        tiger.eat();
        tiger.run();
        tiger.cry();
    }

//    private void feed(Tiger tiger) {
//        tiger.eat();
//    }
//
//    private void feed(Rabbit rabbit) {
//        rabbit.eat();
//    }
}
