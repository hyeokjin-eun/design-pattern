package com.pattern.design.abstractfactory.example;

public abstract class DefaultShipFactory implements ShipFactory{

    public Ship orderShip(String name, String email) {
        validate(name, email);
        prepare(name);
        Ship ship = createShip();
        sendToEmail(name);
        return ship;
    }

    private void validate(String name, String email) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("배 이름을 입력해 주세요");
        }

        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("E-Mail 을 입력해 주세요");
        }
    }

    private void prepare(String name) {
        System.out.println(name + " 배를 만들 준비중입니다.");
    }

    private void sendToEmail(String name) {
        System.out.println(name + " 배가 완성되었습니다.");
    }
}
