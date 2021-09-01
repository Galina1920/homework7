Feature: Add specifications of product in terminal

  Scenario: Add specifications of product in terminal
    Given user is at 'https://roofart.md/' page
    And user click on menu button
    When user select 'Țiglă metalică clasica' product
    And user select 'Țiglă metalică Arctica Clasică' from list
    Then 'Țiglă metalică Arctica Clasică' page is displayed
    And user gets all the specification of product
