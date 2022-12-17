package com.pattern.design.bridge.example;

public class App {

    public static void main(String[] args) {
        Champion kdaAri = new Ari(new KDA());
        kdaAri.move();
        kdaAri.skillQ();
        kdaAri.skillW();
        kdaAri.skillE();
        kdaAri.skillR();

        Champion arcanaAri = new Ari(new Arcana());
        arcanaAri.move();
        arcanaAri.skillQ();
        arcanaAri.skillW();
        arcanaAri.skillE();
        arcanaAri.skillR();
    }
}
