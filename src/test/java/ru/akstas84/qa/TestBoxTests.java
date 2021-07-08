package ru.akstas84.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestBoxTests {

  @BeforeAll
  static void setup() {
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.startMaximized = true;
  }

  @Test
  void positiveFillTestPracticeFormTest() throws InterruptedException {
    open("/automation-practice-form");
    $("#firstName").setValue("St");
    $("#lastName").setValue("Syn");
    $(byText("Male")).click();
    $("#userEmail").setValue("st@qa.ru");
    $("#userNumber").setValue("9011231232");
    $("#currentAddress").setValue("some street 1");
    $("#submit").scrollTo().click();
    $("tr:nth-of-type(1) > td:nth-of-type(2)").shouldHave(text("St "+"Syn"));
    $("tr:nth-of-type(2) > td:nth-of-type(2)").shouldHave(text("st@qa.ru"));
    $("tr:nth-of-type(3) > td:nth-of-type(2)").shouldHave(text("Male"));
    $("tr:nth-of-type(4) > td:nth-of-type(2)").shouldHave(text("9011231232"));
    $("tr:nth-of-type(9) > td:nth-of-type(2)").shouldHave(text("some street 1"));
  }

}
