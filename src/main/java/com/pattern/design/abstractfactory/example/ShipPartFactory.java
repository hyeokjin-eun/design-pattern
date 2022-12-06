package com.pattern.design.abstractfactory.example;

public interface ShipPartFactory {

    Anchor createAnchor();

    Wheel createWheel();
}
