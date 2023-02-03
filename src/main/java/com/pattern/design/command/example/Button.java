package com.pattern.design.command.example;

import java.util.Stack;

public class Button {

    private final Stack<Command> commands = new Stack<>();

    public void press(Command command) {
        command.execute();
        commands.push(command);
    }

    public void undo() {
        if ( ! commands.isEmpty()) {
            commands.pop().undo();
        }
    }
}
