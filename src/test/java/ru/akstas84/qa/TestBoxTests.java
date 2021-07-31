package ru.akstas84.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.akstas84.qa.Page.PracticePage;

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
    practicePage.typeRregistrationDataAndSubmit("St", "Syn", "st@qa.ru", "Male", "9011231232", "some street 1");
    practicePage.checkResultsTitle();
    practicePage.checkResultsValue("St", "Syn", "st@qa.ru", "Male", "9011231232", "some street 1");

  }

}
