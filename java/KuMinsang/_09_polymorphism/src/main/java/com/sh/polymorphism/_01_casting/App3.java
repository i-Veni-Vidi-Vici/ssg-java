package com.sh.polymorphism._01_casting;

/**
 * <pre>
 *     다형성의 활용1 - 매개변수
 *
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
       App3 app = new App3();

       // 자식객체 Rabbit, Tigier
        Rabbit rabbit = new Rabbit();
        Tiger tiger = new Tiger();

        app.feed (rabbit);
        app.feed(tiger);

        Animal[] animals = new Animal[5];
        animals[0]= tiger;
        animals[1]= rabbit;
        animals[2]= tiger;
        animals[3]= rabbit;
        animals[4]= tiger;
        app.feed(animals);

    }
    private void feed(Animal animal){animal.eat();}
    private void feed(Rabbit rabbit){rabbit.eat();}
    private void feed(Tiger tiger){tiger.eat();}
    private void feed(Animal[] animal){
        for(int i=0; i<animal.length; i++){
            animal[i].eat();
        }
    }


}
