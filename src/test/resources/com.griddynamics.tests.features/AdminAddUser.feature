Feature: Log as Admin
  As Admin I should be able to add a new user

  @smoke @addUser
  Scenario: Admin adds User
    Given open Login page
    When user clicks Login as Admin
    Then admin goes to Meals page
    When admin clicks users
    Then admin goes to Users page
    When admin clicks add user
    And admin types in some random value for 'name' to add user
    And admin types in some random value for 'email' to add user
    And admin types in some random value for 'password' to add user
    And admin clicks save user

  @smoke @addUser @invalid
  Scenario Outline: Cannot add user using invalid format of name, email or calories
    Given open Login page
    When user clicks Login as Admin
    Then admin goes to Meals page
    When admin clicks users
    Then admin goes to Users page
    When admin clicks add user
    And admin types '<name>' as name and '<email>+' as email  and '<password>' as password and hits Save
    And admin clicks save user
    Then user is in wrong format

    Examples:
      | name                                                                                                       | email                                                                       | password                                   |
      | ]                                                                                                          | masha@mail.ru                                                               | 687H                                       |
      | \                                                                                                          | nfjksibunfijuheoiknqajkdnbfoiruhjefjnsnrnkjnaejknlalejknjnaklwneijmklfcmeki | *@&#                                       |
      | gjknfjcenrcfnerjnfieDSKhfierngviuenrgveocmnvksrnfkeirjgimrekngiojemosgmvkerngokemskfngoiersjgmvklersjngiok | dfddvnowejn@                                                                | njdT^&Gsjasb87gsghndBius8787yhd(&SW&hniujn |
      | ndjBHGUYE&HNjknbjksdnaljkniouhjy89yhUBjbjdhsbnjbjbjcaknjhbihubjinjiuhuijbhjkljwkmnkdlnjnknwjinjj,wmkl      | hekcl@.ru                                                                   | njdT^&Gsb87Bius8787yhd(&SW&hniujn          |

  @smoke @addUser @invalid
  Scenario: Cannot add user with empty data
    Given open Login page
    When user clicks Login as Admin
    Then admin goes to Meals page
    When admin clicks users
    Then admin goes to Users page
    When admin clicks add user
    And admin clicks save user
    Then user is in wrong format
