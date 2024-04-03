package com.sh.polymorphism_04._usecase.car.save;

public class FileSaver implements DataSaver {
    @Override
    public void save(String str) {
        System.out.println(str + "데이터를 파일에저장합니다.");
    }
}
