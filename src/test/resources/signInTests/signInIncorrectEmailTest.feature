Feature: AskFm tests

  Scenario: Check sign up happy path with randomly generated email
    Given Open "ask.fm" URL
    When Accept cookies on popup
    And Press primary button "Sign in"
    And Get Sign In Page
    And Accept cookies on tab
    And Will Log In email field with random email and password
    And Push Log In button
    Then Verify that Flash error message appeared with text: "Неверное имя пользователя или пароль"
    And Close browser