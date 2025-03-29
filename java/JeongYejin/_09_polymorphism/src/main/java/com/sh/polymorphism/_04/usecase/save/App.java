package com.sh.polymorphism._04.usecase.save;

public class App {
    public static void main(String[] args) {
        Client client = new Client(new FileSaver());
        client.save("Hello world");

        Client client1 = new Client(new DatabaseSaver());
        client1.save("Byebye world");
    }
}
