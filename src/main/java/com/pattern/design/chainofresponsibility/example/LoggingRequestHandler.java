package com.pattern.design.chainofresponsibility.example;

public class LoggingRequestHandler extends RequestHandler {

    public LoggingRequestHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handler(Request request) {
        System.out.println("Logging Handler");
        super.handler(request);
    }
}
