package com.pattern.design.abstractfactory.example;

public class Client {

    public static void main(String[] args) {
        Client client = new Client();
        ShipPartFactory shipPartFactory = new WhiteShipPartFactory();
        client.order(new WhiteShipFactory(shipPartFactory), "WhiteShip", "ship@gmail.com");

        ShipPartFactory shipPartProFactory = new WhiteShipPartProFactory();
        client.order(new WhiteShipFactory(shipPartProFactory), "WhiteShip", "ship@gmail.com");
    }

    private void order(ShipFactory shipFactory, String name, String email) {
        Ship ship = shipFactory.orderShip(name, email);
        System.out.println(ship.getAnchor().getClass());
        System.out.println(ship.getWheel().getClass());
    }

}
