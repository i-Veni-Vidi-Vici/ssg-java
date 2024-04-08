package com.sh.lambda._03.functional._interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToIntFunction;

/**
 * <pre>
 * Function 함수형 인터페이스 관련
 * - 매개인자가 있고, 리턴값도 있다.
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        // Function<T, R>#apply(T):R
        Function<String, Integer> function = (str) -> Integer.parseInt(str);
        System.out.println(function.apply("123") + 321);

        // IntFunction<R>#apply(int):R
        // LongFunction<R>#apply(long):R
        // DoubleFunction<R>#apply(double):R

        // BiFunction<T1, T2, R>#apply(T1, T2):R
        BiFunction<List<String>, String, List<String>> biFunction = (names, familyName) -> {
            List<String> checkedStr = new ArrayList<>();
            for (String name : names) {
                if (name.charAt(0) == familyName.charAt(0)) {
                    checkedStr.add(name);
                }
            }
            return checkedStr;
        };

        List<String> names = Arrays.asList("홍길동", "고길동", "홍진경");
        String familyName = "홍";
        System.out.println(biFunction.apply(names, familyName));

        // IntToDoubleFunction#applyAsDouble(int):double
        // IntToLongFunction#applyAsLong(int):long
        // LongToDoubleFunction#applyAsDouble(long):double
        // LongToIntFunction#applyAsInt(long):int
        // DoubleToIntFunction#applyAsInt(double):int
        // DoubleToLongFunction#applyAsLong(double):long

        // ToIntFunction<T>#applyAsInt(T):int
        ToIntFunction<String> toIntFunction = (str) -> str.length();
        System.out.println(toIntFunction.applyAsInt("helloworld"));

        // ToIntBiFunction<T, U>#applyAsInt(T, U):int
        // ToLongFunction<T>#applyAsLong(T):long
        // ToLongBiFunction<T, U>#applyAsLong(T, U):long
        // ToDoubleFunction<T>#applyAsDouble(T):double
        // ToDoubleBiFunction<T, U>#applyAsDouble(T, U):double


    }
}
