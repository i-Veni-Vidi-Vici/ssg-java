package com.sh.polymorphism._04.usecase.save;

public class DatabaseSaver implements DataSaver{
    @Override
    public void save(String data) {
        System.out.println(data + "를 db에 저장합니다.");
    }
}

