package com.sh.polymorphism._04.usecase.save;

public class Client {
    private DataSaver dataSaver;

    /**
     * 객체 생성시 FileSaver 또는 DatabaseSaver 객체를 주입
     * - 부모 인터페이스 타입인 DataSaver로 제어
     */
    public Client(DataSaver dataSaver){ // 매개변수로 FileSaver 또는 DatabaseSaver 올 수 있음
        this.dataSaver = dataSaver;
    }

    public void save(String data){
        dataSaver.save(data); // DataSaver#save가 호출되어야 하는데 -> 실제로는 동적바인딩으로 인해 FileSaver#save, DatabaseSaver#save가 호출
    }
}
