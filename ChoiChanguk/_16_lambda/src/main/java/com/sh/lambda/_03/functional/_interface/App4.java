package com.sh.lambda._03.functional._interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class App4 {
    public static void main(String[] args) {
        Function<String , Integer> function=(str)->Integer.parseInt(str);
        System.out.println(function.apply("123")+321);

        // IntFunction#apply(int):R
        // LongFunction#apply(long):R
        // DoubleFunction#apply(double):R

        //BiFunction<T1, T2>#apply(T1,T2):R

        // IntToDoubleFunction#applyAsDouble(int):double
        // IntToLongFunction#applyAsDouble(int):long
        // LongToDoubleFunction#applyAsDouble(long):double
        // LongToIntFunction#applyAsDouble(long):int
        // DoubleToIntFunction#applyAsDouble(double):int
        // DoubleToLongFunction#applyAsDouble(double):long

        // ToIntFunction<T>#applyAsInt(T):int
        // ToLongFunction<T>#applyAsInt(T):long
        // ToDoubleFunction<T>#applyAsInt(T):double
        // ToLongBiFunction<T>#applyAsInt(T):double
        // ToDoubleFunction<T>#applyAsInt(T):double
        // ToDoubleBiFunction<T>#applyAsInt(T):double

        BiFunction<List<String >,String ,List<String >>biFunction=(list,str)->
        {
            List<String> resultList = new ArrayList<>();
            for (String  name:list) {
                if(name.startsWith(str))
                    resultList.add(name);
            }
            return resultList;
        };



        List<String> strings= Arrays.asList("홍길동","고길동","홍진경");//변경불가능
        String familyName = "홍";
        System.out.println(biFunction.apply(strings,familyName));
    }
}
