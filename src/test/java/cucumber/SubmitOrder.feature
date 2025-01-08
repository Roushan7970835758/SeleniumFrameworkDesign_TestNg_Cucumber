#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Purchase the order from the ecomerse website
    
    Background:
    Given I landed on Ecomerce page

  @Regression
  Scenario Outline:Positive Test for Submiting the order
    Given login using the username <name> and password <password>
    When I add product <productName> from kart
    And  Checkout product <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." Message displayed on ComformationPage

    Examples: 
      | name              | password    | productName         |
      | roushan@gmail.com | Roushan@123 | ADIDAS ORIGINAL |
      
