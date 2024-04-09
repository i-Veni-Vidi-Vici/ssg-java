package com.sh.lambda._04.method._reference;

public interface TriFunction<T, U , E, R>
{
    R apply(T t,U u, E e);
}
