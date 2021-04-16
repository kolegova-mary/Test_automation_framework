Feature: User registration
  As a guest user
  I should be able to register new user account(sign-up) and use it to login into the application

#  @smoke TODO: Uncomment when the scenario is ready
  @signup
  Scenario: Guest user is able to register
Given user opens Login page
    When user clicks on Registration
    Then user goes to Restration page