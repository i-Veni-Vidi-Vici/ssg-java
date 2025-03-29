package com.sh._04.usecase.save;

public class App {
    public static void main(String[] args) {
        Client client1 = new Client(new FileSaver());
        client1.save("Hello world");

    }
}
