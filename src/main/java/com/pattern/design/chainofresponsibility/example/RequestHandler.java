package com.pattern.design.chainofresponsibility.example;

public abstract class RequestHandler {

    private RequestHandler nextHandler;

    public RequestHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handler(Request request) {
        if (nextHandler != null) {
            nextHandler.handler(request);
        }
    }
}
