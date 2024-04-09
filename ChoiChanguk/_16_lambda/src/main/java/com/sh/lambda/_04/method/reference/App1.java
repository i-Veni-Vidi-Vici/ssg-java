package com.sh.lambda._04.method.reference;

import com.sh.lambda._02.anonymous.clazz.Func;

import java.util.function.*;

/**
 * <pre>
 * 메소드 참조
 *  - 람다식을 더 간결하게 표현하는 문법
 *  - namespace:mehtod -> 클래스 또는 객체 ::메소드명
 *
 *
 *  - static method
 *  - non-staic method
 *  - 특정객체 기준 메소드
 *  - 생성자
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
        //Consumer<String > consumer=(str)-> System.out.println(str);
        //어차피 입력값은 하나고, 그 값을 건들지 않으니, 입력값은 하나가 들어오니깐 이렇게 쓴다
        Consumer<String > consumer= System.out::printf;
        System.out.print("Consumer : ");
        consumer.accept("안녕하세요\n");

        //"123"->123
        Function<String ,Integer> function=(str)->Integer.parseInt(str);
        System.out.print("Function : ");
        System.out.println(function.apply("123456"));

        //"abcdd" -> 5
        //사실 이런건 평소에는 안쓰지만
        Function<String ,Integer>function1=(str)->str.length();
        System.out.println("문자 길이 : ");
        System.out.println(function1.apply("abcde")+"\n");
        //==
        ToIntFunction<String > toIntFunction=String::length;
        System.out.println("문자 길이 : ");
        System.out.println(toIntFunction.applyAsInt("abcde"));

        //특정객체 기준 메소드참조
        BiFunction<String ,String ,Boolean>biFunction=String::equals;
        System.out.printf("동등비교 : ");
        System.out.println(biFunction.apply("안녕하세요","안녕하세요"));

        //람다 안에 외부 변수를 가져온다
        //응용이 가능한다 ex)
        String str = "i want go home";
        Predicate<String> predicate=(txt)->str.equals(txt);
        System.out.println(predicate.test("go home"));

        //생성자 참조
        //Supplier<Person>supplier1=()->new Person();
        Supplier<Person>supplier1=Person::new;
        System.out.println(supplier1.get());

        //long 생성자 호출
        Function<Long,Person> function2=(id)->new Person(id);
        System.out.println(function2.apply(1L));

        //long, String, int 생성자 호출
        //BiFunction<String ,Integer,Person> biFunction1=(name,age)->new Person(name,age);
        BiFunction<String ,Integer,Person> biFunction1=Person::new;
        System.out.println(biFunction1.apply("최창욱",33));

        //long, String, int 생성자 호출
        //TriFunction<Long, Integer,Person> triFunction=;;

        //배열생성
        //Function<Integer, int[]> intArrGenerater=(length)->new int[length];
        Function<Integer, int[]> intArrGenerater=int[]::new;
        System.out.println(intArrGenerater.apply(5).length);

    }
}
