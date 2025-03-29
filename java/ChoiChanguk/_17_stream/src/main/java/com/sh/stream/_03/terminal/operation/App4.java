package com.sh.stream._03.terminal.operation;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * <pre>
 * match 단말연산
 * - anyMatch(Predicate<T>):boolean // 하나라도 Predicate람다식의 결과가 true라면, 최종 true반환
 * - allMatch(Predicate<T>):boolean // 모든 요소의 pedicate람다식의 결과가 true라면, 최종 true반환
 * - noneMatch(Predicate<T>):boolean //모든 요소의 pedicate람다식의 결과가 false라면, 최종 true반환
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        // 스트림은 재사용이 안되서 담아놓는다

        List<String> stringList=List.of("Java","Spring","Springboot");
        System.out.println(stringList);
        boolean result= stringList.stream().anyMatch((str)->str.contains("p"));
        System.out.println("p를 포합하는가 : "+result);

        result=stringList.stream().anyMatch((str)->str.contains("z"));
        System.out.println("z를 포합하는가 : "+result);

        result=stringList.stream().anyMatch((str)->str.length()>=4);
        System.out.println("문자길이 4이상인가 : "+result);

        result=stringList.stream().anyMatch((str)->str.length()>4);
        System.out.println("문자 길이가 4초과인가"+result);

        result=stringList.stream().noneMatch((str)->str.contains("z"));
        System.out.println("z를 갖지 않는가 : "+result);

        result=stringList.stream().noneMatch((str)->str.contains("a"));
        System.out.println("a를 갖지 않는가 : "+result);

        //Stream<Person>을 제공하는 제공자 람다
        Supplier<Stream<Person>> supplier = () ->
                Arrays.asList(
                        new Person("홍길동", 33),
                        new Person("신사임당", 40),
                        new Person("이순신", 27),
                        new Person("장영실", 55),
                        new Person("홍길동", 33)
                ).stream();
        supplier.get().forEach(System.out::println);

        //50세 이상 이웃이 있는지 검사
        boolean streamSupplier1=
                Arrays.asList(
                        new Person("홍길동", 33),
                        new Person("신사임당", 40),
                        new Person("이순신", 27),
                        new Person("장영실", 55),
                        new Person("홍길동", 33)
                ).stream().anyMatch(Person->Person.getAge()>=50);
        System.out.println("50세 이상 이웃이 있는지 검사 : "+streamSupplier1);

        //이름글자 수가 3글자 보다 많은 이웃이 있는지 검사
        boolean streamSupplier2=
                Arrays.asList(
                        new Person("홍길동", 33),
                        new Person("신사임당", 40),
                        new Person("이순신", 27),
                        new Person("장영실", 55),
                        new Person("홍길동", 33)
                ).stream().anyMatch((Person)->Person.getName().length()>=3);
        System.out.println("이름이 3글자 인지 검사 : "+streamSupplier2);

        //모든 이웃이 성인
        boolean streamSupplier3=
                Arrays.asList(
                        new Person("홍길동", 33),
                        new Person("신사임당", 40),
                        new Person("이순신", 27),
                        new Person("장영실", 55),
                        new Person("홍길동", 33)
                ).stream().allMatch(Person->Person.getAge()>=20);
        System.out.println("성인인 이웃이 있는가 : "+streamSupplier1);
    }

}
