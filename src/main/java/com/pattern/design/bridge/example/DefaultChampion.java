package com.pattern.design.bridge.example;

public class DefaultChampion implements Champion{

    private Skin skin;

    private String name;

    public DefaultChampion(Skin skin, String name) {
        this.skin = skin;
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println(defaultMessage() +  " Move");
    }

    @Override
    public void skillQ() {
        System.out.println(defaultMessage() + " Q Skill");
    }

    @Override
    public void skillW() {
        System.out.println(defaultMessage() + " W Skill");
    }

    @Override
    public void skillE() {
        System.out.println(defaultMessage() + " E Skill");
    }

    @Override
    public void skillR() {
        System.out.println(defaultMessage() + " R Skill");
    }

    private String defaultMessage() {
        return skin.getName() + " " + this.name;
    }
}
