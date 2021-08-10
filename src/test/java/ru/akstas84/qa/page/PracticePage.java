package ru.akstas84.qa.page;

import com.codeborne.selenide.SelenideElement;
import ru.akstas84.qa.data.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticePage {


  private static final String FORM_TITLE = "Practice Form";
  private static final String RESULT_TITLE = "Thanks for submitting the form";

  private SelenideElement modal = $("[role=dialog]");

  public void openPage() {
    open("/automation-practice-form");
    $(".main-header").shouldHave(text(FORM_TITLE));
  }

  public void typeFirstName(String firstName) {
    $("#firstName").setValue(firstName);
  }

  public void typeLastName(String lastName) {
    $("#lastName").setValue(lastName);
  }

  public void selectGeneder(String gender) {
    $(byText(gender)).click();
  }

  public void typeEmail(String email) {
    $("#userEmail").setValue(email);
  }

  public void typePhoneNumber(String userNumber) {
    $("#userNumber").setValue(userNumber);
  }

  public void typeCurrentAddress(String address) {
    $("#currentAddress").setValue(address);
  }

  public void clickBySubmit() {
    $("#submit").scrollTo().click();
  }

  public void typeRregistrationDataAndSubmit(String firstName, String lastName, TestData data) {
    typeFirstName(firstName);
    typeLastName(lastName);
    typeEmail(data.email);
    selectGeneder(data.gender);
    typePhoneNumber(data.phone);
    typeCurrentAddress(data.address);
    clickBySubmit();
  }

  public void checkResultsTitle() {
    modal.$(".modal-title").shouldHave(text(RESULT_TITLE));
  }

  public void checkResultsValue(String firstName, String lastName, TestData data) {
    modal.$(".table-responsive").shouldHave(text(firstName));
    modal.$(".table-responsive").shouldHave(text(lastName));
    modal.$(".table-responsive").shouldHave(text(data.email));
    modal.$(".table-responsive").shouldHave(text(data.gender));
    modal.$(".table-responsive").shouldHave(text(data.phone));
    modal.$(".table-responsive").shouldHave(text(data.address));
  }
}
