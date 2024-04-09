package com.sh.lambda._03.functional._interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToIntFunction;

/**
 * Function 함수형 인터페이스 관련
 * - 매개인자가 있고, 리턴값도 있다.
 */
public class App4 {
    public static void main(String[] args) {
        // Function <T, R ># apply(T) : R
        //String 받아서 Integer로 반환
        Function<String, Integer> function = (str) -> Integer.parseInt(str);
        System.out.println(function.apply("123") + 321);

        //IntFunction<R>#apply(int):R
        //LongFunction<R>#apply(long):R
        //DoubleFunction<R>#apply(double):R

        //IntFunction 은 제네릭이 없음 IntFunction은 인트 받아서 인트 반환 #apply(int):int
        //LongFunction # apply(long) : long
        //DoubFunction

        //BiFunction<T1, T2, R>#apply(T1, T2):R

        //IntToDoubleFunction # applyAsDouble(int):double
        //IntToLongFunction # applyAsLONG(int):long 인트를 받고 롱을 반환
        // LongToDoubleFunction # applyAsDouble(long):double
        //LongToIntFunction # applyAsInt(Long) :int
        //DoubleToIntFunction # applyAsint (double) :int
        //DoubleToLongFunction

        //ToIntFunction<T>#applyAsInt(T) : int
        ToIntFunction<String> toIntFunction = (str) -> str.length();
        System.out.println(toIntFunction.applyAsInt("helloworld"));


        //ToIntBiFunction<T, U>#applyAsInt(T, U) : int
        //ToLongFunction<T>#applyAsLong(T) : long
        //ToLongBiFunction<T>#applyAsLong(T, U) : long
        //ToDoubleFunction<T>#applyAsDouble(T) : double
        //ToDoubleBiFunction<T>#applyAsDouble(T, U) : double

        BiFunction<List<String>, String , List<String>> biFunction = (list, str) ->{
            List<String> resultList = new ArrayList<>();
            for (String name : list){
                if (name.startsWith(str))
                    resultList.add(name);
            }
            return resultList;
        };
        List<String> names = Arrays.asList("홍길동", "고길동", "홍진경"); // 변경불가능한 Immutable ArrayList 반환
        String familyName = "홍";
        List<String> resultList = biFunction.apply(names, familyName);
        System.out.println(biFunction.apply(names, familyName));


    }
}
