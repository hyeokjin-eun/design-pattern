package com.pattern.design.factorymethod.example;

public class Client {

    public static void main(String[] args) {
        Client client = new Client();
        client.order(new WhiteShipFactory(), "WhiteShip", "ship@gamil.com");
        client.order(new BlackShipFactory(), "BlackShip", "ship@gmail.com");
    }

    private void order(ShipFactory shipFactory, String name, String email) {
        System.out.println(shipFactory.orderShip(name, email));
    }
}