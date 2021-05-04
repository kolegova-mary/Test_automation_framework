Feature: User registration
  As a guest user
  I should be able to register new user account(sign-up) and use it to login into the application

  @signup @smoke
  Scenario: Guest user is able to register
    Given open Login page
    When user clicks on Registration
    Then user goes to Registration page
    When user types in some random value for 'name' to register
    And user types in some random value for 'email' to register
    And user types in some random value for 'password' to register
    And user types in some random value for 'Daily calorie limit' to register
    And user clicks Save user
    Then Successful registration message is displayed

  @signup @invalid @smoke
  Scenario: Guest user isn't able to register with empty data
    Given open Login page
    When user clicks on Registration
    Then user goes to Registration page
    When user clicks Save user
    Then name is in wrong format
    And email is in wrong format
    And password is in wrong format

  @signup @invalid @smoke
  Scenario Outline: Guest user isn't able to register with invalid data
    Given open Login page
    When user clicks on Registration
    Then user goes to Registration page
    When user types '<name>' as name and '<email>' as email  and '<password>' as password  and '<Daily calorie limit>' as daily calorie limit and hits Save
    Then name is in wrong format
    And email is in wrong format
    And password is in wrong format
    And daily calories is in wrong format
    Examples:
      | name                                                                                                     | email                                                                        | password                               | Daily calorie limit |
      | c                                                                                                        | jbnjkbgUIHJbhjbgUIJHNjbhjgbjkbhgtdYGFVUYbjHBVYUGBNHJBIJUGIYHBkbhuhgq@mail.ru | BWJM                                   | 9                   |
      | L                                                                                                        | fnernfvbghh.ru                                                               | g$56                                   | 10001               |
      | gjknfjcenrcfnerjnfieDSKhfierngviuenrgveocmnvksrnfkeirjgimrekngiojemosgmvkerngokemskfngoiersjgmvklersj    | @gmail.com                                                                   | ndjBHGUYE&HNjknbjksbwjibudjkewnbd,wmkl | -3                  |
      | gjknfjcenrcfnerjnfieDSKhfiBSHJIBbinklnkihnSBNKMJBlNMSLKNWOINJlmnlmjndxosgmvkerngokemskfngoiersjgmvklersj | dhejkndcfjkjn@.com                                                           | njdT^&Gsb87Bius8787yhd(&SW&hniujn      | 111111              |
      | >                                                                                                        | masha                                                                | jLw-                                   | 0                   |