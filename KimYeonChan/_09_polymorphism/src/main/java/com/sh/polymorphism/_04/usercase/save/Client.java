package com.sh.polymorphism._04.usercase.save;

public class Client {
    private DataSaver dataSaver;

    /**
     * 객체 생성시 FileSaver 도는 DatabaseSaver 객체를 주입한다.
     * - 부모 인터페이스 타입인 DataSaver 로 제어한다.
     */
    public Client(DataSaver dataSaver) {
        this.dataSaver = dataSaver;
    }

    public void save(String data) {
        dataSaver.save(data);
    }
}
