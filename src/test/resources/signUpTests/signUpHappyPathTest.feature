Feature: AskFm tests

  Scenario: Check sign up happy path with randomly generated email
    Given Open "ask.fm" URL
    When Accept cookies on popup
    And Press primary button "Sign up"
    And Get Sign Up Page
    And Accept cookies on tab
    And Fill email field with random email
    And Set date: Day "10", Month "10", Year "1993"
    And Agree to all conditions
    And Push 'Registration button'
    Then Get Feed Page
    And Verify Feed Page appeared
    And Close browser

