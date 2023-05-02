package com.demoqa.web.steps;

import com.demoqa.web.enums.OptionMenu;
import com.demoqa.web.enums.OptionMenuElements;
import com.demoqa.web.factories.PersonFactory;
import com.demoqa.web.interactions.OpenBrowser;
import com.demoqa.web.models.PersonModel;
import com.demoqa.web.tasks.Access;
import com.demoqa.web.tasks.AddPersoneGrid;
import com.demoqa.web.tasks.GoTo;
import com.demoqa.web.tasks.RemovePersonGrid;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.ensure.Ensure;

import static com.demoqa.web.userinterface.WebTables.EMAIL_GRID;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class WebTablesSteps {
    private PersonModel personModel;

    @Given("que el {word} ingresa a la pagina demoqa para interactuar con una tabla web")
    public void queElUsuarioIngresaALaPaginaDemoqaParaInteractuarConUnaTablaWeb(String actor) {
        theActorCalled(actor).wasAbleTo(
                OpenBrowser.inThePageSpecified(),
                GoTo.module(OptionMenu.ELEMENTS.text()),
                Access.option(OptionMenuElements.WEB_TABLES.text())
        );
    }

    @When("{word} información solicitada en la tabla")
    public void registraInformacionSolicitadaEnLaTabla(String code) {
        personModel = PersonFactory.with(code);
        theActorInTheSpotlight().attemptsTo(
                AddPersoneGrid.withData(personModel)
        );
    }

    @Then("selecciona el registro a {word}")
    public void SeleccionaElRegistroAEliminar(String code) {
        personModel = PersonFactory.with(code);
        theActorInTheSpotlight().attemptsTo(
                RemovePersonGrid.withData(personModel)
        );
    }

    @Then("el puede agregar el registro en la tabla")
    public void elPuedeAgregarElRegistroEnLaTabla() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(EMAIL_GRID.of(personModel.getEmail())).isDisplayed()
        );
    }

    @Then("el puede eliminar el registro")
    public void elPuedeEliminarElRegistro() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(EMAIL_GRID.of(personModel.getEmail())).isNotDisplayed()
        );
    }
}
