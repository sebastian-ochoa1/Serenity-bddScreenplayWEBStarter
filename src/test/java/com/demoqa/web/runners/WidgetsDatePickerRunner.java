package com.demoqa.web.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/widgetsdatepicker.feature",
        glue = {"com.demoqa"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class WidgetsDatePickerRunner {
}
