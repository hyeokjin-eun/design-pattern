package com.pattern.design.factorymethod.defaultmethod.problem1;

public interface ShipFactory {
    default void order() {
        System.out.println("배를 생산합니다.");
    }
}
