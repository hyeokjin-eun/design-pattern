package com.pattern.design.prototype.example;

import java.util.Objects;

public class GithubRepository {

    private String user;

    private String name;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GithubRepository that = (GithubRepository) o;
        return Objects.equals(user, that.user) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, name);
    }
}
