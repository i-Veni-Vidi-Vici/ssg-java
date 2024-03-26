package com.sh.polymorphism._04._usercase.save;

public class DatabaseSaver implements DataSaver{

    @Override
    public void save(String data) {
        System.out.println(data + "를 DB에 저장합니다.");
    }
}
