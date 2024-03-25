package com.sh.polymorphism._01.casting;

/**
 * <pre>
 * 다형성 활용2 - 리턴값
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        App4 app = new App4();

        // Math.random 쓸 때는 Tiger값이 반환 될 수 있기 때문에 변수 타입을 무조건 Animal로 해야 함 (Rabbit X)
        Animal animal = app.generateAnimal();
        animal.cry();
    }

    private Animal generateAnimal() {
//        return new Rabbit(); // Rabbit이 Animal 의 자식이기 때문에 Animal 타입의 메소드에 리턴값으로 가능
    return (int)(Math.random() * 2) == 0 ? new Rabbit() : new Tiger();
    }
}
