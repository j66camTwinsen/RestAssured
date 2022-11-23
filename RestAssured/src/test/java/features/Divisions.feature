Feature: Get a list of existing divisions in the system

  @API1
  Scenario Outline: Get a divisions list from API
    Given User sends a GET request to the endpoint (Divisions)
    Then  User validates that the "<Attribute>" has this "<Value>" (Divisions)
    Examples:
      | Attribute       | Value      |
      | Data.divisionId | -762496764 |