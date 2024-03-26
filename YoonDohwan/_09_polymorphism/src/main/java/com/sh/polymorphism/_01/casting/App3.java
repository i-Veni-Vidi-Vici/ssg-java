package com.sh.polymorphism._01.casting;

/**
 * 다형성의 활용1-매개변수
 *
 */
public class App3 {
    public static void main(String[] args) {
        App3 app = new App3();

        //자식객체 Rabbit, Tiger
        Rabbit rabbit = new Rabbit();
        Tiger tiger = new Tiger();

        app.feed(rabbit);
        app.feed(tiger);

    }
    public void feed(Animal animal){
        animal.eat();
    }
   // public void feed(Tiger tiger){
     //   tiger.eat();
    //}
    Animal[] animals = new Animal[]{
     new Rabbit(),new Tiger(), new Rabbit(),new Tiger(), new Rabbit()
   };
  //  for(Animal animal : animals){
   //     app.feed(animal);
  //  }
  //  private void feed(Animal animal){
  //      animal.eat();
   // }
}
