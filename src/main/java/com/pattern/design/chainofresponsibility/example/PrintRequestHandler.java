package com.pattern.design.chainofresponsibility.example;

public class PrintRequestHandler extends RequestHandler {

    public PrintRequestHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handler(Request request) {
        System.out.println("Print Handler");
        super.handler(request);
    }
}
