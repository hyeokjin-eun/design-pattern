package com.pattern.design.factorymethod.example;

public class BlackShipFactory extends DefaultShipFactory{

    @Override
    public Ship creatShip() {
        return new BlackShip();
    }
}
