

Feature: Login Screen test scenarios
  
  @test
  Scenario:1 User enters incorrect password on the login screen
    Given The user is on the login screen
    When the user enters "standard_user" in username field 
    And the user enters "testabc" in the password field
    And the user clicks the Log in button
    Then the system displays an error
    
  @test
  Scenario:2 User enters correct credential on the login screen
    Given The user is on the login screen
    When the user enters "standard_user" in username field 
    And the user enters "secret_sauce" in the password field
    And the user clicks the Log in button
    Then the product page is displayed 
   
