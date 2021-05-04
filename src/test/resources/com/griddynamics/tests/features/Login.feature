Feature: Log into the application
  As a user I should be able to login into the application

  @smoke @login
  Scenario Outline: Regular user is able to login
    Given open Login page
    When user types '<email>' as email and '<password>' as password and hits Submit
    Then user goes to Meals page
    Examples:
      | email         | password |
      | masha@mail.ru | qwerty   |


  @smoke @login @invalid
  Scenario Outline: Cannon login using invalid email and/or password
    Given open Login page
    When user types '<email>' as email and '<password>' as password and hits Submit
    Then login error message is displayed
    Examples:
      | email          | password |
      | qq             | qwe      |
      | qcnkde@mail.ru | 123.№%,     |
