package com.sh.polymorphism._01.casting;

/**
 * <pre>
 *  다형성의 활용1 - 매개변수
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        App3 app = new App3();

        // 자식객체 Rabbit, Tiger
        Rabbit rabbit = new Rabbit();
        Tiger tiger = new Tiger();

        app.feed(rabbit);  // Animal animal = rabbit; -> 20-21줄에 작성됨
        app.feed(tiger);  // Animal animal = tiger; -> 20-21줄에 작성됨

        app.feed(new Rabbit());
        app.feed(new Tiger());

        // 객체배열
        Animal[] animals = new Animal[]{
                new Rabbit(),
                new Tiger(),
                new Rabbit(),
                new Tiger(),
                new Rabbit(),
        };

        for(Animal animal : animals) {  // for-each문은 인덱스없이 사용가능
            app.feed(animal);
        }
    }

    private void feed(Animal animal){
        animal.eat();
    }
//    private void feed(Rabbit rabbit) {
//        rabbit.eat();
//    }
//
//    private void feed(Tiger tiger) {
//        tiger.eat();
//    }

}
