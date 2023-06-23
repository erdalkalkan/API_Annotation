Feature: change password on account section for candidate account
  Scenario: As a candidate, I should able too change password on account section
    When User connects to "https://hyrai.com/api/user/password" and changes the password
    Then User verifies the status code is 200