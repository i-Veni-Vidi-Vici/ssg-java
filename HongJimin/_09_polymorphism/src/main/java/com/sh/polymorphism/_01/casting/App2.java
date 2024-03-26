package com.sh.polymorphism._01.casting;

/**
 * 다형성이 적용된 객체 배열
 * - 다양한 자식 객체를 부모 타입의 객체 배열로 제어할 수 있음
 */
public class App2 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[5];
        animals[0] = new Rabbit();
        animals[1] = new Tiger();
        animals[2] = new Rabbit();
        animals[3] = new Tiger();
        animals[4] = new Rabbit();

        for (int i = 0; i < animals.length; i++) {
//            System.out.println(animals[i]);

            //1. 동적 바인딩
//            animals[i].eat(); //

            Animal animal = animals[i];
            animal.eat(); //Animal#eat -> Rabbit#eat, Tiger#eat 동적 바인딩

            //2. 다운캐스팅 이후 해당 메소드호출
            if (animal instanceof Rabbit) {
                ((Rabbit) animal).jump();  //ClassCastException
            }
            if(animal instanceof Tiger){
                ((Tiger)animal).bite();
            }

        }
    }
}
