package com.demoqa.web.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static com.demoqa.web.userinterface.Home.MENU_OPTION_PRINCIPAL;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GoTo implements Task {

    private final String text;

    public GoTo(String text) {
        this.text = text;
    }

    public static GoTo module(String text) {
        return instrumented(GoTo.class, text);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(MENU_OPTION_PRINCIPAL.of(text)).andAlignToTop(),
                Click.on(MENU_OPTION_PRINCIPAL.of(text))
        );
    }
}
