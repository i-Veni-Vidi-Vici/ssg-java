package com.sh.polymorphism_04._usecase.car.save;

public class Client {

    private DataSaver dataSaver;

    /**
     * 객체 생성시 FileSaver 또는 DatabaseSaver 객체를 주입한다.
     * - 부모 타입인 DataSaver로 제어한다.
     *
     * 매개변수에 DataSaber dataSaver(부모 객체)를 지정해놓아서 객체를 생성할 때 원하는 데이터 저장방식을 선택할 수 있음
     * 이게 다형성의 법칙
     */
    public Client(DataSaver dataSaver) {
        this.dataSaver = dataSaver;
    }

    public void save(String data){
        dataSaver.save(data); //DataSave#save -> File#sabe or Database#saver 할당되는 객체에 메소드가 실행되기 때문에 동적 바인딩
    }
}
