package com.sh.polymorphism._04.usecase.save;

public class Client {
    private DataSaver dataSaver;

    /**
     * 객체 생성 시 FileSaver 또는 DatabaseSaver 객체를 주입힌다.
     * - 부모 인터페이스 타입인 DataSaver로 위 객체를 제어한다.
     * @param dataSaver
     */
    public Client(DataSaver dataSaver) {
        this.dataSaver = dataSaver;
    }

    public void save(String data) {
        dataSaver.save(data);           // DataSaver#save -> FileSaver#save, DatabaseSaver#save 등적 바인딩
    }
}
