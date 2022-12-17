package com.pattern.design.bridge.example;

public class Arcana implements Skin{

    private static final String NAME = "Arcana";

    @Override
    public String getName() {
        return NAME;
    }
}
