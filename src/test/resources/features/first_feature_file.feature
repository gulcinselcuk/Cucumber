
@google_search
Feature: first feature file

  Background: user_goes_to_google_page
    Given user on the google home page

  @iphone_search
  Scenario: TC_01_first_scenario
    When user search for iPhone
    Then verify page title contains iPhone
    Then close the application

    @teapot_search

  Scenario: TC_02_teapot_search
    When user search for TeaPot
    Then verify page title contains TeaPot
    Then close the application


#All feature files must begin with "Feature: " keyword
#Feature: To declare the file as a cucumber feature file. Mandatury. There can be only one feature:keyword
#Scenario: To create test. in a feature file there may be more than one Scenario.
#  Runner : To run the feature files.
# Background: Used to run Before each Scenario. This is used for repeated pre-condition
  #CUCUMBER STEPS:
#  1.create feature file and test scenarios
  #2.run the feature file and generate step definitions.
  #3.use the step definitions to complete the java code
  #4.dryRun=False
