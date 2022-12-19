package com.pattern.design.composite.example;

public class Client {

    public static void main(String[] args) {
        Component healPotion = new Item("체력 포션", 50);
        Component bfSword = new Item("BF대검", 3400);

        Bag bag = new Bag();
        bag.add(healPotion);
        bag.add(bfSword);

        Client client = new Client();
        client.printPrice(healPotion);
        client.printPrice(bag);
    }

    private void printPrice(Component component) {
        System.out.println(component.getPrice());
    }
}
