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

        ((Rabbit)(animals[0])).jump();

        for (Animal a : animals) {
//            System.out.println(a);

            // 1. 동적바인딩 (부모-자식 같은 메소드)
            a.eat(); // 정적바인딩? 동적바인딩? 코드는 정적바인딩이야! 변수타입에 따라!
            // 근데 실제 실행과 동시에 객체기준으로..
            // Animal#eat -> Rabbit#eat, Tiger#eat 동적바인딩

//            ((Rabbit) a).jump(); // Rabbit일 때도 있지만 Tiger도 있기때문에 오류 발생
            // Tiger 객체는 Rabbit으로 형변환할 수 없습니다!

            // 2. 다운 캐스팅 이후 해당 메소드 호출
            if (a instanceof Rabbit)
                ((Rabbit) a).jump();

            if (a instanceof Tiger)
                ((Tiger) a).bite();
        }


    }
}
