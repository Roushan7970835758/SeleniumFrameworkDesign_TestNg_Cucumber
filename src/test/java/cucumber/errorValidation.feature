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
Feature: Error Validation
  I want to use this template for my feature file


  @errorValidation
  Scenario Outline: Title of your scenario outline
     Given I landed on Ecomerce page
    When login using the username <name> and password <password>
    Then "Incorrect email or password." message is Displayed

    Examples: 
      | name              | password    | 
      | roushan@gmail.com | Roushan@123 | 