package com.sh.polymorphism._04.usecase.save;

public class App {
    public static void main(String[] args) {
        Client client =  new Client(new FileSaver()); // Hello world를 파일에 저장합니다.
        client.save("Hello world");

        Client client1 = new Client(new DatabaseSaver()); // Byebye world를 DB에 저장합니다.
        client1.save("Byebye world");
    }
}
