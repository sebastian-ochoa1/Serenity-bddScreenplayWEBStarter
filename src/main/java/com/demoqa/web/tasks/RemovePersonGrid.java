package com.demoqa.web.tasks;


import com.demoqa.web.models.PersonModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.demoqa.web.userinterface.WebTables.BTN_REMOVE;

public class RemovePersonGrid implements Task {
    private final PersonModel personModel;

    public RemovePersonGrid(PersonModel personModel) {
        this.personModel = personModel;
    }

    public static RemovePersonGrid withData(PersonModel personModel) {
        return Tasks.instrumented(RemovePersonGrid.class, personModel);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(BTN_REMOVE.of(personModel.getEmail()))
        );
    }
}
