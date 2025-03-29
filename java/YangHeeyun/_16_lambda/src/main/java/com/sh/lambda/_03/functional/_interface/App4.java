package com.sh.lambda._03.functional._interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.function.ToLongBiFunction;

/**
 * <pre>
 * Function 함수형 인터페이스 관련
 * - 매개인자가 있고, 리턴값도 있다
 * </pre>
 */
public class App4{
    public static void main(String[] args) {
        // Function<T, R>#apply(T):R
        Function<String,Integer> function = (str) -> Integer.parseInt(str);
        System.out.println(function.apply("123") + 321);

        // IntFunction<R><#apply(int):R
        // LongFunction<R>#apply(long):R
        // DoubleFunction<R>#apply(double):R

        // BiFunction<T1, T2, R>#apply(T1,T2):R

        // IntDoubleFunction#applyAsDouble(int):double
        // IntToLongFunction#applyAsLong(int):longl
        // LongToDoubleFunction#applyAsLong(int):long
        // LongToIntFunction#applyAsDouble(long):double
        // DoubleToIntFunction#applyAsInt(double):int
        // DoubleToLongFunction#applyAsLong(double):long

        // ToIntFunction<T>#applyAsInt(T):int
        ToIntFunction<String> toIntFunction = (str) -> str.length();
        System.out.println(toIntFunction.applyAsInt("helloworld"));

        // ToIntBiFunction<T, U>#applyAsInt(T, U):int
        // ToLongFunction<T>#applyAsInt(T):long
        // ToLongBiFunction<T, U>#applyAsInt(T, U):long
        BiFunction<List<String>, String,List<String>> biFunction = (list,str) -> {
            List<String> resultList = new ArrayList<>();
            for(String name:list){
                if(name.startsWith(str))
                    resultList.add(name);
            }
            return resultList;
        };

        List<String> names = Arrays.asList("홍길동","고길동","홍진경"); // 변경불가능한  Immutavl
        String familyName = "홍";
        System.out.println(biFunction.apply(names,familyName));

        // ToDoubleFunction<T>#applyAsInt(T):double
        //ToDoubleBiFunction<T, U>#applyAsInt(T, U):double

    }
}