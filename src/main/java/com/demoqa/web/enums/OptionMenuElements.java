package com.demoqa.web.enums;

public enum OptionMenuElements {
    WEB_TABLES("Web Tables");

    private final String text;

    OptionMenuElements(String text) {
        this.text = text;
    }

    public String text() {
        return text;
    }
}
