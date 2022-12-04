package com.pattern.design.factorymethod.example;

public interface ShipFactory {

    Ship orderShip(String name, String email);

    Ship creatShip();
}
