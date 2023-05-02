package com.demoqa.web.enums;

public enum OptionMenu {
    ELEMENTS("Elements"),
    WIDGETS("Widgets");

    private final String text;

    OptionMenu(String message) {
        this.text = message;
    }

    public String text() {
        return text;
    }
}
