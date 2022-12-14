package com.pattern.design.adapter.example;

import com.pattern.design.adapter.example.security.UserDetails;
import com.pattern.design.adapter.example.security.UserDetailsService;

public class AccountService implements UserDetailsService {

    public Account findByAccountByUsername(String username) {
        return new Account();
    }

    @Override
    public UserDetails loadUser(String username) {
        return this.findByAccountByUsername(username);
    }
}
