Feature: Log as Admin
  As Admin I should be able to add a new user

  @smoke @addUser
  Scenario Outline: Admin adds User
    Given open Login page
    When user clicks Login as Admin
    Then admin goes to Meals page
    When admin clicks users
    Then admin goes to Users page
    Then admin goes to Users page
    When admin types in some random value for '<name>' to add user
    And admin types in some random value for '<email>' to add user
    And admin types in some random value for '<password>' to add user
    And admin clicks save user

    Examples:
      | name         | email            | password   |
      | vrenjwght    | trje@mail.ru     | hskwo      |
      | gvesvgsekl   | fnernfv@gmai.com | Hmwp29*9   |
      | fvesrkgmomfv | dfnowejn@mail.ru | NSJHw32(#n |

  @smoke @addUser @invalid
  Scenario Outline: Cannot add user using invalid format of name, email or calories
    Given open Login page
    When user clicks Login as Admin
    Then admin goes to Meals page
    When admin clicks users
    Then admin goes to Users page
    Then admin goes to Users page
    When admin types in some random value for '<name>' to add user
    And admin types in some random value for '<email>' to add user
    And admin types in some random value for '<password>' to add user
    And admin clicks save user
    Then user is in wrong format

    Examples:
      | name                                                                                                       | email               | password                          |
      | c                                                                                                          | trjbfse@mail.ru     | njirnisnf                         |
      | Gf                                                                                                         | fnernfvbghh         | dnijsnrom                         |
      | gjknfjcenrcfnerjnfieDSKhfierngviuenrgveocmnvksrnfkeirjgimrekngiojemosgmvkerngokemskfngoiersjgmvklersjngiok | dfddvnowejn@mail.ru | ghhf                              |
      | SNU87bfd                                                                                                   | hekcl@mail.ru       | njdT^&Gsb87Bius8787yhd(&SW&hniujn |

