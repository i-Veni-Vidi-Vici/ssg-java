package com.sh.polymorphism._01.casthing;


/**
 *
 * <pre>
 *  다형성의 활용1 - 매개변수
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        App3 app = new App3();
        // 자식객체 Rabbit, Tiger
        Rabbit rabbit= new Rabbit();
        Tiger tiger = new Tiger();

        app.feed(rabbit);
        app.feed(tiger);
        System.out.println("------------------------");

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

    // 이거 왜ㅐ 잘되는건가?
    // 자식객체를 부모타입에 넣는 상황 Animal animal = rabbit;

    private  void feed(Animal animal){
        animal.eat();

    }



//    // rabbit꺼
//    // 메소드 오버로딩 (쌓는겁니다......)
//    private void feed(Rabbit rabbit) {
//        rabbit.eat();
//
//    }
//    // tiger꺼
//    // 메소드 오버로딩
//    private void feed(Tiger tiger){
//        tiger.eat();
//
//    }


}
