package com.pattern.design.composite.example;

import java.util.ArrayList;
import java.util.List;

public class Bag implements Component{

    private final List<Component> componentList = new ArrayList<>();

    public void add(Component component) {
        componentList.add(component);
    }

    public List<Component> getComponentList() {
        return componentList;
    }

    @Override
    public int getPrice() {
        return componentList.stream().mapToInt(Component::getPrice).sum();
    }
}
