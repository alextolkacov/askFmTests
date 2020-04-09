Feature: AskFm tests

  Scenario: Check sign up happy path
    Given Open "ask.fm" URL
    When Accept cookies on popup
    And Press primary button "Sign up"
    And Get Sign Up Page
    And Accept cookies on tab
    And Fill email field: "test@test.com"
    And Set date: Day "10", Month "10", Year "1993"