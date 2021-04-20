Feature: Log as User
  As a user I should be able to add new Meal

  @smoke @addMeal
  Scenario Outline: User adds Meal
    Given open Login page
    When user clicks Login as User
    Then user goes to Meals page
    When user clicks add meal
    And user types in some random value for '<Date/Time>' to add meal
    And user types in some random value for '<Description>' to add meal
    And user types in some random value for '<Calories>' to add meal
    And user clicks save meal

    Examples:
      | Date/Time        | Description     | Calories |
      | 2021-04-07 13:29 | qwerty          | 1005     |
      | 2021-04-30 12:29 | njcfrjnc        | 4234     |
      | 2021-03-10 13:29 | ecnrojnedmoiked | 2366     |

  @smoke @addMeal @invalid
  Scenario Outline: Cannot add meal using invalid format of date, description or calories
    Given open Login page
    When user clicks Login as User
    Then user goes to Meals page
    When user clicks add meal
    And user types in some random value for '<Date/Time>' to add meal
    And user types in some random value for '<Description>' to add meal
    And user types in some random value for '<Calories>' to add meal
    And user clicks save meal
    Then meal is in wrong format
    Examples:
      | Date/Time        | Description                                        | Calories |
      | 2021-04-07 13:29 | qwertygegd                                         | 9        |
      | 2021-04-30 13:29 | UB                                                 | 5001     |
      | 2020             | mdfksjnjknmdcnkfrenmfimeorkmfokermfjfiornmfoeirnmo | 3245     |

  @smoke @addMeal @invalid
  Scenario: Cannot add empty meal
    Given open Login page
    When user clicks Login as User
    Then user goes to Meals page
    When user clicks add meal
    And user clicks save meal
    Then meal is in wrong format
