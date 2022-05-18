package com.demoqa.web.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Widgets {

    //DATE
    public static final Target FIELD_DATE = Target.the("field date").located(By.id("datePickerMonthYearInput"));
    public static final Target SELECT_YEAR_DATE = Target.the(" select year date").located(By.className("react-datepicker__year-select"));
    public static final Target SELECT_MONTH_DATE = Target.the("select month date").located(By.className("react-datepicker__month-select"));
    public static final Target LABEL_DAY_DATE = Target.the("label day date").locatedBy("//div[contains(@aria-label,'{0} {1}')]");

    //DATE AND TIME
    public static final Target FIELD_DATE_TIME = Target.the(" field date time").located(By.id("dateAndTimePickerInput"));
    public static final Target SELECT_YEAR_DATETIME = Target.the("select year datetime").located(By.className("react-datepicker__year-read-view--selected-year"));
    public static final Target OPTION_YEAR_DATETIME = Target.the("option year datetime").locatedBy("//div[starts-with(@class,'react-datepicker__year-option') and contains(string(),'{0}')]");
    public static final Target SELECT_MONTH_DATETIME = Target.the("select month datetime").located(By.className("react-datepicker__month-read-view--selected-month"));
    public static final Target OPTION_MONTH_DATETIME = Target.the("option month datetime").locatedBy("//div[starts-with(@class,'react-datepicker__month-option') and contains(string(),'{0}')]");
    public static final Target LABEL_DAY_DATETIME = Target.the("label day datetime").locatedBy("//div[contains(@aria-label,'{0} {1}')]");
    public static final Target LABEL_HOUR_DATETIME = Target.the("label hour datetime").locatedBy("//li[contains(text(),'{0}')]");

    private Widgets() {
    }
}
