package com.sh.spring.common.product;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Owner2 {
    @PostConstruct
    public void openShop(){
        System.out.println("사장님이 가게문 열었음, 쇼핑 시작하세요.");
    }
    @PreDestroy
    public void closeShop(){
        System.out.println("사장님이 가게문 닫았음, 내일 뵙겠습니다.");
    }
}