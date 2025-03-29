package com.sh.polymorphism._01.casting;

/**
 * 다형성의 활용1 - 매개변수
 */
public class App3 {
    public static void main(String[] args) {
        App3  app = new App3();

        //자식 객체 Rabbit, Tiger
        Rabbit rabbit = new Rabbit();
        Tiger tiger = new Tiger();

        app.feed(rabbit);
        app.feed(tiger);

        app.feed(new Rabbit());
        app.feed(new Tiger());

        //객체 배열
        Animal[] animals = new Animal[]{
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

    /**
     * 다형성 적용 전
     */
//    private void feed(Rabbit rabbit) {
//        rabbit.eat();
//    }
//    private void feed(Tiger tiger) {
//        tiger.eat();
//    }

    private void feed(Animal animal){
        animal.eat();
    }
}
