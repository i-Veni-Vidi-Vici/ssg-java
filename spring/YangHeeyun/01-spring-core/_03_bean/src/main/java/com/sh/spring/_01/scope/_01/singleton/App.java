package com.sh.spring._01.scope._01.singleton;

import com.sh.spring.common.product.Bread;
import com.sh.spring.common.product.Product;
import com.sh.spring.common.product.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * <pre>
 *bean scope란 스프링 빈이 생성될 때 생성되는 인스턴스의 범위를 의미한다. 스프링에서는 다양한 Bean scope를 제공한다.
 *
 * (모든 환경)
 * - singleton      하나의 인스턴스만을 생성하고, 모든 빈이 해당 인스턴스를 공유하여 사용한다.
 * - prototype      매번 새로운 인스턴스를 생성한다. (getBean요청이 올때마다 새롭게 만듬)
 * (웹 환경)
 * - request        HTTP 요청을 처리할 때마다 새로운 인스턴스를 생성하고, 요청 처리가 끝나면 인스턴스를 폐기한다. 웹 애플리케이션 컨텍스트에만 해당된다.
 * - session        HTTP 세션 당 하나의 인스턴스를 생성하고, 세션이 종료되면 인스턴스를 폐기한다. 웹 애플리케이션 컨텍스트에만 해당된다.
 * - globalSession  전역 세션 당 하나의 인스턴스를 생성하고, 전역 세션이 종료되면 인스턴스를 폐기한다. 포털 애플리케이션 컨텍스트에만 해당된다.
 * </pre>
 */

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        System.out.println("ApplicationContext 초기화 완료...");

//        Product cardBread = context.getBean("carpBread", Bread.class); // 얘도 가능
        Product cardBread = context.getBean("carpBread", Product.class);
        Product milk = context.getBean("milk", Product.class);
        Product water = context.getBean("water", Product.class);

        ShoppingCart first = context.getBean("shoppingCart", ShoppingCart.class);
        first.addItem(cardBread);
        first.addItem(milk);
        System.out.println("first장바구니 : " + first.getItems()); // 붕어빵, 딸기우유

        ShoppingCart second = context.getBean("shoppingCart", ShoppingCart.class);
        second.addItem(water);
        System.out.println("second장바구니 : " + second.getItems()); // 붕어빵, 딸기우유, 물

        // first, second는 같은 객체이므로 장바구니에 들어있는 물건을 공유한다.
        // getBean을 2번했지만 그 bean이 singleton이기 때문이다.
        System.out.println(first == second); // true
    }
}
