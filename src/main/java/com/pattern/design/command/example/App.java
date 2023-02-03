package com.pattern.design.command.example;

public class App {

    public static void main(String[] args) {
        Button button = new Button();
        Light light = new Light();
        button.press(new LightOnCommand(light));
        button.press(new LightOffCommand(light));
        button.undo();
        button.undo();
    }
}
