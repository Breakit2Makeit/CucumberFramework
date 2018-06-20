#Author: breakit2make@gmail.com
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
Feature: Testin Home page applications
  I want to use this template for my homepage feature file

  @tag1
  Scenario: Test valid message submission on homepage
    Given the user is on the home page
    And scroll down to the message box
    When user enter name
    And enter email id
    And enter subject
    And enter message
    And click on send
    Then User getsa a confirmaton message

  @tag2
  Scenario: Title of your scenario outline
    Given the user is on the home page
    And scroll down to the message box
    When user enter name
    And enter no email id
    And enter subject
    And click on send
    Then User getsa a warning message

    #Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
