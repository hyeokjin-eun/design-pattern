package com.pattern.design.chainofresponsibility.example;

public class Request {

    private String body;

    public Request(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }
}
