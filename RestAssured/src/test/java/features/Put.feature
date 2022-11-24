Feature: Verify different PUT operations using REST-Assured

  @API8
  Scenario: Verify PUT Operation after POST
    Given I ensure to perform POST operation for "/posts" with body as (PUT)
      | id | title              | author            |
      | 6  | API Testing course | ExecuteAutomation |
    And   I perform PUT operation for "/posts/{postid}"
      | id | title       | author            |
      | 6  | API Testing | ExecuteAutomation |
    And   I perform GET operation with path parameter for "/posts/{postid}" (PUT)
      | postid |
      | 6      |
    Then  I "should" see the body with title as "API Testing"