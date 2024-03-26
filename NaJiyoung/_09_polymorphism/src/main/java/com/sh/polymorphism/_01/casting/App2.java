package com.sh.polymorphism._01.casting;

/**
 * <pre>
 * 다형성이 적용된 객체배열
 * - 다양한 자식객체를 부모타입의 객체배열로 제어할 수 있다.
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[5];
        animals[0] = new Rabbit();
        animals[1] = new Tiger();
        animals[2] = new Rabbit();
        animals[3] = new Tiger();
        animals[4] = new Rabbit();

        for(int i=0; i<animals.length; i++) {
//            System.out.println(animals[i]); // toString()으로 자동 호출

            // 1. 동적바인딩
//            animals[i].eat();

            Animal animal = animals[i];
            animal.eat();   // Animal#eat -> Rabbit#eat, Tiger#eat 동적바인딩

//            ((Rabbit) animal).jump();   // ClassCastException 예외 발생!
            // jump()가 오버라이드된 메소드가 아니므로 Tiger일 땐 없다

            // 2. 다운캐스팅 이후 해당메소드 호출
            if(animal instanceof Rabbit) {
                ((Rabbit) animal).jump();
            }
            if(animal instanceof Tiger) {
                ((Tiger) animal).bite();
            }
        }
    }
}
