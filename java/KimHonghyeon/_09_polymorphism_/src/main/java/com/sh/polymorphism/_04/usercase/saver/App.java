package com.sh.polymorphism._04.usercase.saver;

public class App {
    public static void main(String[] args) {
        Client client1 = new Client(new FileSaver());
        Client client2 = new Client(new DataBaseSaver());

        client1.save("Hello");
        client2.save("World");

    }
}
