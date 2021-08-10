package ru.akstas84.qa;

import org.junit.jupiter.api.*;

public class FirstTest {

//  commit test
  @BeforeAll
  static void beforeAll() {
    System.out.println("this is before all");
  }

  @BeforeEach
  void setUp() {
    System.out.println("this is before each");
  }

  @AfterEach
  void tearDown() {
    System.out.println("this is after each");
  }

  @Test
  void  firstTest() {
    System.out.println("Hello World");
    Assertions.assertTrue(true);
  }


}
