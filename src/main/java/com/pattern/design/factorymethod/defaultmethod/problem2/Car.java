package com.pattern.design.factorymethod.defaultmethod.problem2;

public class Car implements CarFactory{

    @Override
    public void order() {
        CarFactory.super.order();
    }
}
