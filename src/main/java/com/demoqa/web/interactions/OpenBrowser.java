package com.demoqa.web.interactions;


import com.demoqa.web.utils.Url;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class OpenBrowser implements Interaction {
    private final Url page = new Url();

    public static OpenBrowser inThePageSpecified() {
        return instrumented(OpenBrowser.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(page));
        getDriver().manage().window().maximize();
    }
}
