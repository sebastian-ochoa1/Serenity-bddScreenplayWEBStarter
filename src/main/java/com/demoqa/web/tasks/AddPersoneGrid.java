package com.demoqa.web.tasks;

import com.demoqa.web.models.PersonModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.demoqa.web.userinterface.WebTables.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class AddPersoneGrid implements Task {
    private final PersonModel personModel;

    public AddPersoneGrid(PersonModel personModel) {
        this.personModel = personModel;
    }

    public static AddPersoneGrid withData(PersonModel personModel) {
        return instrumented(AddPersoneGrid.class, personModel);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_ADD),
                Enter.theValue(personModel.getFirstName()).into(POP_UP_INPUT_FIRST_NAME),
                Enter.theValue(personModel.getLastName()).into(POP_UP_INPUT_LAST_NAME),
                Enter.theValue(personModel.getEmail()).into(POP_UP_INPUT_EMAIL),
                Enter.theValue(personModel.getAge()).into(POP_UP_INPUT_AGE),
                Enter.theValue(personModel.getSalary()).into(POP_UP_INPUT_SALARY),
                Enter.theValue(personModel.getDepartment()).into(POP_UP_INPUT_DEPARTMENT),
                Click.on(POP_UP_BTN_SUBMIT)
        );
    }
}
