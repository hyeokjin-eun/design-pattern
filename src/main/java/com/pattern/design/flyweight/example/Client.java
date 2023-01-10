package com.pattern.design.flyweight.example;

public class Client {

    public static void main(String[] args) {
        FontFactory fontFactory = new FontFactory();
        Character c1 = new Character('h', "White", fontFactory.getFont("Nanum:12"));
        Character c2 = new Character('e', "White", fontFactory.getFont("Nanum:12"));
        Character c3 = new Character('l', "White", fontFactory.getFont("Nanum:12"));
        Character c4 = new Character('l', "White", fontFactory.getFont("Nanum:12"));
        Character c5 = new Character('o', "White", fontFactory.getFont("Nanum:12"));
    }
}
