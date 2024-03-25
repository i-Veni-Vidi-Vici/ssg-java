package com.sh.polymorphism._01.casthing;

public class App2 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[5];
        animals[0] = new Rabbit();
        animals[1] = new Tiger(); // 여기에 타이거 객체
        animals[2] = new Rabbit();
        animals[3] = new Tiger(); // 여기에 타이거 객체
        animals[4] = new Rabbit();
        for (int i = 0; i < animals.length; i++) {
//            System.out.println(animals[i]);


            //1.동적바인딩
//            animals[i].eat(); // 동적바인딩

            Animal animal = animals[i];
            animal.eat(); // Animal # 잇 -> 래빗#잇 타이거#잇 동적바인딩 (조건 : 상속 다형성 오버라이딩)

            // 래빗형일때만 형변환이라는 조건을 안준다면?
            // 타이거(자식) 객체가 들어있는 인덱스가 있는데 거기를 강제로 레빗(자식)으로 형변환 하려고 해서 오류남
            // 지금은 줘서 오류 안남

            // 2. 다운캐스팅이후 해당메소드 호출
            // 오버라이딩 안됐으면 어떻게 할꺼야? 형 바꿀때 형 확인하고 변환하기
            if( animal instanceof Rabbit) {
                ((Rabbit) animal).jump();
            }
            if ( animal instanceof  Tiger) {
                ((Tiger) animal).bite();
            }

        }

    }
}
