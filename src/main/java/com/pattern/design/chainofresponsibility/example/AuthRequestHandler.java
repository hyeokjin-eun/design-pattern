package com.pattern.design.chainofresponsibility.example;

public class AuthRequestHandler extends RequestHandler {

    public AuthRequestHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handler(Request request) {
        System.out.println("Auth Handler");
        super.handler(request);
    }
}
