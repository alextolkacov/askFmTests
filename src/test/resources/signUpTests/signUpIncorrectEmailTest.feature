Feature: AskFm tests

  Scenario: Check sign up error message appears trying to sign up with existing user email
    Given Open "ask.fm" URL
    When Accept cookies on popup
    And Press primary button "Sign up"
    And Get Sign Up Page
    And Accept cookies on tab
    And Fill email field: "test@test.com"
    And Set date: Day "12", Month "12", Year "1990"
    And Agree to all conditions
    And Push 'Registration button'
    Then Verify that existing account notification appeared
    And Error message text is: "Похоже, вы уже зарегистрированы"
    And Close browser