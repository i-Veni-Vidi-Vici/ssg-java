package com.sh.io._03.filter.stream;

import java.io.Serializable;

/**
 * 직렬화(Serializable) 인터페이스 구현 필수
 * - 필드정보를 직렬화 처리하기 위한 인터페이스
 */
public class Phone implements Serializable {
    private String number;

    public Phone(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                '}';
    }
}
