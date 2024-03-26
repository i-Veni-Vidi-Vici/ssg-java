package com.sh.polymorphism._01.casthing;


/**
 * <pre>
 * 다형성 활용2 - 리턴값
 * </pre>
 *
 *
 */
public class App4 {
    public static void main(String[] args) {
        App4 app = new App4();

        Animal animal = app.generateAnimal(); // 받을 땐 애니멀로 받습니다.
        animal.cry(); // 래빗객체가 잘 넘어와서 래빗 크라잉 나옴
        // 래빗이 애니멀의 자식 객체 이기 때문에 가져오기 가능
    }

    private Animal generateAnimal() {

        return (int) (Math.random() * 2) == 0 ? new Rabbit() : new Tiger();
//        return new Rabbit();
//        return new Tiger();

    }




}
