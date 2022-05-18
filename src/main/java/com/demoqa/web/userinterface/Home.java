package com.demoqa.web.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class Home {
    public static final Target MENU_OPTION_PRINCIPAL = Target.the("Menu option principal").locatedBy("//h5[contains(text(),'{0}')]");
    public static final Target MENU_OPTION_SECONDARY = Target.the("Menu option secondary").locatedBy("//span[contains(text(),'{0}')]");

    private Home() {
    }
}
