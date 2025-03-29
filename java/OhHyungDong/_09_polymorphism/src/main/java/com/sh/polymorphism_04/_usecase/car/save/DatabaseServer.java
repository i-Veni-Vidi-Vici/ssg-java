package com.sh.polymorphism_04._usecase.car.save;

public class DatabaseServer implements DataSaver{
    @Override
    public void save(String str) {
        System.out.println(str + "데이터베이스에 파일을 저장합니다.");
    }
}
