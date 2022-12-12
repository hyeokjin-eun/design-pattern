package com.pattern.design.abstractfactory.example;

public interface ShipFactory {

    Ship orderShip(String name, String email);

    Ship createShip();
}
