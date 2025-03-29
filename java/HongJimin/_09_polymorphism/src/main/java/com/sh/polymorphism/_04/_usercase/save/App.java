package com.sh.polymorphism._04._usercase.save;

public class App {
    public static void main(String[] args) {
        Client client1 = new Client(new FileSaver());
        client1.save("Hello World");

        Client client2 = new Client(new DatabaseSaver());
        client2.save("Byebye world");
    }
}
