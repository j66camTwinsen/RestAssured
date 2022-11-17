Feature: Verify different GET operations using REST-Assured

  @API
  Scenario: Verify one author of the post
    Given I perform GET operation for "/post"
    When  I perform GET for the post number "1"
    Then  I should see the author name as "Karthik KK"

  @API2
  Scenario: Verify one author of the post
    Given I perform GET operation for "/post"
    Then  I should see the author names