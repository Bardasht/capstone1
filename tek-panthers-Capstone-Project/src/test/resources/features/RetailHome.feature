Feature: Retail Home Page

  @verifySidebar
  Scenario: Verify Shop by Department sidebar
    Given User is on retail website
    When User click on All section
    Then below options are present in Shop by Department sidebar
      | Electronics | Computers | Smart Home | Sports | Automative |

  @verifyDepartment
  Scenario Outline: Verify department sidebar options
    Given User is on retail website
    When User click on All section
    And User on <department>
    Then below options are present in department
      | <optionOne> | <optionTwo> |

    Examples: 
      | department     | optionOne                      | optionTwo                |
      | ' Electronics' | TV & Video                     | Video Games              |
      | 'Computers'    | Accessories                    | Networking               |
      | 'Smart Home'   | Smart Home Lightning           | Plugs and Outlets        |
      | 'Sports'       | Athletic Clothing              | Exercise & Fitness       |
      | 'Automotive'   | Automative Parts & Accessories | MotorCycle & Powersports |

  @addItem
  Scenario: Verify User can add an item to cart
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'jabarkhan@gmail.com' and password 'Jabar@1994'
    And User click on login button
    Then User should be logged in into Account
    When User change the category to 'Smart Home'
    And User search for an item 'kasa outdoor smart plug'
    And User click on Search icon
    And User click on item
    And User select quantity '2'
    And Userclick add to Cart button
    Then the cart icon quantity should change to '2'
