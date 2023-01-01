Feature: Sign In Feature

  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'jabarkhan@gmail.com' and password 'Jabar@1994'
    And User click on login button
    And User should be logged in into Account

  @signIn
  Scenario: Verify user can sign in into Retail Application
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'jabarkhan@gmail.com' and password 'Jabar@1994'
    And User click on login button
    Then User should be logged in into Account

  @newAccount
  Scenario: Verify user can create an account into Retail Website
    Given User is on retail website
    When User click on Sign in option
    And User click on Create New Account button
    And User fill the signUp information with below data
      | name      | email             | password  | confirmPassword |
      | jabarkhan | khanjan@gmail.com | Tek@12345 | Tek@12345       |
    And User click on SignUp button
    Then User should be logged into account page

  @updateProfile
  Scenario: Verify User can update Profile Information
    When User click on Account option
    And User update Name 'Jabar' and Phone '804-123-4567'
    And User click on Update button
    Then user profile information should be updated

  @updatePassword
  Scenario: Verify User can Update password
    When User click on Account option
    And User enter below information
      | previousPassword | newPassword | confirmPassword |
      | Jabar@1996       | Jabar@1994  | Jabar@1994      |
    And User click on Change Password button
    Then a message should be displayed ‘Password Updated Successfully’

  @editCard
  Scenario: Verify User can edit Debit or Credit card
    When User click on Account option
    And User click on Edit option of card section
    And user edit information with below data
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 1234567891011123 | Jabar      |              12 |           2025 |          123 |
    And user click on Update Your Card button
    Then a message should be displayed ‘Payment Method updated Successfully’

  @removeCard
  Scenario: Verify User can remove Debit or Credit card
    When User click on Account option
    And User click on remove option of card section
    Then payment details should be removed

  @addAddress
  Scenario: Verify User can add an Address
    When User click on Account option
    And User click on Add address option
    And user fill new address form with below information
      | country       | fullName  | phoneNumber | streetAddress    | apt | city     | state    | zipCode |
      | United States | Jabarkhan |  8049876543 | 8706 angelsea dr |   7 | Richmond | Virginia |   23239 |
    And User click Add Your Address button
    Then a message should be displayed ‘Address Added Successfully’

  @updateAddress
  Scenario: Verify User can edit an Address added on account
    When User click on Account option
    And User click on edit address option
    And user fill new address form with below information
      | country       | fullName  | phoneNumber | streetAddress    | apt | city     | state    | zipCode |
      | United States | Jabarkhan |  8049876543 | 8706 angelsea dr |   7 | Richmond | Virginia |   23239 |
    And User click update Your Address button
    Then a message should be displayed 'Address Updated Successfully'
 
  @removeAddress
  Scenario: Verify User can remove Address from Account
    When User click on Account option
    And User click on remove option of Address section
    Then Address details should be removed
    
   
    
