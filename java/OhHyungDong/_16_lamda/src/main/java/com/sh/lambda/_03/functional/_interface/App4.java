package com.sh.lambda._03.functional._interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToLongFunction;

/**
 * <pre>
 *   Function 함수형 인터페이스 관련
 *   - 매개인자가 있고, 리턴값도 있다.
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        Function<String, Integer> function = (str) -> Integer.parseInt(str);
        System.out.println(function.apply("123") + 321);

        //IntFunction<R>#apply(int) : int
        //LongFunction<R>#apply(Long) : long
        //DoubleFunction<R>(double) : double

        //BiFunction<T1, T2, R>#apply(T1,T2) : R

        //IntToDoubleFunction#applyAsDouble(int) : double
        //IntToLongFunction#applyAsLong(int) : long
        //LongToDoubleFunction#applyAsDouble(long) : double
        //LongToIntFunction#applyAsInt(long) : int
        //DoubleToIntFunction#applyAsInt(double) : int
        //DoubleToLongFunction#applyAsLong(double) : long

        //ToIntFunction<T>#applyAsInt(T):int
        //ToLongFunction<T>#applyAsLong(T):long
        //ToDoubleFunction<T>#applyAsDouble(T):double
        //ToLongFunction<T,U>#applyAsLong(T):long
        //ToDoubleFunction<T>#applyAsDouble(U):double
        //ToDoubleFunction<T>#applyAsDouble(U):double

        BiFunction<List<String>,String,List<String>> biFunction =
                (list, str) -> {
                    List<String> resultList = new ArrayList<>();
                    for(String s : list){
                        if(s.startsWith(str)) resultList.add(s);
                    }
                     return resultList;
                };
        //List에서 넣고 싶은 요소들을 한번에 넣고 싶을 때  : Arrays.asList사용
        List<String> names = Arrays.asList("홍길동", "고길동", "홍진경"); //변경 불가능한 Immutable ArrayList
        String familyName = "홍";
        System.out.println(biFunction.apply(names,familyName));
    }
}
