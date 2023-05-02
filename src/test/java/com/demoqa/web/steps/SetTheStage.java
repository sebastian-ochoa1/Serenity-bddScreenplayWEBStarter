package com.demoqa.web.steps;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class SetTheStage {
    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }
}
