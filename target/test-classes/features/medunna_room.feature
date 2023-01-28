@MedunnaRoom
Feature: Medunna Room Creation

  Background: Signin Medunna
    Given user is on "https://medunna.com" page
    When click on user icon
    And click on Sign In option
    And enter "john_doe" in username input
    And enter "password" in password input
    And click on Remember Me checkbox
    And click on Sign In submit button

  Scenario Outline: Create Room
    When click on Items&Titles
    And click on Room Option
    And click on Create a new room button
    And enter "<room number>" in Room Number input
    And select Suit option from Room Type dropdown
    And click on status checkbox
    And enter "<price>" in Price input
    And enter "<Description>" in Description input
    And click on Save button

    Then close the application

    Examples:
      | room number | price | description        |
      | 78907655    | 345   | Room 1             |
      | 78907432    | 567   | My Resting Room    |
      | 75690760    | 543   | Good viewed        |
      | 34600980    | 222   | Need extra service |
