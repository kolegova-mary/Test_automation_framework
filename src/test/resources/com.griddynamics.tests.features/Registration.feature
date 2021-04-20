Feature: User registration
  As a guest user
  I should be able to register new user account(sign-up) and use it to login into the application

  @signup
  Scenario Outline: Guest user is able to register
    Given open Login page
    When user clicks on Registration
    Then user goes to Registration page
    When user types in some random value for '<name>' to register
    And user types in some random value for '<email>' to register
    And user types in some random value for '<password>' to register
    And user types in some random value for '<Daily calorie limit>' to register
    And user clicks Save user
    Then Successful registration message is displayed
    Examples:
      | name                                                                                                 | email                 | password                         | Daily calorie limit |
      | qq                                                                                                   | kolegovamasha@mail.ru | hso72                            | 10                  |
      | NBJDXcdmenminmiomde                                                                                  | hehsmk@gmail.com      | bhbg&YGHUybsyeh872873yhdnbduxhbh | 10000               |
      | zadninijnm                                                                                           | sdnjh@mail.ru         | YU&*BNUJB87hs72                  | 5000                |
      | ndjibnhbUHBNJnjnubnghubhBJBNjbjhbnuijnjunBHJBJBJnskqnjnjnxkwwkdmdnwwjnwwjjckmwjwnejdjwjwmwkwmdmmwkmd | snijnBHj@mail.ru      | niuBG*&GBjind                    | 2345                |

  @signup @invalid
  Scenario: Guest user isn't able to register with wrong data
    Given open Login page
    When user clicks on Registration
    Then user goes to Registration page
    When user clicks Save user
    Then name is in wrong format
    And email is in wrong format
    And password is in wrong format
    And daily calories is in wrong format
