package com.sh.generics._03_extends;

/**
 * <A implements 인터페이스 > 로 작성하지 않는다.
 * 인터페이스로 상한제한을 하는 경우 역시 < A extends 인터페이스> 로 작성한다>
 * @param <A>
 */
public class AnimalFarm <A extends Animal >{ //타입 변수는 아무거나 사용해도 상관없음
}
