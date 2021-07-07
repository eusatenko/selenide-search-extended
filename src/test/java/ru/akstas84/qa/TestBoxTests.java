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
  void positiveFillTextBoxTest() {
    open("/text-box");
    $("#userName").setValue("St");
    $("#userEmail").setValue("st@qa.ru");
    $("#currentAddress").setValue("some street 1");
    $("#permanentAddress").setValue("some street 2");

    $("#submit").click();

    // $x(("//*[contains(text(),'Book Store Application')]")).scrollTo(); ToDo

    $("#name").shouldHave(text("Stanislav"));
    $("#email").shouldHave(text("stanislav@qa.ru"));
    $("#currentAddress", 1).shouldHave(text("some street 1"));
    $("#permanentAddress", 1).shouldHave(text("some street 2"));
  }
  @Test
  void positiveFillTestPracticeFormTest() {
    open("/automation-practice-form");
    $("#firstName").setValue("St");
    $("#lastName").setValue("Syn");
    //male
    $(byText("Male")).click();
    $("#userEmail").setValue("st@qa.ru");
    $("#userNumber").setValue("9011231232");
    $("#currentAddress").setValue("some street 1");


    $("#submit").click();
    $("#submit").click();


  }

}
