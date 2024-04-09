package com.sh._03.filter.stream;

import java.io.Serializable;

/**
 * 직렬화(Serializable) : 인터페이스 구현 필수
 * - 필드 정보를 직렬화 처리하기 위한 인터페이스
 */
public class Phone implements Serializable {
    private String number;

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                '}';
    }

    public Phone(String number) {
        this.number = number;
    }
}
