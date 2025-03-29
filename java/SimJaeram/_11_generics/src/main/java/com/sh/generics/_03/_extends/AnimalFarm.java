package com.sh.generics._03._extends;

/**
 * <pre>
 *     <A implements 인터페이스>로 작성하지 않는다. 유의
 *     - 인터페이스로 상한 제한을 하는 경우 역시 extends를 사용하여
 *     <A extends 인터페이스>로 작성한다.
 * </pre>
 * @param <A>
 */
public class AnimalFarm <A extends Animal>{

}
