@CANDIDATE_ERDAL1
  @API
Feature: Change password on account section for candidate account
  Scenario: As a candidate, I should be able to chane password
    When User connect "https://hyrai.com/api/user/password" and changes password
    Then User verifies the status code is 200