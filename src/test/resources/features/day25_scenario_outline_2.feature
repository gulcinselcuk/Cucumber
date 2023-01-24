@data_tables
Feature: data_tables
  Scenario Outline: TC_Create_And verify the test data creation

    #creating a reusable step that accept url and goes to that url
    Given user is on the "https://editor.datatables.net/" page
    And user clicks on the new button
    And user enters the first name "<firstname>"
    And user enters the last name "<lastname>"
    And user enters the position "<position>"
    And user enters office "<office>"
    And user enters extension "<extension>"
    And user enters start date "<start_date>"
    And user enters the salary "<salary>"
    And click on create button
    And search for the first name "<firstname>"
    Then verify the name field contains the first name "<firstname>"
    Then close the application

    Examples: test_data
    |firstname|lastname|position|office|extension|start_date|salary|
    |John     |Smith   |tester  |NYC   |2134     |2023-01-01|8000  |
    |sam      |walter  |ba      |LA    |3540     |2022-01-01|10000 |
    |nancy    |brown   |dev     |TX    |8520     |2021-01-01|12000 |

