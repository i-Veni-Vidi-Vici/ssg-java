package com.sh.polymorphism._04._usercase.save;

import javax.xml.crypto.Data;

public class Client {
    private DataSaver dataSaver;

    /**
     * 객체 생성시 FileSaver 또는 DatabaseSaver 객체를 주입한다.
     * - 부모 인터페이스 타입인 dataSaver로 제언한다!! -> 요게 중요한 부분!!
     * @param dataSaver
     */
    public Client(DataSaver dataSaver) {
        this.dataSaver = dataSaver;
    }

    public void save(String data) {
        dataSaver.save(data); //DataSaver#save가 호출되어야 하지만(정적 바인딩) , FileSaver#save, Database#save가 호출이 됨 -> 동적 바인딩
    }
}
