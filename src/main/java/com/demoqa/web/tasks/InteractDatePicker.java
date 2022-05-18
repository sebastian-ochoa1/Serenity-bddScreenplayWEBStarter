package com.demoqa.web.tasks;

import com.demoqa.web.models.DatePickersModel;
import com.demoqa.web.utils.GetMonthName;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static com.demoqa.web.userinterface.Widgets.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class InteractDatePicker implements Task {
    private final String[] date;
    private final String[] dateTime;
    private final String monthDate;
    private final String monthDateTime;

    public InteractDatePicker(DatePickersModel data) {
        this.date = data.getDate().split("/");
        this.dateTime = data.getDateTime().split("/");
        this.monthDate = GetMonthName.withNumber(date[0]);
        this.monthDateTime = GetMonthName.withNumber(dateTime[0]);
    }

    public static InteractDatePicker withInfo(DatePickersModel data) {
        return instrumented(InteractDatePicker.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(FIELD_DATE).andAlignToTop(),
                Click.on(FIELD_DATE),
                SelectFromOptions.byVisibleText(date[2]).from(SELECT_YEAR_DATE),
                SelectFromOptions.byVisibleText(monthDate).from(SELECT_MONTH_DATE),
                Click.on(LABEL_DAY_DATE.of(monthDate, date[1])),
                Click.on(FIELD_DATE_TIME),
                Click.on(SELECT_YEAR_DATETIME),
                Click.on(OPTION_YEAR_DATETIME.of(dateTime[2])),
                Click.on(SELECT_MONTH_DATETIME),
                Click.on(OPTION_MONTH_DATETIME.of(monthDateTime)),
                Click.on(LABEL_DAY_DATETIME.of(monthDateTime, dateTime[1])),
                Click.on(LABEL_HOUR_DATETIME.of(dateTime[3]))
        );
    }
}
