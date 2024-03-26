package com.sh.polymorphism._04_usecase.save;

public class FileSaver implements DataSaver{
    @Override
    public void save(String data) {
        System.out.println(data+"를 파일에 저장합니다...");

    }
}
