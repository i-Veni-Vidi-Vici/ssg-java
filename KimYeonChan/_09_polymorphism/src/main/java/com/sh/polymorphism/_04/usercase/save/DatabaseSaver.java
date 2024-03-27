package com.sh.polymorphism._04.usercase.save;

public class DatabaseSaver implements DataSaver{
    @Override
    public void save(String data) {
        System.out.println(data + "를 데이터베이스에 저장합니다.");
    }
}
