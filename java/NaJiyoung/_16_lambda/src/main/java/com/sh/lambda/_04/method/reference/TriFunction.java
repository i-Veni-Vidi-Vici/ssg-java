package com.sh.lambda._04.method.reference;

@FunctionalInterface
public interface TriFunction<T, K, U, V> {
    Person apply(long id, String name, int age);
}
