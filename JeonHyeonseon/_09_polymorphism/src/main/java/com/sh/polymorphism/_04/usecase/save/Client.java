package com.sh.polymorphism._04.usecase.save;

public class Client {
    private DataSaver dataSaver;

    /**
     * 객체 생성시 FileSaver 또는 DatabaseSaver 객체를 주입한다.
     *  - 부모 인터페이스 타입인 DataSaver로 제어한다.
     * @param dataSaver
     */
    public Client(DataSaver dataSaver) {
        this.dataSaver = dataSaver;
    }

    public void save(String data) {
        dataSaver.save(data);  // DataSaver#save -> FileSaver#save, DatabaseSaver#save
    }
}
