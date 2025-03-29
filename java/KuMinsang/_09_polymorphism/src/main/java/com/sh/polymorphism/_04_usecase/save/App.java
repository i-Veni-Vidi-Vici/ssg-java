package com.sh.polymorphism._04_usecase.save;

public class App {
    public static void main(String[] args) {
        Client client1 = new Client(new FileSaver());
        client1.save("hello world");    // FileSaver.save로 동적 바인딩

        Client client2 = new Client(new DatabaseSaver());
        client2.save("hello world");    //DatabaseSaver.save로 동적 바인딩



    }
}
