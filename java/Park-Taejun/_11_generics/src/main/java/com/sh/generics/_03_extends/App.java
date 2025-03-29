package com.sh.generics._03_extends;

/**
 * <pre>
 * Generic 상한/하한 제한
 * - <A extends B> B를 상속하는 A타입만 가능 (상한 제한) // 주로 상한 제한을 많이 씀       B는 실제 클래스
 * - <A super B> B의 부모클래스인 A타입만 가능 (하한 제한)
 *
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // RabbitFarm<T>  // 애니멀이면 다 ㅇㅋ
//        RabbitFarm<Animal> animalFarm = new RabbitFarm<>(new Mammal()); // 다형성 적용
//        RabbitFarm<Animal> animalFarm2 = new RabbitFarm<>(new Reptile());
//        RabbitFarm<Animal> animalFarm3 = new RabbitFarm<>(new Rabbit());
//        RabbitFarm<Animal> animalFarm4 = new RabbitFarm<>(new Snake());
////        RabbitFarm<LocalDate> localDateRabbitFarm = new RabbitFarm<>

        // RabbitFarm<T extends Rabbit> 만된다
        RabbitFarm<Rabbit> rabbitFarm = new RabbitFarm<>(new Rabbit());
        RabbitFarm<Rabbit> rabbitFarm2 = new RabbitFarm<>(new Bunny());
        RabbitFarm<Rabbit> rabbitFarm3 = new RabbitFarm<>(new DrunkenBunny()); // 다형성 덕분에 버니 드렁큰 버니도 올 수 있음


        RabbitFarm<Bunny> bunnyRabbitFarm = new RabbitFarm<>(new Bunny());
        RabbitFarm<Bunny> bunnyRabbitFarm2 = new RabbitFarm<>(new DrunkenBunny()); // 다형성

        RabbitFarm<DrunkenBunny> drunkenBunnyRabbitFarm = new RabbitFarm<>(new DrunkenBunny());

        Rabbit rabbit = rabbitFarm.getRabbit(); // 리턴 타입은 래빗일것임
        rabbit.cry();
        Rabbit rabbit2 = rabbitFarm2.getRabbit(); // 바니가 들어간건 다형성 덕분이고 실제 꺼내는건 래빗까지만 보장이 되는 것임.
        rabbit2.cry(); //왜 얼굴토끼가 난올가? 동적바인딩? 정적바인딩? 동적바인딩,,,! // 상속/ 다형성이 적용되고 오버라이드 됐을떄 -> 동적바인딩이 된다
        // Rabbit 이 rabbit2 객체에 들어가 있네.. 하고 상속 다형성이 적용 되고 오버라이딩까지 됐으므로

        //AnimalFarm< A extends Animal>
        AnimalFarm<Animal> animalFarm = new AnimalFarm<>();
        AnimalFarm<Reptile> reptileAnimalFarm = new AnimalFarm<>();
        //래빗 스네이크도 전부 다 될건데 엉뚱한 것은 안된다.



    }
}
