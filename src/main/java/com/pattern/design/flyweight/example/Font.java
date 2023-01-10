package com.pattern.design.flyweight.example;

public final class Font {

    private final String fontFamily;

    private final int size;

    public Font(String fontFamily, int size) {
        this.fontFamily = fontFamily;
        this.size = size;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public int getSize() {
        return size;
    }
}
