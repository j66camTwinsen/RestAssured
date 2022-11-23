Feature: Get a list of existing divisions in the system

  @API1
  Scenario Outline: Get a divisions list from API
    Given User sends a GET request to the "<Resource>" (Divisions)
    Then  User validates that the "<Attribute>" has this "<Value>" (Divisions)
    Examples:
      | Resource      | Attribute       | Value      |
      | /v2/divisions | Data.divisionId | -762496764 |