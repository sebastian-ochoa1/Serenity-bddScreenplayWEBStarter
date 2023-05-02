package com.demoqa.web.enums;

public enum OptionWidgets {
    DATE_PRICKER("Date Picker");

    private final String text;

    OptionWidgets(String text) {
        this.text = text;
    }

    public String text() {
        return text;
    }
}
