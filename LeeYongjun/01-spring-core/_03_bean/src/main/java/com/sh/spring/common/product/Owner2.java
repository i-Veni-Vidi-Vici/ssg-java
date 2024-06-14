package com.sh.spring.common.product;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Owner2 {
    @PostConstruct
    public void openShop(){
        System.out.println("사장님이 가게문을 열었습니다. 쇼핑을 시작하세요");
    }

    @PreDestroy
    public void closeShop(){
        System.out.println("사장님이 가게문을 닫았습니다. 내일 뵙겠습니다");
    }
}
