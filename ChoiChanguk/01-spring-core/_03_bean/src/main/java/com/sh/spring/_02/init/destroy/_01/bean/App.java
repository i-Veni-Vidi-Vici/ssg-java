package com.sh.spring._02.init.destroy._01.bean;

import com.sh.spring.common.product.Product;
import com.sh.spring.common.product.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * <pre>
 *
 * bean scope란 스프링 빈이 생성될 때 생성되는 인스턴스의 범위를 의미한다. 스프링에서는 다양한 Bean scope를 제공한다.
 * -- 모든환경 --
 * - singleton      하나의 인스턴스만을 생성하고, 모든 빈이 해당 인스턴스를 공유하여 사용한다.
 * - prototype      매번 새로운 인스턴스를 생성한다.
 *
 *-- 웹 환경 --
 * - request        HTTP 요청을 처리할 때마다 새로운 인스턴스를 생성하고, 요청 처리가 끝나면 인스턴스를 폐기한다. 웹 애플리케이션 컨텍스트에만 해당된다.
 * - session        HTTP 세션 당 하나의 인스턴스를 생성하고, 세션이 종료되면 인스턴스를 폐기한다. 웹 애플리케이션 컨텍스트에만 해당된다.
 * - globalSession  전역 세션 당 하나의 인스턴스를 생성하고, 전역 세션이 종료되면 인스턴스를 폐기한다. 포털 애플리케이션 컨텍스트에만 해당된다.
 * </pre>
 */

public class App {
    public static void main(String[] args) {

        /**
         * 사장님이 가게문을 열었습니다, 쇼핑을 시작하세요...
         * [org.springframework.context.annotation.internalConfigurationAnnotationProcessor, org.springframework.context.annotation.internalAutowiredAnnotationProcessor, org.springframework.context.annotation.internalCommonAnnotationProcessor, org.springframework.context.event.internalEventListenerProcessor, org.springframework.context.event.internalEventListenerFactory, contextConfigurationScopePrototype, carpBread, milk, water, shoppingCart, owner]
         * ApplicationContext 초기화 완료...
         * ShoppingCart 객체 생성 완료
         * first 장바구니 : [Bread(bakedAt=2024-06-12), Beverage(super=Product(name=딸기우유, price=1500), capacity=500), Beverage(super=Product(name=지리산암반수, price=3000), capacity=1800)]
         * ShoppingCart 객체 생성 완료
         * second 장바구니 : [Beverage(super=Product(name=지리산암반수, price=3000), capacity=1800)]
         * false
         * 사장님이 가게문을 닫았습니다, 내일 뵙겠습니다...
         */

        ApplicationContext context=new AnnotationConfigApplicationContext(ContextConfiguration.class);
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        System.out.println("ApplicationContext 초기화 완료...");

        Product carpBread = context.getBean("carpBread", Product.class);
        Product milk = context.getBean("milk", Product.class);
        Product water = context.getBean("water", Product.class);

        // scope 속성 = prototype인 경우, 해당빈은 ApplicationContext 초기화시 만들지 않고,
        // getBean 메소드가 호출 될 때 마다 생성된다
        ShoppingCart first = context.getBean("shoppingCart", ShoppingCart.class);
        first.addItem(carpBread);
        first.addItem(milk);
        first.addItem(water);

        System.out.println("first 장바구니 : "+first.getItems());

        ShoppingCart second = context.getBean("shoppingCart", ShoppingCart.class);
        second.addItem(water);

        System.out.println("second 장바구니 : "+ second.getItems());

        System.out.println(first==second); // false

        // bean의 destroyMethod를 명시적으로 호출하기 위해서는, process종료전에 context를 종료하면 된다
        // stream 계열의 빈에서 자원반환을 위해 destroyMethod를 사용한다
        ((AnnotationConfigApplicationContext)context).close();

    }

}
