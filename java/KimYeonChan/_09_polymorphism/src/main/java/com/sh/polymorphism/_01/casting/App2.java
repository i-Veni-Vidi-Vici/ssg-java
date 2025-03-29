package com.sh.polymorphism._01.casting;

/**
 * 다형성이 적용된 객체배열
 * - 다양한 자식객체를 부모타입의 객체배열로 제어할 수 있다.
 */
public class App2 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[5];
        animals[0] = new Rabbit();
        animals[1] = new Rabbit();
        animals[2] = new Rabbit();
        animals[3] = new Rabbit();
        animals[4] = new Tiger();

        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i].hashCode());
            animals[i].eat(); // 동적 바인딩
            if (animals[i] instanceof Rabbit) {
                ((Rabbit) animals[i]).jump();
            }
            if (animals[i] instanceof Tiger) {
                ((Tiger) animals[i]).bite();
            }
        }
    }
}
