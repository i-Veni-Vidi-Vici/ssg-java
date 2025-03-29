package com.sh.polymorphism_04._usecase.car.save;

public class App {
    public static void main(String[] args) {
        Client client1 = new Client(new FileSaver());
        Client client2 = new Client(new DatabaseServer());
        client1.save("Hello World");
        client2.save("Hello World");
    }
}
