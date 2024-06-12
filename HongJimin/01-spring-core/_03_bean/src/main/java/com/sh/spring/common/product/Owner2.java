package com.sh.spring.common.product;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Owner2 {
    @PostConstruct // 이 어노테이션을 붙혀놓으면 동시에 다 돌아감
    public void openShop() {
        System.out.println("사장님이 가게문을 열었습니다. 쇼핑을 시작하세요🎀 ");
    }

    @PreDestroy
    public void closeShop() {
        System.out.println("사장님이 가게문을 닫았습니다. 내일 뵈어요✨ ");
    }
}
