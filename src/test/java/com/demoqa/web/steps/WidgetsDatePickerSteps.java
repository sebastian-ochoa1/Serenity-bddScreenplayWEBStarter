package com.demoqa.web.steps;

import com.demoqa.web.enums.OptionMenu;
import com.demoqa.web.enums.OptionWidgets;
import com.demoqa.web.factories.DataFactory;
import com.demoqa.web.interactions.OpenBrowser;
import com.demoqa.web.models.DatePickersModel;
import com.demoqa.web.tasks.Access;
import com.demoqa.web.tasks.GoTo;
import com.demoqa.web.tasks.InteractDatePicker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.targets.TheTarget;

import static com.demoqa.web.userinterface.Widgets.FIELD_DATE;
import static com.demoqa.web.userinterface.Widgets.FIELD_DATE_TIME;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class WidgetsDatePickerSteps {
    private DatePickersModel datePickersModel;

    @Given("que el {word} ingresa a la pagina demoqa para interactuar con elementos date")
    public void userEntersPage(String actor) {
        theActorCalled(actor).wasAbleTo(
                OpenBrowser.inThePageSpecified(),
                GoTo.module(OptionMenu.WIDGETS.text()),
                Access.option(OptionWidgets.DATE_PRICKER.text())
        );
    }

    @When("el realiza la interacción con los {word}")
    public void makeInteractionWithDate(String code) {
        datePickersModel = DataFactory.with(code);
        theActorInTheSpotlight().wasAbleTo(
                InteractDatePicker.withInfo(datePickersModel)
        );
    }

    @Then("el puede utilizar los componentes correctamente")
    public void youCanUseComponentsCorrectly() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(TheTarget.valueOf(FIELD_DATE).answeredBy(theActorInTheSpotlight())).isEqualTo(datePickersModel.getDateView()),
                Ensure.that(TheTarget.valueOf(FIELD_DATE_TIME).answeredBy(theActorInTheSpotlight())).isEqualTo(datePickersModel.getDateTimeView())
        );
    }
}
