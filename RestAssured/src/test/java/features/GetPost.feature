Feature: Verify different GET and POST operations using REST-ASSURED

########################################---GET---############################################

  @API
  Scenario Outline: Validate one author of the post
    Given User performs GET operation for "<Resource>"
    Then  User validates that in the "<Attribute>" this "<Value>" exists
    Examples:
      | Resource | Attribute | Value      |  |
      | /posts   | author    | Karthik KK |  |

  @API2
  Scenario Outline: Validate that an author collection exists
    Given User performs GET operation for "<Resource>"
    #Then  User validates that a collection of <Authors> exists
    Examples:
      | Resource | Authors                 |
      | /posts   | "Karthik KK,Karthik KK" |

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