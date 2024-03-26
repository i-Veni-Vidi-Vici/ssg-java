package com.sh.polymorphism._01.casting;

/**
 * <pre>
 * 다형성이 적용된 객체배열
 * - 다양한 자식객체를 부모타입의 객체배열로 제어할 수 있다.
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[5];  // animal 배열로 자식객체를 제어할 수 있다.
        animals[0] = new Rabbit();
        animals[1] = new Tiger();
        animals[2] = new Rabbit();
        animals[3] = new Tiger();
        animals[4] = new Rabbit();

        for(int i = 0; i < animals.length; i++){
//            System.out.println(animals[i]);  // toString이 자동으로 호출

            // 1. 동적바인딩
//            animals[i].eat();

            animals[i].eat(); // 정적바인딩? 동적바인딩?

            Animal animal = animals[i];
            animal.eat();  // Animal#eat -> 실제로 Rabbit#eat, Tiger#eat으로 호출된다 -> 동적바인딩

            // 2. 다운캐스팅 이후 해당메소드 호출
            if(animal instanceof Rabbit) {  // Rabbit일때만 jump한다.
                ((Rabbit)animal).jump();
            }

            if(animal instanceof Tiger) {  // Tiger일때만 bite한다.
                ((Tiger)animal).bite();
            }
        }


    }
}
