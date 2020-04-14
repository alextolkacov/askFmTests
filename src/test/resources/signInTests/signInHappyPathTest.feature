Feature: AskFm tests

  Scenario: Check sign up happy path with randomly generated email
    Given Open "ask.fm" URL
    When Accept cookies on popup
    And Press primary button "Sign in"
    And Get Sign In Page
    And Accept cookies on tab
    And Fill Log In fields. User: "existing@user.email", Password: "superSecretPa$$woRd"
    And Push Log In button
    Then Verify Feed Page appeared
    And Close browser
