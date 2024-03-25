package com.sh.polymorphism._03_interface;

/**
 * <pre>
 *     인터페이스 interface
 *     - 자바 클래스와 유사한 형태지만, 상수와 추상메소드만 가질수 있다.
 *     - jdk8부터는 default/static메소드도 가질수 있다
 *     - 자식에게 상속이 주목적이 아닌 구현을 강제하는것이 주목적이다
 *     - implements 키워드를 사용할 수없다
 *     - 상속은 단일 상속이지만, implement는 다중구현이 가능하다
 *     - ex) implement IProduct, Discountable....
 *     -인터페이스 끼리의 상속은 extends 키워드를 사용한다
 *     - ex)자식인터페이스 extends 부모인터페이스1, 부모인터페이스2
 *
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //인터페이스도 부모클래스와 같이 사용가능하다
        //Computer 객체는 IProduct 타입으로 제어가 가능하다
        IProduct product = new Computer();
        product.printInfo();
//        product.game(); //인터페이스 타입으로는 Computer의 확장된 기능을 사용할수 없다
        ((Computer) product).game();

        //인터페이스의 상수
        System.out.println(IProduct.MAX_NUM);

        //인터페이스 타입 배열로 제어
        IProduct[] products = new IProduct[]{
                new Computer(),
                new Monitor(),
                new Computer(),
                new Monitor(),
                new Computer(),
                new Monitor(),
        };

        for(int i =0; i<products.length; i++){
//            System.out.println(products[i]);
//            products[i].printInfo();
            IProduct prod = products[i];
            prod.printInfo();   // 정적 바인딩 IProduct#printInfo -> Computer#printInfo, Monitor#printInfo
        }

        test(new Computer());
        test(new Monitor());

        IProduct newProduct = generateProduct();

        //default method 사용하기
        IProduct newproduct = new Computer();
        newproduct.defaultmethod();

        IProduct.staticMethod();


    }
    public static void test(IProduct product){}
    public static IProduct generateProduct(){
//        return new Monitor();
        return new Computer();
//        return new IProduct();    //인터페이스 자체를 객체화 할수 없다
    }

}
