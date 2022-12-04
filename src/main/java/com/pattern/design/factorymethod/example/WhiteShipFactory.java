package com.pattern.design.factorymethod.example;

public class WhiteShipFactory extends DefaultShipFactory {

    @Override
    public Ship creatShip() {
        return new WhiteShip();
    }
}
