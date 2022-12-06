package com.pattern.design.abstractfactory.example;

public class WhiteShipPartProFactory implements ShipPartFactory{
    @Override
    public Anchor createAnchor() {
        return new WhiteAnchorPro();
    }

    @Override
    public Wheel createWheel() {
        return new WhiteWheelPro();
    }
}
