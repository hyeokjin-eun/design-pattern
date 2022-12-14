package com.pattern.design.adapter.example.security;

public interface UserDetailsService {
    UserDetails loadUser(String username);
}
