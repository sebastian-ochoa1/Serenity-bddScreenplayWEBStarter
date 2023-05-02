package com.demoqa.web.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static com.demoqa.web.userinterface.Home.MENU_OPTION_SECONDARY;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Access implements Task {

    private final String text;

    public Access(String text) {
        this.text = text;
    }

    public static Access option(String text) {
        return instrumented(Access.class, text);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(MENU_OPTION_SECONDARY.of(text)).andAlignToTop(),
                Click.on(MENU_OPTION_SECONDARY.of(text))
        );
    }
}
