package com.sh.polymorphism._01.casting;

/**
 * <pre>
 * 다형성의 활용1 - 매개변수
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        App3 app = new App3();

        // 자식객체 Rabbit, Tiger
        Rabbit rabbit = new Rabbit();
        Tiger tiger = new Tiger();

//        app.feed(rabbit);
//        app.feed(tiger);
//
//        app.feed(new Rabbit());
//        app.feed(new Tiger());

        Animal[] animals = new Animal[] {
                new Rabbit(),
                new Tiger(),
                new Rabbit(),
                new Tiger(),
                new Rabbit()
        };

        for (Animal a : animals) {
            app.feed(a);
        }
    }

    // 메소드 오버로딩 ... feed를 여러개!
    private void feed(Animal animal) { // Rabbit 매개인자가 Animal 매개변수에 담기는데 Animal animal = rabbit; // upcasting
        animal.eat();
    }

//    private void feed(Rabbit rabbit) { // 우선으로 호출되긴 하지만, 없으면 다형성 이용
//        rabbit.eat();
//    }
//    private void feed(Tiger tiger) {
//        tiger.eat();
//    }

}
