########################################---GET---############################################

Feature: Verify different GET operations using REST-Assured

  @API
  Scenario: Verify one author of the post
    Given I perform GET operation for "/posts"
    Then  I should see the author name as "Karthik KK"

  @API2
  Scenario: Verify collection of authors in the post
    Given I perform GET operation for "/post"
    Then  I should see the author names

  @API3
  Scenario: Verify Path parameter of Get
    Given I perform GET operation for "/post"
    Then  I should verify Path Parameter

  @API4
  Scenario: Verify Query parameter of Get
    Given I perform GET operation for "/post"
    Then  I should verify Query Parameter

########################################---POST---############################################

  @API5
  Scenario: Verify Post Operation
    Given I perform POST operation for "/posts"

  @API6
  Scenario: Verify Post Operation for Profile
    Given I perform POST operation for "/posts/{profileNo}/profile" with body
      | name | profile |
      | Sams | 2       |
    Then I should see the body has name as "Sams"