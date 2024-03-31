package com.sh.polymorphism._04.usecase.save;

public class DatabaseSaver extends DataSaver {
    @Override
    public void save(String data){
        System.out.println(data + "를 DB에 저장합니다...");
    }
}
