package com.sh.polymorphism._03._interface;

/**
 * <pre>
 * 인터페이스 interface
 * - 자바 클래스와 유사한 형태지만, 상수와 추상메소드만 가질 수  있다.
 * - jdk8부터는 default/static메소드도 사용할 수 있다.
 * - implments 키워드를 사용한다.
 * - 상속을 단일상속이지만, 구현은 다중구현이 가능하다.
 * - 인터페이스끼리의 상속은 extends 키워드를 사용한다. 자식인터페이스 extends 부모인터페이스1,부모인터페이스2
 *
 * </pre>
 *
 */

public class App {
    public static void main(String[] args) {

        // 인터페이스도 부모클래스와 같이 사용가능하다.
        // computer객체는 IProduct타입으로 제어가 가능하다.
        IProduct product = new Computer();
        product.printInfo();
//        product.game(); // 인터페이스타입으로 제어할 때는 Computer의 확장된 기능을 사용할 수 없다.

        ((Computer)product).game(); // 다운캐스팅 가능

        // 인터페이스도 하나의 부모타입으로 할 수 있다.

        // 인터페이스의 상수
        System.out.println(IProduct.MAX_NUM);

        //인터페이스 타입 배열로 제어
        IProduct[] products = new IProduct[] {
                new Computer(),
                new Monitor(),
                new Computer(),
                new Monitor(),
                new Computer()
        };

        for (int i = 0; i < products.length; i++) {
//            System.out.println(products[i]); // 객체 출력
            products[i].printInfo(); // 값출력

            IProduct prod = products[i];
            prod.printInfo(); // 참조변수의 타입에 따라 실행할 메소드가 결정된다 -> 정적바인딩
            // IProduct#printInfo -> 동적바인딩 computer#printInfo, Monitor#printInfo

        }
    // 이거... 바꾸기.. 왜 오류나는거잉?
//        // 매개변수부
        test(new Computer());
        test(new Monitor());
//        // 리턴타입
        IProduct newProduct = generateProduct();

//        public static  void test(IProduct product){}
//
//        public static IProduct generateProduct(){
////            return new Monitor();
//        return;
//        }

        IProduct computer = new Computer();
        computer.defaultMethod();
        IProduct monitor = new Monitor();
        monitor.defaultMethod(); // 오직 자식객체 에서만 쓸 수 있음

        IProduct.staticMethod();


    }

    private static void test(IProduct product) {
    }

    public static IProduct generateProduct() {
        return  new Monitor();

    }



}
