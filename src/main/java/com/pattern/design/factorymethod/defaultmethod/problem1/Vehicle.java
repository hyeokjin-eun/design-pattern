package com.pattern.design.factorymethod.defaultmethod.problem1;

public class Vehicle implements CarFactory, ShipFactory{
    @Override
    public void order() {
        CarFactory.super.order();
        ShipFactory.super.order();
    }
}
