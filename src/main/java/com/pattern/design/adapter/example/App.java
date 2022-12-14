package com.pattern.design.adapter.example;

import com.pattern.design.adapter.example.security.LoginHandler;

public class App {

    public static void main(String[] args) {
        LoginHandler loginHandler = new LoginHandler(new AccountService());
        loginHandler.login("jini", "password");
    }
}
