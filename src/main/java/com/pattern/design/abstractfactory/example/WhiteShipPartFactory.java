package com.pattern.design.abstractfactory.example;

public class WhiteShipPartFactory implements ShipPartFactory{

    @Override
    public Anchor createAnchor() {
        return new WhiteAnchor();
    }

    @Override
    public Wheel createWheel() {
        return new WhiteWheel();
    }
}
