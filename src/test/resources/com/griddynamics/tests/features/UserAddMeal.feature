Feature: Log as User
  As a user I should be able to add new Meal

  @smoke @addMeal
  Scenario: User adds Meal
    Given open Login page
    When user clicks Login as User
    Then user goes to Meals page
    When user clicks add meal
    And user types in some random value for 'Date/Time' to add meal
    And user types in some random value for 'Description' to add meal
    And user types in some random value for 'Calories' to add meal
    And user clicks save meal


  @smoke @addMeal @invalid
  Scenario Outline: Cannot add meal using invalid format of date, description or calories
    Given open Login page
    When user clicks Login as User
    Then user goes to Meals page
    When user clicks add meal
    And user types '<Date/Time>' as Date/Time and '<Description>' as description  and '<Calories>' as calories and hits Save
    Then meal is in wrong format
    Examples:
      | Date/Time | Description                                                                                                               | Calories |
      | njdksnbfj | -                                                                                                                         | 9        |
      | 13:29     | U                                                                                                                         | 5001     |
      | 2020      | NJUHU897yhuhbjibsui7yh7UGBIJBIUYhd89yhunbijU&HY(*&Y(UHNjbsjiubhu&YH*(HWBDXJBWIJYUHGX*(sjhNJUbhh98h8y68Yhbiywhg3e3u2bdehi3 | -101     |

  @smoke @addMeal @invalid
  Scenario: Cannot add empty meal
    Given open Login page
    When user clicks Login as User
    Then user goes to Meals page
    When user clicks add meal
    And user clicks save meal
    Then meal is in wrong format
