Feature: Verify different POST operations using REST-Assured

  @API5
  Scenario: Verify Post Operation
    Given I perform POST operation for "/posts"

  @API6
  Scenario: Verify Post Operation for Profile
    Given I perform POST operation for "/posts/{profileNo}/profile" with body
      | name | profile |
      | Sams | 2       |
    Then I should see the body has name as "Sams"