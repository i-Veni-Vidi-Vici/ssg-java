package com.sh.polymorphism._04.usecase.save;

public class Client {
    private DataSaver dataSaver;


    /**
     * 객체생성시 FileSaver 또는 DatabaseSaver 객체를 주입한다.
     * - 부모 인터페이스 타입인 DataSaver로 제어한다.
     * @param dataSaver
     */

    //부모타입으로 받음
    public Client(DataSaver dataSaver) {
        this.dataSaver = dataSaver;
    }
    // 클라이언트한테 데이터 보내라고 데이터 저장해라
    public void save(String data) {
        dataSaver.save(data); // DataSaver#Save -> FileSaver#save,DatabaseSaver#save

    }

}
