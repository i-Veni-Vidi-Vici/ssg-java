package com.sh.polymorphism._04.usecase.save;

public class Client {
    private DataSaver dataSaver;

    public Client(DataSaver dataSaver) {
        this.dataSaver = dataSaver;
    }
    public void save(String data) {
        dataSaver.save(data);
    }
}



