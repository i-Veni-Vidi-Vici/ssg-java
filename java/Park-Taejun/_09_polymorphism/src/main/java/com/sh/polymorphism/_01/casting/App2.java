package com.sh.polymorphism._01.casting;

/**
 * <pre>
 * 다형성이 적용된 객체배열
 * - 다양한 자식객체를 부모타입의 객체배열로 제어할 수 있다.
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        Animal [] animals = new Animal[5];
        animals[0] = new Rabbit();
        animals[1] = new Tiger();
        animals[2] = new Rabbit();
        animals[3] = new Tiger();
        animals[4] = new Rabbit();

        for( int i = 0; i < animals.length; i++){
            System.out.println(animals[i]); //자동으로 toString 찍힐것임
            //com.sh.polymorphism._01.casting.Rabbit@24d46ca6
            //com.sh.polymorphism._01.casting.Tiger@4517d9a3
            //com.sh.polymorphism._01.casting.Rabbit@372f7a8d
            //com.sh.polymorphism._01.casting.Tiger@2f92e0f4
            //com.sh.polymorphism._01.casting.Rabbit@28a418fc

            Animal animal = animals[i];
            animal . eat(); // Aniaml의 eat으로 되었는데 -> Rabbit 객체의 eat과 Tiger#eat의 객체가 호출이 되더라 동적바인딩

                // 아래는 동적 바인딩
//            animals[i].eat(); //정적바인딩? 동적바인딩? 만약 rabbit의 eat과 tiger의 eat 뺴버리면 animal로 나옴
            // animal 타입의 eat이니까 Animal 하지만 원래는 Rabbit 객체임 따라서 상속 다형성 적용되있고 메소드 오버라이드 되어있으면
            //오버라이드 된 메소드로 연결이 됨 -> 이것이 바로 동적바인딩임.


             //자식에만 있으면 형변환으로 다운캐스팅 이후 해당 메소드 호출
            if(animal instanceof Rabbit) {
                ((Rabbit) animal).jump(); // 타이거를 억지로 레빗으로 변환하려고 하면 exception 오류 뜨게 됨
            }
                if (animal instanceof Tiger){
                    ((Tiger) animal).bite();
                }
            }
        }




    }