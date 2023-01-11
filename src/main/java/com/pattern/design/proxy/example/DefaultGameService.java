package com.pattern.design.proxy.example;

public class DefaultGameService implements GameService {

    @Override
    public void startGame() {
        System.out.println("Game Start");

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
