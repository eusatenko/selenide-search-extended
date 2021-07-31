package ru.akstas84.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.akstas84.qa.Page.PracticePage;
import static Data.TestData.*;

public class TestBoxTests {

  PracticePage practicePage = new PracticePage();

  @BeforeAll
  static void setup() {
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.startMaximized = true;
  }

  @Test
  void positiveFillTestPracticeFormTest() {
    practicePage.openPage();
    practicePage.typeRregistrationDataAndSubmit(firstName,lastName, email, gender, phone, address );
    practicePage.checkResultsTitle();
    practicePage.checkResultsValue(firstName,lastName, email, gender, phone, address);
  }

}
