package com.pattern.design.factorymethod.defaultmethod.problem1;

public interface CarFactory {

    default void order() {
        System.out.println("차를 생산합니다.");
    }
}
