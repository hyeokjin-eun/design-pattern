package com.pattern.design.chainofresponsibility.example;

public class Client {

    private final RequestHandler requestHandler;

    public Client(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public static void main(String[] args) {
        RequestHandler chain = new LoggingRequestHandler(new AuthRequestHandler(new PrintRequestHandler(null)));
        Client client = new Client(chain);
        client.doWork();
    }

    public void doWork() {
        Request request = new Request("Body");
        requestHandler.handler(request);
    }
}
