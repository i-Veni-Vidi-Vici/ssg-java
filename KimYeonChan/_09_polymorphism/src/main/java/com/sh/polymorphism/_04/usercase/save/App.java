package com.sh.polymorphism._04.usercase.save;

public class App {
    public static void main(String[] args) {
        Client client1 = new Client(new FileSaver());
        client1.save("파일");

        Client client2 = new Client((new DatabaseSaver()));
        client2.save(("데이터베이스"));
    }
}
